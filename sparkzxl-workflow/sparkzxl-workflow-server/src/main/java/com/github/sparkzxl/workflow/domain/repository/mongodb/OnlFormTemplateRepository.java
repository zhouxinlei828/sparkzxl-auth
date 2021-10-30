package com.github.sparkzxl.workflow.domain.repository.mongodb;

import com.github.sparkzxl.mongodb.repository.BaseRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.mongodb.OnlFormTemplate;

import java.util.List;

/**
 * description: 表单设计模板 仓储类
 *
 * @author zhouxinlei
 * @date 2021-08-28 19:57:55
 */
public interface OnlFormTemplateRepository extends BaseRepository<OnlFormTemplate> {
    /**
     * 根据id列表删除
     *
     * @param ids ids
     * @return boolean
     */
    boolean deleteByIdIn(List<Long> ids);
}
