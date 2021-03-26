package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.workflow.application.service.ext.IExtBusDatasourceService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusDatasource;
import com.github.sparkzxl.workflow.interfaces.dto.datasource.BusDatasourceQueryDTO;
import com.github.sparkzxl.workflow.interfaces.dto.datasource.BusDatasourceSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.datasource.BusDatasourceUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 业务数据源管理
 *
 * @author charles.zhou
 * @date 2021-03-25 18:03:38
 */
@ResponseResult
@RestController
@RequestMapping("/business/datasource")
@WebLog
@Api(tags = "业务数据源管理")
public class ExtBusDatasourceController extends SuperCacheController<IExtBusDatasourceService, Long,
        ExtBusDatasource, BusDatasourceSaveDTO, BusDatasourceUpdateDTO, BusDatasourceQueryDTO, Object> {

}
