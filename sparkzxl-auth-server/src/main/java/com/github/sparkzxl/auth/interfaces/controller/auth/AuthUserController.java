package com.github.sparkzxl.auth.interfaces.controller.auth;

import cn.hutool.core.util.DesensitizedUtil;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.api.IAuthUserApi;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.auth.application.event.ImportUserDataListener;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.excel.UserExcel;
import com.github.sparkzxl.auth.infrastructure.convert.AuthUserConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.interfaces.dto.user.UserQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperController;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * description: 用户管理
 *
 * @author charles.zhou
 * @date 2020-05-24 12:25:32
 */
@RestController
@RequestMapping("/user")
@Response
@HttpRequestLog
@Api(tags = "用户管理")
public class AuthUserController extends SuperController<IUserService, Long,
        AuthUser, UserSaveDTO, UserUpdateDTO, UserQueryDTO, UserExcel> implements IAuthUserApi {

    private ImportUserDataListener importUserDataListener;

    @Autowired
    public void setImportUserDataListener(ImportUserDataListener importUserDataListener) {
        this.importUserDataListener = importUserDataListener;
    }

    @Override
    public PageInfo<AuthUser> page(PageParams<UserQueryDTO> params) {
        return baseService.getAuthUserPage(params);
    }

    @Override
    public boolean save(UserSaveDTO userSaveDTO) {
        return baseService.saveAuthUser(userSaveDTO);
    }

    @Override
    public boolean update(UserUpdateDTO userUpdateDTO) {
        return baseService.updateAuthUser(userUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteAuthUser(deleteDTO.getIds());
    }

    @Override
    public void handlerEntity(AuthUser entity) {
        entity.setPassword(DesensitizedUtil.password(entity.getPassword()));
    }

    @ApiOperation(value = "用户路由菜单", notes = "用户路由菜单")
    @GetMapping("/routers")
    public List<MenuBasicInfo> routers(@ApiIgnore AuthUserInfo<UserDetail> authUserInfo) {
        return baseService.routers(Long.valueOf(authUserInfo.getId()));
    }

    @Override
    public UserDetailInfo getUserDetailInfo(String username) {
        return baseService.getUserDetailInfo(username);
    }

    @Override
    public AuthUserInfo<UserDetail> getAuthUserInfo(String username) {
        return baseService.getAuthUserInfo(username);
    }

    @Override
    public AuthUserBasicVO getUserByUserId(Long userId) {
        return baseService.getAuthUserBasicInfo(userId);
    }


    @Override
    public AuthUserBasicVO getUserByUsername(String username) {
        return baseService.getUserByUsername(username);
    }

    @Override
    public boolean handlerExcelQueryList(UserQueryDTO userQueryDTO, List<AuthUser> authUsers) {
        authUsers.addAll(baseService.userList(userQueryDTO));
        return true;
    }

    @Override
    public List<UserExcel> convertExcels(List<AuthUser> authUsers) {
        return AuthUserConvert.INSTANCE.convertUserExcels(authUsers);
    }

    @Override
    public ImportDataListener<UserExcel> getImportDataListener() {
        return importUserDataListener;
    }

    @Override
    public Class<?> importExcelClass() {
        return UserExcel.class;
    }
}
