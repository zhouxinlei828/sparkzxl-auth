package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.system.admin.api.model.dto.RoleAuthorityDTO;
import com.github.sparkzxl.system.admin.api.model.vo.RoleAuthorityVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 角色的资源 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface RoleAuthorityConvert {

    RoleAuthorityConvert INSTANCE = Mappers.getMapper(RoleAuthorityConvert.class);

    /**
     * roleAuthorityDTO转换为RoleAuthority
     *
     * @param roleAuthorityDTO 角色的资源DTO对象
     * @return RoleAuthority
     */
    RoleAuthority convertRoleAuthority(RoleAuthorityDTO roleAuthorityDTO);

    /**
     * RoleAuthority转换为RoleAuthorityVO
     *
     * @param roleAuthority 角色的资源DTO对象
     * @return RoleAuthorityVO
     */
    RoleAuthorityVO convertRoleAuthorityVO(RoleAuthority roleAuthority);

    /**
     * roleAuthority列表转换为RoleAuthorityVO列表
     *
     * @param roleAuthorityList 角色的资源列表
     * @return List<RoleAuthorityVO>
     */
    List<RoleAuthorityVO> convertRoleAuthorityVOList(List<RoleAuthority> roleAuthorityList);

    /**
     * 角色的资源分页对象转换为RoleAuthorityVO分页对象
     *
     * @param roleAuthorityPage 角色的资源分页对象
     * @return Page<RoleAuthorityVO>
     */
    Page<RoleAuthorityVO> convertRoleAuthorityPageVO(Page<RoleAuthority> roleAuthorityPage);
}
