package com.github.sparkzxl.auth.interfaces.controller.core;


import com.github.sparkzxl.auth.application.service.ICoreOrgService;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 组织 前端控制器
 *
 * @author charles.zhou
 * @date 2020-06-07 13:40:59
 */
@RestController
@ResponseResult
@WebLog
@Api(tags = "组织管理")
@RequestMapping("/org")
public class OrgController extends SuperCacheController<ICoreOrgService, Long,
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

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteBatchCoreOrg(deleteDTO.getIds());
    }
}
