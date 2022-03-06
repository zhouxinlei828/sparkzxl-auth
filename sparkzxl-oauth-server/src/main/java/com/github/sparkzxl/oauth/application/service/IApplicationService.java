package com.github.sparkzxl.oauth.application.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.base.service.SuperService;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.oauth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.oauth.interfaces.dto.application.AuthApplicationQueryDTO;
import com.github.sparkzxl.oauth.interfaces.dto.application.AuthApplicationSaveDTO;
import com.github.sparkzxl.oauth.interfaces.dto.application.AuthApplicationUpdateDTO;

import java.util.List;

/**
 * description: 租户信息客户端服务类
 *
 * @author charles.zhou
 * @date 2021-02-20 09:44:35
 */
public interface IApplicationService extends SuperService<AuthApplication> {

    /**
     * 保存应用客户端信息
     *
     * @param authApplicationSaveDTO 应用保存DTO
     * @return boolean
     */
    boolean saveApplication(AuthApplicationSaveDTO authApplicationSaveDTO);

    /**
     * 获取客户端分页
     *
     * @param params 应用分页DTO
     * @return PageInfo<OauthClientDetails>
     */
    PageInfo<AuthApplication> listPage(PageParams<AuthApplicationQueryDTO> params);

    /**
     * 查询应用列表
     *
     * @return List<AuthApplication>
     */
    List<AuthApplication> applicationList();

    /**
     * 删除客户端
     *
     * @param ids 应用id列表
     * @return boolean
     */
    boolean deleteApplication(List<Long> ids);

    /**
     * 更新客户端信息
     *
     * @param authApplicationUpdateDTO 应用客户端更新DTO
     * @return boolean
     */
    boolean updateApplication(AuthApplicationUpdateDTO authApplicationUpdateDTO);

}
