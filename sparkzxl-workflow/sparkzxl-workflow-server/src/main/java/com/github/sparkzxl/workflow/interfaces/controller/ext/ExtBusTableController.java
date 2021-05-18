/*
package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusTableService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableQueryDTO;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.table.BusTableUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * description: 业务表结构管理
 *
 * @author charles.zhou
 * @date 2021-03-25 18:03:38
 *//*

@ResponseResult
@RestController
@RequestMapping("/business/table")
@WebLog
@Api(tags = "业务表结构管理")
public class ExtBusTableController extends SuperCacheController<IExtBusTableService, Long,
        ExtBusTable, BusTableSaveDTO, BusTableUpdateDTO, BusTableQueryDTO, Object> {


    @Override
    public boolean save(BusTableSaveDTO busTableSaveDTO) {
        return baseService.saveBusTable(busTableSaveDTO);
    }

    @Override
    public boolean update(BusTableUpdateDTO busTableUpdateDTO) {
        return baseService.updateBusTable(busTableUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteBusTable(deleteDTO.getIds());
    }
}
*/
