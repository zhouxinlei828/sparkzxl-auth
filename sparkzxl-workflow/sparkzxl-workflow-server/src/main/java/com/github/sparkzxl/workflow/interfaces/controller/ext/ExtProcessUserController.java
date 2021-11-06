package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.workflow.application.event.ImportUserDataListener;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessUserService;
import com.github.sparkzxl.workflow.domain.model.aggregates.excel.ProcessUserExcel;
import com.github.sparkzxl.workflow.infrastructure.convert.ProcessUserConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.interfaces.dto.user.ProcessUserQueryDTO;
import com.github.sparkzxl.workflow.interfaces.dto.user.ProcessUserSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.user.ProcessUserUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 流程用户管理
 *
 * @author charles.zhou
 * @date 2021-01-08 17:12:52
 */
@Api(tags = "流程用户管理")
@HttpRequestLog
@Response
@RestController
@RequestMapping("/process/user")
public class ExtProcessUserController extends SuperCacheController<IExtProcessUserService, Long, ExtProcessUser,
        ProcessUserSaveDTO, ProcessUserUpdateDTO, ProcessUserQueryDTO, ProcessUserExcel> {

    private ImportUserDataListener importUserDataListener;

    @Autowired
    public void setImportUserDataListener(ImportUserDataListener importUserDataListener) {
        this.importUserDataListener = importUserDataListener;
    }

    @Override
    public boolean handlerExcelQueryList(ProcessUserQueryDTO userQueryDTO, List<ExtProcessUser> authUsers) {
        authUsers.addAll(baseService.userList(userQueryDTO));
        return true;
    }

    @Override
    public List<ProcessUserExcel> convertExcels(List<ExtProcessUser> authUsers) {
        return ProcessUserConvert.INSTANCE.convertUserExcels(authUsers);
    }

    @Override
    public ImportDataListener<ProcessUserExcel> getImportDataListener() {
        return importUserDataListener;
    }

    @Override
    public Class<?> importExcelClass() {
        return ProcessUserExcel.class;
    }
}
