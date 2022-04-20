package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Parameter;
import com.github.sparkzxl.system.admin.api.model.dto.ParameterDTO;
import com.github.sparkzxl.system.admin.api.model.vo.ParameterVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 系统参数 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface ParameterConvert {

    ParameterConvert INSTANCE = Mappers.getMapper(ParameterConvert.class);

    /**
     * parameterDTO转换为Parameter
     *
     * @param parameterDTO 系统参数DTO对象
     * @return Parameter
     */
    Parameter convertParameter(ParameterDTO parameterDTO);

    /**
     * Parameter转换为ParameterVO
     *
     * @param parameter 系统参数DTO对象
     * @return ParameterVO
     */
    ParameterVO convertParameterVO(Parameter parameter);

    /**
     * parameter列表转换为ParameterVO列表
     *
     * @param parameterList 系统参数列表
     * @return List<ParameterVO>
     */
    List<ParameterVO> convertParameterVOList(List<Parameter> parameterList);

    /**
     * 系统参数分页对象转换为ParameterVO分页对象
     *
     * @param parameterPage 系统参数分页对象
     * @return Page<ParameterVO>
     */
    Page<ParameterVO> convertParameterPageVO(Page<Parameter> parameterPage);
}
