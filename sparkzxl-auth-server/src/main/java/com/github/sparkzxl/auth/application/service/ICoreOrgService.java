package com.github.sparkzxl.auth.application.service;


import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgUpdateDTO;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgUserSaveDTO;
import com.github.sparkzxl.database.base.service.SuperService;

import java.util.List;

/**
 * description: 组织 服务类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:24
 */
public interface ICoreOrgService extends SuperService<CoreOrg> {

    /**
     * 查询组织列表
     *
     * @param name   名称
     * @param status 状态
     * @return List<CoreOrg>
     */
    List<CoreOrg> getCoreOrgTree(String name, Boolean status);

    /**
     * 根据名称获取组织信息
     *
     * @param name 名称
     * @return CoreOrg
     */
    CoreOrg getCoreOrgByName(String name);

    /**
     * 新增组织
     *
     * @param orgSaveDTO 组织保存DTO
     * @return boolean
     */
    boolean saveCoreOrg(OrgSaveDTO orgSaveDTO);

    /**
     * 修改组织
     *
     * @param orgUpdateDTO 组织更新DTO
     * @return boolean
     */
    boolean updateCoreOrg(OrgUpdateDTO orgUpdateDTO);

    /**
     * 批量删除组织
     *
     * @param ids 组织id列表
     * @return boolean
     */
    boolean deleteBatchCoreOrg(List<Long> ids);

    /**
     * 更新组织用户
     *
     * @param orgUserSaveDTO 组织用户保存DTO
     * @return boolean
     */
    boolean updateOrgUser(OrgUserSaveDTO orgUserSaveDTO);
}
