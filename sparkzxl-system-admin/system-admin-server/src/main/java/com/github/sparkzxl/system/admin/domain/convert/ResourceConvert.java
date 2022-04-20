package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Resource;
import com.github.sparkzxl.system.admin.api.model.dto.ResourceDTO;
import com.github.sparkzxl.system.admin.api.model.vo.ResourceVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 资源信息 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface ResourceConvert {

    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);

    /**
     * resourceDTO转换为Resource
     *
     * @param resourceDTO 资源信息DTO对象
     * @return Resource
     */
    Resource convertResource(ResourceDTO resourceDTO);

    /**
     * Resource转换为ResourceVO
     *
     * @param resource 资源信息DTO对象
     * @return ResourceVO
     */
    ResourceVO convertResourceVO(Resource resource);

    /**
     * resource列表转换为ResourceVO列表
     *
     * @param resourceList 资源信息列表
     * @return List<ResourceVO>
     */
    List<ResourceVO> convertResourceVOList(List<Resource> resourceList);

    /**
     * 资源信息分页对象转换为ResourceVO分页对象
     *
     * @param resourcePage 资源信息分页对象
     * @return Page<ResourceVO>
     */
    Page<ResourceVO> convertResourcePageVO(Page<Resource> resourcePage);
}
