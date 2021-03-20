package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.infrastructure.entity.RealmPool;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: RealmPoolConvert 对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface RealmPoolConvert {

    RealmPoolConvert INSTANCE = Mappers.getMapper(RealmPoolConvert.class);

    /**
     * tenantSaveDTO转换为RealmPool
     *
     * @param realmPoolSaveDTO 领域池保存对象
     * @return RealmPool
     */
    RealmPool convertRealmPool(RealmPoolSaveDTO realmPoolSaveDTO);

    /**
     * tenantUpdateDTO转换为RealmPool
     *
     * @param realmPoolUpdateDTO 领域池更新对象
     * @return RealmPool
     */
    RealmPool convertRealmPool(RealmPoolUpdateDTO realmPoolUpdateDTO);
}
