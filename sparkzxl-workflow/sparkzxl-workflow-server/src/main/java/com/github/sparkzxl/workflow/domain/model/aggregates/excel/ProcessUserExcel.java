package com.github.sparkzxl.workflow.domain.model.aggregates.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * description: 用户Excel实体类
 *
 * @author charles.zhou
 * @date 2021-01-04 15:24:30
 */
@Data
public class ProcessUserExcel {

    @ExcelProperty("账号")
    private String account;

    @ExcelProperty("姓名")
    private String name;

}
