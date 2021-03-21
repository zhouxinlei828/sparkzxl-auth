package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.workflow.domain.repository.IExtHiTaskStatusRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtHiTaskStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 历史流程记录 仓储实现类
 *
 * @author charles.zhou
 * @date   2020-07-23 17:13:52
 */
@Repository
public class ExtHiTaskStatusRepositoryImpl implements IExtHiTaskStatusRepository {

    @Autowired
    private ExtHiTaskStatusMapper extHiTaskStatusMapper;

    @Override
    public List<ExtHiTaskStatus> getHiTaskStatus(String processInstanceId) {
        return extHiTaskStatusMapper.selectList(new LambdaQueryWrapper<ExtHiTaskStatus>()
                .eq(ExtHiTaskStatus::getProcessInstanceId, processInstanceId)
                .orderByAsc(ExtHiTaskStatus::getTaskId));
    }

    @Override
    public ExtHiTaskStatus getExtHiTaskStatus(String processInstanceId) {
        return extHiTaskStatusMapper.selectOne(new LambdaQueryWrapper<ExtHiTaskStatus>()
                .eq(ExtHiTaskStatus::getProcessInstanceId, processInstanceId)
                .orderByDesc(ExtHiTaskStatus::getCreateTime).last("limit 1"));
    }
}
