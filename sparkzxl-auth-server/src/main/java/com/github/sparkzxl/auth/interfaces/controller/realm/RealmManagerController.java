package com.github.sparkzxl.auth.interfaces.controller.realm;


import com.github.sparkzxl.auth.application.service.IRealmManagerService;
import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.auth.interfaces.dto.manager.RealmManagerQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.manager.RealmManagerSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.manager.RealmManagerUpdateDTO;
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
@RequestMapping("/realm/manager")
public class RealmManagerController extends SuperCacheController<IRealmManagerService, Long,
        RealmManager, RealmManagerSaveDTO, RealmManagerUpdateDTO, RealmManagerQueryDTO, Object> {

}
