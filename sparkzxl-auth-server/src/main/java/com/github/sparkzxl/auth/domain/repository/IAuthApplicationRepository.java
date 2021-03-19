package com.github.sparkzxl.auth.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;

import java.util.List;

/**
 * description: 应用 仓储类
 *
 * @author charles.zhou
 * @date 2021-02-20 09:51:03
 */
public interface IAuthApplicationRepository {

    /**
     * 保存应用
     *
     * @param application 应用
     * @return boolean
     */
    boolean saveAuthApplication(AuthApplication application);

    /**
     * 获取客户端分页
     *
     * @param pageNum  当前页
     * @param pageSize 分页大小
     * @param clientId 客户端id
     * @param appName  应用名称
     * @return PageInfo<OauthClientDetails>
     */
    PageInfo<AuthApplication> listPage(int pageNum, int pageSize, String clientId, String appName);

    /**
     * 删除客户端
     *
     * @param ids id列表
     * @return boolean
     */
    boolean deleteAuthApplication(List<Long> ids);

    /**
     * 更新应用信息
     *
     * @param application 应用信息
     * @return boolean
     */
    boolean updateAuthApplication(AuthApplication application);

    /**
     * 查询应用列表
     *
     * @return List<AuthApplication>
     */
    List<AuthApplication> applicationList();

}
