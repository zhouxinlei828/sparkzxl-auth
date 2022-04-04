package com.github.sparkzxl.auth.interfaces.controller.core;


import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgUserSaveDTO;
import com.github.sparkzxl.database.base.controller.SuperController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: 组织管理
 *
 * @author charles.zhou
 * @date 2020-06-07 13:40:59
 */
@RestController
@Response
@HttpRequestLog
@Api(tags = "组织管理")
@RequestMapping("/org")
public class OrgController extends SuperController<ICoreOrgService, Long,
        CoreOrg, OrgSaveDTO, OrgUpdateDTO, OrgQueryDTO, Object> {

    @ApiOperation("组织树查询")
    @GetMapping("/tree")
    public List<CoreOrg> getCoreOrgTree(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "status", required = false) Boolean status) {
        return baseService.getCoreOrgTree(name, status);
    }

    @Override
    public boolean save(OrgSaveDTO orgSaveDTO) {
        return baseService.saveCoreOrg(orgSaveDTO);
    }

    @Override
    public boolean update(OrgUpdateDTO orgUpdateDTO) {
        return baseService.updateCoreOrg(orgUpdateDTO);
    }

    @ApiOperation("更新组织用户")
    @PostMapping("users")
    public boolean updateOrgUser(@RequestBody @Validated OrgUserSaveDTO orgUserSaveDTO) {
        return baseService.updateOrgUser(orgUserSaveDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteBatchCoreOrg(deleteDTO.getIds());
    }
}
