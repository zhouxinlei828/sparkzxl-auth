package com.github.sparkzxl.workflow.infrastructure.convert;

import com.github.sparkzxl.workflow.domain.model.InstanceOverviewCount;
import com.github.sparkzxl.workflow.domain.vo.InstanceOverview;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: ExtProcessStatusConvert
 *
 * @author charles.zhou
 * @date   2020-12-18 09:15:51
*/
@Mapper
public interface ExtProcessStatusConvert {

    ExtProcessStatusConvert INSTANCE = Mappers.getMapper(ExtProcessStatusConvert.class);

    /**
     * 流程统计转换
     * @param instanceOverviewCount 流程统计总览
     * @return InstanceOverview
     */
    InstanceOverview convertInstanceOverviewCount(InstanceOverviewCount instanceOverviewCount);

}
