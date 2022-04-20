package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Application;
import com.github.sparkzxl.system.admin.api.model.dto.ApplicationDTO;
import com.github.sparkzxl.system.admin.api.model.vo.ApplicationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 应用 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface ApplicationConvert {

    ApplicationConvert INSTANCE = Mappers.getMapper(ApplicationConvert.class);

    /**
     * applicationDTO转换为Application
     *
     * @param applicationDTO 应用DTO对象
     * @return Application
     */
    Application convertApplication(ApplicationDTO applicationDTO);

    /**
     * Application转换为ApplicationVO
     *
     * @param application 应用DTO对象
     * @return ApplicationVO
     */
    ApplicationVO convertApplicationVO(Application application);

    /**
     * application列表转换为ApplicationVO列表
     *
     * @param applicationList 应用列表
     * @return List<ApplicationVO>
     */
    List<ApplicationVO> convertApplicationVOList(List<Application> applicationList);

    /**
     * 应用分页对象转换为ApplicationVO分页对象
     *
     * @param applicationPage 应用分页对象
     * @return Page<ApplicationVO>
     */
    Page<ApplicationVO> convertApplicationPageVO(Page<Application> applicationPage);
}
