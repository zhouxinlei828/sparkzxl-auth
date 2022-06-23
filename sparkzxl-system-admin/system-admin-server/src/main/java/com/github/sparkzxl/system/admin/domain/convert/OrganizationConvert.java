package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Organization;
import com.github.sparkzxl.system.admin.api.model.dto.OrganizationDTO;
import com.github.sparkzxl.system.admin.api.model.vo.OrganizationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 组织 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface OrganizationConvert {

    OrganizationConvert INSTANCE = Mappers.getMapper(OrganizationConvert.class);

    /**
     * organizationDTO转换为Organization
     *
     * @param organizationDTO 组织DTO对象
     * @return Organization
     */
    Organization convertOrganization(OrganizationDTO organizationDTO);

    /**
     * Organization转换为OrganizationVO
     *
     * @param organization 组织DTO对象
     * @return OrganizationVO
     */
    OrganizationVO convertOrganizationVO(Organization organization);

    /**
     * organization列表转换为OrganizationVO列表
     *
     * @param organizationList 组织列表
     * @return List<OrganizationVO>
     */
    List<OrganizationVO> convertOrganizationVOList(List<Organization> organizationList);

    /**
     * 组织分页对象转换为OrganizationVO分页对象
     *
     * @param organizationPage 组织分页对象
     * @return Page<OrganizationVO>
     */
    Page<OrganizationVO> convertOrganizationPageVO(Page<Organization> organizationPage);
}
