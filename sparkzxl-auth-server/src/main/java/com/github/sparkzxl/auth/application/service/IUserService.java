package com.github.sparkzxl.auth.application.service;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.interfaces.dto.user.UserQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserUpdateDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description: 用户查询 服务类
 *
 * @author charles.zhou
 * @date 2020-05-24 12:22:23
 */
public interface IUserService extends SuperCacheService<AuthUser> {

    /**
     * 获取全局用户信息
     *
     * @param username 用户账户
     * @return AuthUserInfo<UserDetail>
     */
    AuthUserInfo<UserDetail> getAuthUserInfo(String username);

    /**
     * 根据账户查询用户信息
     *
     * @param username 账户
     * @return AuthUser
     */
    AuthUser getByAccount(String username);

    /**
     * 获取用户分页
     *
     * @param params 分页入参
     * @return PageInfo<AuthUser>
     */
    PageInfo<AuthUser> getAuthUserPage(PageParams<UserQueryDTO> params);

    /**
     * 保存用户信息
     *
     * @param userSaveDTO AuthUserSaveDTO保存对象
     * @return boolean
     */
    boolean saveAuthUser(UserSaveDTO userSaveDTO);

    /**
     * 修改用户信息
     *
     * @param userUpdateDTO AuthUserSaveDTO修改对象
     * @return boolean
     */
    boolean updateAuthUser(UserUpdateDTO userUpdateDTO);

    /**
     * 生成仿真数据
     *
     * @return boolean
     */
    boolean mockUserData();

    /**
     * 获取登录用户全量信息
     *
     * @param userId 用户id
     * @return AuthUserBasicVO
     */
    AuthUserBasicVO getAuthUserBasicInfo(Long userId);

    /**
     * 用户菜单
     *
     * @param userId 用户id
     * @return List<MenuBasicInfo>
     */
    List<MenuBasicInfo> routers(Long userId);

    /**
     * Excel导入用户数据
     *
     * @param multipartFile 文件
     * @return Integer
     */
    Integer importUserData(MultipartFile multipartFile);

    /**
     * 查询用户列表
     *
     * @param userQueryDTO 用户查询参数
     * @return List<AuthUser>
     */
    List<AuthUser> userList(UserQueryDTO userQueryDTO);

    /**
     * 删除用户信息
     *
     * @param ids ids
     * @return boolean
     */
    boolean deleteAuthUser(List<Long> ids);

    /**
     * 获取用户角色
     *
     * @param id 用户id
     * @return List<String>
     */
    List<String> getAuthUserRoles(Long id);

    /**
     * 获取用户详细信息
     *
     * @param username 用户名
     * @return UserDetailInfo
     */
    UserDetailInfo getUserDetailInfo(String username);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return AuthUserBasicVO
     */
    AuthUserBasicVO getUserByUsername(String username);
}
