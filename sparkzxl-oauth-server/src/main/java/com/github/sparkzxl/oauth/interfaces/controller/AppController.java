package com.github.sparkzxl.oauth.interfaces.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.database.base.controller.SuperController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.oauth.application.service.IApplicationService;
import com.github.sparkzxl.oauth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.oauth.domain.model.dto.AuthApplicationQueryDTO;
import com.github.sparkzxl.oauth.domain.model.dto.AuthApplicationSaveDTO;
import com.github.sparkzxl.oauth.domain.model.dto.AuthApplicationUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 应用客户端管理
 *
 * @author charles.zhou
 * @date 2021-02-02 11:31:18
 */
@RestController
@Api(tags = "应用客户端管理")
@Response
@RequestMapping("/application")
public class AppController extends SuperController<IApplicationService, Long,
        AuthApplication, AuthApplicationSaveDTO, AuthApplicationUpdateDTO, AuthApplicationQueryDTO, Object> {

    @Override
    public boolean save(AuthApplicationSaveDTO authApplicationSaveDTO) {
        return baseService.saveApplication(authApplicationSaveDTO);
    }

    @Override
    public boolean update(AuthApplicationUpdateDTO authApplicationUpdateDTO) {
        return baseService.updateApplication(authApplicationUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteApplication(deleteDTO.getIds());
    }

    @Override
    public Page<AuthApplication> page(PageParams<AuthApplicationQueryDTO> params) {
        return baseService.listPage(params);
    }
}
