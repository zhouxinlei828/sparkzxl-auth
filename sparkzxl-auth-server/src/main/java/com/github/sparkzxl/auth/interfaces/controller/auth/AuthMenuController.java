package com.github.sparkzxl.auth.interfaces.controller.auth;


import cn.hutool.core.convert.Convert;
import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.application.service.IMenuService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.auth.interfaces.dto.menu.AuthMenuQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.menu.AuthMenuSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.menu.AuthMenuUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 资源管理
 *
 * @author charles.zhou
 * @date 2020-06-07 13:39:30
 */
@RestController
@RequestMapping("/menu")
@Response
@HttpRequestLog
@Api(tags = "菜单管理")
public class AuthMenuController extends SuperCacheController<IMenuService, Long,
        AuthMenu, AuthMenuSaveDTO, AuthMenuUpdateDTO, AuthMenuQueryDTO, Object> {

    @Override
    public boolean handlerSave(AuthMenuSaveDTO model) {
        model.setIsEnable(Convert.toBool(model.getIsEnable(), true));
        model.setHidden(Convert.toBool(model.getHidden(), true));
        model.setNoKeepAlive(Convert.toBool(model.getNoKeepAlive(), true));
        model.setParentId(Convert.toLong(model.getParentId(), 0L));
        return true;
    }

    @Override
    public boolean save(AuthMenuSaveDTO authMenuSaveDTO) {
        return super.baseService.saveMenu(authMenuSaveDTO);
    }

    @ApiOperation(value = "查询所有的菜单", notes = "查询所有的菜单")
    @GetMapping("/tree")
    public List<AuthMenu> allTree(@RequestParam(value = "label", required = false) String label) {
        return baseService.findMenuTree(label);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteMenu(deleteDTO.getIds());
    }
}
