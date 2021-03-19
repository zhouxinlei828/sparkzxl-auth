package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.infrastructure.entity.RealmManager;
import com.github.sparkzxl.core.entity.AuthUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: RealmManager对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface RealmManagerConvert {

    RealmManagerConvert INSTANCE = Mappers.getMapper(RealmManagerConvert.class);

    /**
     * AuthUser转化为AuthUserInfo
     *
     * @param realmManager 领域用户
     * @return AuthUserInfo
     */
    AuthUserInfo<Long> convertAuthUserInfo(RealmManager realmManager);


}
