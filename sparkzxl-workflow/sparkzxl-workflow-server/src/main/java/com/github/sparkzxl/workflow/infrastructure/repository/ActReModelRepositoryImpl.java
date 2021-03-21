package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import com.github.sparkzxl.workflow.domain.repository.IActReModelRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ActReModel;
import com.github.sparkzxl.workflow.infrastructure.mapper.ActReModelMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * description: 模型 仓储实现类
 *
 * @author charles.zhou
 * @date   2020-07-25 11:17:47
 */
@Repository
public class ActReModelRepositoryImpl implements IActReModelRepository {

    @Autowired
    private ActReModelMapper actReModelMapper;

    @Override
    public PageInfo<ActReModel> actReModelList(String key, String name) {
        LambdaQueryWrapper<ActReModel> modelQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(key)){
            modelQueryWrapper.eq(ActReModel::getKey,key);
        }
        if (StringUtils.isNotBlank(name)){
            modelQueryWrapper.eq(ActReModel::getName,name);
        }
        return PageInfoUtils.pageInfo(actReModelMapper.selectList(modelQueryWrapper));
    }
}
