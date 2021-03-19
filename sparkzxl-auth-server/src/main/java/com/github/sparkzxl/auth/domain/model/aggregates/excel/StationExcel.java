package com.github.sparkzxl.auth.domain.model.aggregates.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * description: 岗位Excel实体类
 *
 * @author charles.zhou
 * @date   2021-01-04 15:24:30
 */
@Data
public class StationExcel {

    @ExcelProperty("岗位名称")
    private String name;

    @ExcelProperty("描述")
    private String describe;

    @ExcelProperty("组织")
    private String orgName;

}
