package com.github.sparkzxl.workflow.infrastructure.repository;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.db.Db;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
import com.github.sparkzxl.workflow.domain.repository.IExtBusTableRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusDatasource;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTableColumn;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusDatasourceMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableColumnMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * description: 业务表结构 仓储实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 13:32:27
 */
@Repository
public class ExtBusTableRepository implements IExtBusTableRepository {

    private ExtBusTableMapper busTableMapper;

    private ExtBusTableColumnMapper tableColumnMapper;

    private ExtBusDatasourceMapper busDatasourceMapper;


    @Autowired
    public void setBusTableMapper(ExtBusTableMapper busTableMapper) {
        this.busTableMapper = busTableMapper;
    }

    @Autowired
    public void setTableColumnMapper(ExtBusTableColumnMapper tableColumnMapper) {
        this.tableColumnMapper = tableColumnMapper;
    }

    @Autowired
    public void setBusDatasourceMapper(ExtBusDatasourceMapper busDatasourceMapper) {
        this.busDatasourceMapper = busDatasourceMapper;
    }

    @Override
    public boolean saveBusTable(ExtBusTable extBusTable) {
        busTableMapper.insert(extBusTable);
        List<ExtBusTableColumn> columnList = extBusTable.getColumnList();
        if (CollectionUtils.isNotEmpty(columnList)) {
            columnList.forEach(column -> column.setTableId(extBusTable.getId()));
            tableColumnMapper.insertBatchSomeColumn(columnList);
        }
        ExtBusDatasource extBusDatasource = busDatasourceMapper.selectById(extBusTable.getDataSourceId());
        if (ObjectUtils.isEmpty(extBusDatasource)) {
            SparkZxlExceptionAssert.businessFail("数据源为空");
        }
        DataSource dataSource = DataSourceBuilder.create().url(extBusDatasource.getJdbcUrl())
                .username(extBusDatasource.getUsername())
                .password(extBusDatasource.getPassword())
                .driverClassName(extBusDatasource.getDriverClassName()).build();
        String createTableSql = buildCreateTableSql(extBusTable.getTableName(), extBusTable.getDescribe(), columnList);
        try {
            Db.use(dataSource).execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean updateBusTable(ExtBusTable extBusTable) {
        busTableMapper.updateById(extBusTable);
        List<ExtBusTableColumn> columnList = extBusTable.getColumnList();
        tableColumnMapper.delete(new LambdaQueryWrapper<ExtBusTableColumn>().eq(ExtBusTableColumn::getTableId, extBusTable.getId()));
        if (CollectionUtils.isNotEmpty(columnList)) {
            columnList.forEach(column -> column.setTableId(extBusTable.getId()));
            tableColumnMapper.insertBatchSomeColumn(columnList);
        }
        return true;
    }

    @Override
    public boolean deleteBusTable(List<Long> ids) {
        tableColumnMapper.delete(new LambdaQueryWrapper<ExtBusTableColumn>().in(ExtBusTableColumn::getTableId, ids));
        busTableMapper.deleteBatchIds(ids);
        return true;
    }

    public static String buildCreateTableSql(String tableName, String describe, List<ExtBusTableColumn> columnList) {
        StrBuilder createTableSql = new StrBuilder("create table ", tableName, " (");
        String primaryKey = "";
        for (ExtBusTableColumn tableColumn : columnList) {
            String field = tableColumn.getField();
            createTableSql.append("\n`");
            createTableSql.append(field);
            createTableSql.append("` ");
            String fieldType = tableColumn.getFieldType();
            createTableSql.append(fieldType);
            Integer fieldLength = tableColumn.getFieldLength();
            if (ObjectUtils.isNotEmpty(fieldLength)) {
                createTableSql.append("(");
                createTableSql.append(fieldLength);
                createTableSql.append(") ");
            }
            if ("varchar".equalsIgnoreCase(fieldType)) {
                createTableSql.append("CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci");
            }
            if (tableColumn.getRequired()) {
                createTableSql.append(" NOT NULL ");
                if (StringUtils.isNotEmpty(tableColumn.getDefaultValue())){
                    if ("varchar".equalsIgnoreCase(fieldType)){
                        createTableSql.append(" DEFAULT '");
                        createTableSql.append(tableColumn.getDefaultValue());
                        createTableSql.append("'");
                    }else {
                        createTableSql.append(" DEFAULT ");
                        createTableSql.append(tableColumn.getDefaultValue());
                        createTableSql.append(" ");
                    }
                }
            } else {
                createTableSql.append(" DEFAULT NULL ");
            }
            if (ObjectUtils.isNotEmpty(tableColumn.getPrimaryKey()) && tableColumn.getPrimaryKey()) {
                primaryKey = field;
            }
            if (StringUtils.isNotEmpty(tableColumn.getName())) {
                createTableSql.append(" COMMENT '");
                createTableSql.append(tableColumn.getName());
                createTableSql.append("'");
            }
            createTableSql.append(",");
        }
        createTableSql.append("\nPRIMARY KEY (`");
        createTableSql.append(primaryKey);
        createTableSql.append("`) ");
        createTableSql.append("\n) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC ");
        createTableSql.append("COMMENT='");
        createTableSql.append(describe);
        createTableSql.append("';");
        createTableSql.append("\nSET FOREIGN_KEY_CHECKS = 1;");
        return createTableSql.toString();
    }

    public static void main(String[] args) {
        List<ExtBusTableColumn> columnList = Lists.newArrayList();
        ExtBusTableColumn busTableColumn = new ExtBusTableColumn();
        busTableColumn.setName("主键");
        busTableColumn.setField("id");
        busTableColumn.setFieldType("bigint");
        busTableColumn.setPrimaryKey(true);
        busTableColumn.setRequired(true);
        busTableColumn.setFieldLength(20);
        columnList.add(busTableColumn);

        ExtBusTableColumn busTableColumn01 = new ExtBusTableColumn();
        busTableColumn01.setName("流程实例id");
        busTableColumn01.setFieldType("varchar");
        busTableColumn01.setField("process_instance_id");
        busTableColumn01.setRequired(true);
        busTableColumn01.setFieldLength(255);
        columnList.add(busTableColumn01);

        ExtBusTableColumn busTableColumn02 = new ExtBusTableColumn();
        busTableColumn02.setName("任务id");
        busTableColumn02.setFieldType("varchar");
        busTableColumn02.setField("task_id");
        busTableColumn02.setRequired(true);
        busTableColumn02.setFieldLength(255);
        columnList.add(busTableColumn02);

        ExtBusTableColumn busTableColumn03 = new ExtBusTableColumn();
        busTableColumn03.setName("任务定义key");
        busTableColumn03.setFieldType("varchar");
        busTableColumn03.setField("task_def_key");
        busTableColumn03.setRequired(true);
        busTableColumn03.setFieldLength(255);
        columnList.add(busTableColumn03);

        String createTableSql = buildCreateTableSql("hi_task_status", "历史任务处理状态", columnList);
        System.out.println(createTableSql);
    }
}
