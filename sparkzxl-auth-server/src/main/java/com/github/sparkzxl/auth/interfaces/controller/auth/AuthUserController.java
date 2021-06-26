package com.github.sparkzxl.auth.interfaces.controller.auth;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.annotation.result.WebResult;
import com.github.sparkzxl.auth.application.event.ImportUserDataListener;
import com.github.sparkzxl.auth.application.service.IUserService;
import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.excel.UserExcel;
import com.github.sparkzxl.auth.domain.model.vo.AuthUserBasicVO;
import com.github.sparkzxl.auth.infrastructure.convert.AuthUserConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.interfaces.dto.user.UserQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@WebResult
@WebLog
@Api(tags = "用户管理")
public class AuthUserController extends SuperCacheController<IUserService, Long,
        AuthUser, UserSaveDTO, UserUpdateDTO, UserQueryDTO, UserExcel> {

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

    @ApiOperation(value = "用户路由菜单", notes = "用户路由菜单")
    @GetMapping("/routers")
    public List<MenuBasicInfo> routers(@ApiIgnore AuthUserInfo<Long> authUserInfo,
                                       @RequestParam(value = "tenantId", required = false) String tenantId) {
        return baseService.routers(authUserInfo.getId(),tenantId);
    }

    @ApiOperation("获取用户基本信息")
    @GetMapping("/userinfo")
    public AuthUserBasicVO getAuthUserBasicInfo(@ApiIgnore AuthUserInfo<Long> authUserInfo) {
        return baseService.getAuthUserBasicInfo(authUserInfo);
    }

    @ApiOperation("生成用户测试数据")
    @GetMapping("/mockData")
    public boolean mockUserData() {
        return baseService.mockUserData();
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
