package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessTaskDetailRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskDetail;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessTaskDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * description:流程详细节点 仓储实现类
 *
 * @author charles.zhou
 * @since 2020-07-21 15:43:03
 */
@Repository
public class ExtProcessTaskDetailRepositoryImpl implements IExtProcessTaskDetailRepository {

    @Autowired
    private ExtProcessTaskDetailMapper processTaskDetailMapper;

    @Override
    public Page<ExtProcessTaskDetail> getProcessTaskDetailList(int pageNum, int pageSize, String processName) {
        LambdaQueryWrapper<ExtProcessTaskDetail> detailQueryWrapper = new LambdaQueryWrapper<>();
        Optional.ofNullable(processName).ifPresent((value) -> detailQueryWrapper.eq(ExtProcessTaskDetail::getProcessName, processName));
        detailQueryWrapper.groupBy(ExtProcessTaskDetail::getModelId);
        return processTaskDetailMapper.selectPage(new Page<>(pageNum, pageSize), detailQueryWrapper);
    }

    @Override
    public List<ExtProcessTaskDetail> getProcessTaskDetail(String modelId) {
        return processTaskDetailMapper.selectList(new QueryWrapper<ExtProcessTaskDetail>().lambda().eq(ExtProcessTaskDetail::getModelId, modelId));
    }
}
