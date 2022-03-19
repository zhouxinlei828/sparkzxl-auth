package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * @date 2020-07-25 11:17:47
 */
@Repository
public class ActReModelRepositoryImpl implements IActReModelRepository {

    @Autowired
    private ActReModelMapper actReModelMapper;

    @Override
    public Page<ActReModel> actReModelList(Page<ActReModel> page, String key, String name) {
        LambdaQueryWrapper<ActReModel> modelQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(key)) {
            modelQueryWrapper.eq(ActReModel::getKey, key);
        }
        if (StringUtils.isNotBlank(name)) {
            modelQueryWrapper.eq(ActReModel::getName, name);
        }
        return actReModelMapper.selectPage(page, modelQueryWrapper);
    }
}
