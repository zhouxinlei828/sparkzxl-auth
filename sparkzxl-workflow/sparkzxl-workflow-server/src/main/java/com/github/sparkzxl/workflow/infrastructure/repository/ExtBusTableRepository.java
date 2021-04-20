package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.workflow.application.service.es.IEsExtBusTableService;
import com.github.sparkzxl.workflow.domain.repository.IExtBusTableRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTableColumn;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableColumnMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 业务表结构 仓储实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 13:32:27
 */
@Repository
public class ExtBusTableRepository implements IExtBusTableRepository {

    @Autowired
    private ExtBusTableMapper busTableMapper;

    @Autowired
    private ExtBusTableColumnMapper tableColumnMapper;

    @Autowired
    private IEsExtBusTableService esExtBusTableService;

    @Override
    public boolean saveBusTable(ExtBusTable extBusTable) {
        busTableMapper.insert(extBusTable);
        List<ExtBusTableColumn> columnList = extBusTable.getColumnList();
        if (CollectionUtils.isNotEmpty(columnList)) {
            columnList.forEach(column -> column.setTableId(extBusTable.getId()));
            tableColumnMapper.insertBatchSomeColumn(columnList);
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

    public String buildCreateTableSql(String tableName, String describe, List<ExtBusTableColumn> columnList) {
        //Map<String,Object>
        esExtBusTableService.createIndex(tableName, null);
        columnList.forEach(column -> {

        });
        return null;
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

        //String createTableSql = buildCreateTableSql("hi_task_status", "历史任务处理状态", columnList);
        //System.out.println(createTableSql);
    }
}
