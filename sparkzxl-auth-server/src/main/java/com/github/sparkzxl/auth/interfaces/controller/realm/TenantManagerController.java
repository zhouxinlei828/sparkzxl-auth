package com.github.sparkzxl.auth.interfaces.controller.tenant;


import com.github.sparkzxl.auth.application.service.ITenantManagerService;
import com.github.sparkzxl.auth.infrastructure.entity.TenantManager;
import com.github.sparkzxl.auth.interfaces.dto.manager.TenantManagerQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.manager.TenantManagerSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.manager.TenantManagerUpdateDTO;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 领域管理员管理
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:52
 */
@RestController
@ResponseResult
@Api(tags = "领域管理员管理")
@RequestMapping("/tenant/manager")
public class TenantManagerController extends SuperCacheController<ITenantManagerService, Long,
        TenantManager, TenantManagerSaveDTO, TenantManagerUpdateDTO, TenantManagerQueryDTO, Object> {

}
