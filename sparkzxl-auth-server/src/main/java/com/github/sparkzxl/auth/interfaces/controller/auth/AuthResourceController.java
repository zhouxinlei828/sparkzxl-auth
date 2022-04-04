package com.github.sparkzxl.auth.interfaces.controller.auth;


import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.auth.application.service.IResourceService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.domain.model.dto.resource.ResourceQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.resource.ResourceSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.resource.ResourceUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * description: 资源管理
 *
 * @author charles.zhou
 * @date 2020-06-07 13:39:30
 */
@RestController
@RequestMapping("/resource")
@Response
@HttpRequestLog
@Api(tags = "资源管理")
public class AuthResourceController extends SuperController<IResourceService, Long,
        AuthResource, ResourceSaveDTO, ResourceUpdateDTO, ResourceQueryDTO, Object> {


    @ApiOperation("查询用户可用的所有资源")
    @GetMapping("/visible")
    public List<AuthResource> visible(@ApiIgnore AuthUserInfo<UserDetail> authUserInfo, ResourceQueryDTO resourceQueryDTO) {
        return baseService.findVisibleResource(Long.valueOf(authUserInfo.getId()), resourceQueryDTO);
    }

    @Override
    public boolean update(ResourceUpdateDTO authResourceUpdateDTO) {
        return baseService.updateResource(authResourceUpdateDTO);
    }

    @Override
    public void handlerQueryParams(PageParams<ResourceQueryDTO> params) {
        ResourceQueryDTO paramsModel = params.getModel();
        if (StringUtils.isEmpty(paramsModel.getCode())) {
            paramsModel.setCode(null);
        }
        if (StringUtils.isEmpty(paramsModel.getName())) {
            paramsModel.setName(null);
        }
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteResource(deleteDTO.getIds());
    }
}
