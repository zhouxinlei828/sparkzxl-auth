package com.github.sparkzxl.workflow.infrastructure.convert;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: ExtBusTableConvert
 *
 * @author charles.zhou
 * @date 2020-12-18 09:15:51
 */
@Mapper
public interface ExtBusTableConvert {

    ExtBusTableConvert INSTANCE = Mappers.getMapper(ExtBusTableConvert.class);

    /**
     * 业务表结构保存转换
     *
     * @param busTableSaveDTO 业务表结构保存对象
     * @return ExtBusTable
     */
    ExtBusTable convertExtBusTable(BusTableSaveDTO busTableSaveDTO);

    /**
     * 业务表结构保存转换
     *
     * @param busTableUpdateDTO 业务表结构更新对象
     * @return ExtBusTable
     */
    ExtBusTable convertExtBusTable(BusTableUpdateDTO busTableUpdateDTO);

}
