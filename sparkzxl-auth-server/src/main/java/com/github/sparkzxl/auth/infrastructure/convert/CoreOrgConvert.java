package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.org.OrgUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: CoreOrg对象Convert
 *
 * @author charles.zhou
 * @since 2020-06-05 21:28:06
 */
@Mapper
public interface CoreOrgConvert {

    CoreOrgConvert INSTANCE = Mappers.getMapper(CoreOrgConvert.class);

    /**
     * OrgSaveDTO转化为CoreOrg
     *
     * @param orgSaveDTO 组织保存对象
     * @return CoreOrg
     */
    CoreOrg convertCoreOrg(OrgSaveDTO orgSaveDTO);

    /**
     * OrgUpdateDTO转化为CoreOrg
     *
     * @param orgUpdateDTO 组织更新对象
     * @return CoreOrg
     */
    CoreOrg convertCoreOrg(OrgUpdateDTO orgUpdateDTO);
}
