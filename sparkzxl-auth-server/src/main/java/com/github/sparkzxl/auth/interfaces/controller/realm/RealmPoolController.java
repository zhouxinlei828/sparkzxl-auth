package com.github.sparkzxl.auth.interfaces.controller.realm;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.auth.application.service.IRealmPoolService;
import com.github.sparkzxl.auth.infrastructure.entity.RealmPool;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.realm.RealmPoolUpdateDTO;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.DeleteDTO;
import com.github.sparkzxl.database.dto.PageParams;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 领域池管理
 *
 * @author charles.zhou
 * @date 2021-02-02 16:21:52
 */
@RestController
@ResponseResult
@Api(tags = "领域池管理")
@RequestMapping("/realm/pool/")
public class RealmPoolController extends SuperCacheController<IRealmPoolService, Long,
        RealmPool, RealmPoolSaveDTO, RealmPoolUpdateDTO, RealmPoolQueryDTO, Object> {

    @Override
    public PageInfo<RealmPool> page(PageParams<RealmPoolQueryDTO> params) {
        return baseService.getRealmPoolPageList(params);
    }

    @Override
    public boolean save(RealmPoolSaveDTO realmPoolSaveDTO) {
        return baseService.saveRealmPool(realmPoolSaveDTO);
    }

    @Override
    public boolean update(RealmPoolUpdateDTO realmPoolUpdateDTO) {
        return baseService.updateRealmPool(realmPoolUpdateDTO);
    }

    @Override
    public boolean delete(DeleteDTO<Long> deleteDTO) {
        return baseService.deleteBatchRealmPool(deleteDTO.getIds());
    }

}
