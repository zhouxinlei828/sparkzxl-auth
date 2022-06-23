package com.github.sparkzxl.workflow.infrastructure.convert;

/**
 * description: ProcessUser 对象Convert
 *
 * @author zhouxinlei
 * @since 2021-07-17 11:30
 */

import com.github.sparkzxl.workflow.domain.model.aggregates.excel.ProcessUserExcel;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProcessUserConvert {

    ProcessUserConvert INSTANCE = Mappers.getMapper(ProcessUserConvert.class);

    /**
     * 流程用户转换
     *
     * @param userList 流程用户
     * @return List<ProcessUserExcel>
     */
    List<ProcessUserExcel> convertUserExcels(List<ExtProcessUser> userList);
}
