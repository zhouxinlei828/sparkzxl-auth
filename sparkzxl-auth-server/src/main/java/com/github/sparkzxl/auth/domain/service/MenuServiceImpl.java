package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.convert.Convert;
import com.github.sparkzxl.auth.application.service.IMenuService;
import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.infrastructure.convert.AuthMenuConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthMenuMapper;
import com.github.sparkzxl.auth.infrastructure.repository.AuthMenuRepository;
import com.github.sparkzxl.auth.interfaces.dto.menu.AuthMenuSaveDTO;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.database.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 菜单 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:35:18
 */
@Service
public class MenuServiceImpl extends SuperServiceImpl<AuthMenuMapper, AuthMenu> implements IMenuService {

    @Autowired
    private AuthMenuRepository authMenuRepository;

    @Override
    public List<AuthMenu> findMenuTree(String label) {
        return TreeUtil.buildTree(authMenuRepository.findMenuTree(label));
    }

    @Override
    public boolean deleteMenu(List<Long> ids) {
        return authMenuRepository.deleteMenu(ids);
    }

    @Override
    public List<MenuBasicInfo> routers(Long userId) {
        return authMenuRepository.getAuthMenuList(userId);
    }

    @Override
    public boolean saveMenu(AuthMenuSaveDTO authMenuSaveDTO) {
        authMenuSaveDTO.setIsEnable(Convert.toBool(authMenuSaveDTO.getIsEnable(), true));
        authMenuSaveDTO.setHidden(Convert.toBool(authMenuSaveDTO.getHidden(), true));
        authMenuSaveDTO.setNoKeepAlive(Convert.toBool(authMenuSaveDTO.getNoKeepAlive(), true));
        authMenuSaveDTO.setParentId(Convert.toLong(authMenuSaveDTO.getParentId(), 0L));
        AuthMenu authMenu = AuthMenuConvert.INSTANCE.convertAuthMenu(authMenuSaveDTO);
        return authMenuRepository.saveMenu(authMenu);
    }
}
