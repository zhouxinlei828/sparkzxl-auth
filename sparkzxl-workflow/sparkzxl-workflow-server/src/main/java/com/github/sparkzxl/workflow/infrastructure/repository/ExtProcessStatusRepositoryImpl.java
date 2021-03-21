package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.database.utils.PageInfoUtils;
import com.github.sparkzxl.workflow.domain.model.InstanceOverviewCount;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessStatusRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ProcessInstance;
import com.github.sparkzxl.workflow.infrastructure.enums.ProcessStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:流程状态 仓储实现类
 *
 * @author charles.zhou
 * @date   2020-07-23 13:59:16
 */
@Repository
public class ExtProcessStatusRepositoryImpl implements IExtProcessStatusRepository {

    @Autowired
    private ExtProcessStatusMapper extProcessStatusMapper;

    @Override
    public List<ExtProcessStatus> getExtProcessStatusList(String businessId) {
        return extProcessStatusMapper.selectList(new LambdaQueryWrapper<ExtProcessStatus>()
                .eq(ExtProcessStatus::getBusinessId, businessId).orderByAsc(ExtProcessStatus::getCreateTime));
    }

    @Override
    public ExtProcessStatus getExtProcessStatus(String businessId, String processInstanceId) {
        return extProcessStatusMapper.selectOne(new LambdaQueryWrapper<ExtProcessStatus>()
                .eq(ExtProcessStatus::getBusinessId, businessId)
                .eq(ExtProcessStatus::getProcessInstanceId, processInstanceId).last("limit 1"));
    }

    @Override
    public PageInfo<ProcessInstance> getProcessInstanceList(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        return PageInfoUtils.pageInfo(extProcessStatusMapper.getProcessInstanceList(name));
    }

    @Override
    public InstanceOverviewCount instanceOverview() {
        InstanceOverviewCount instanceOverviewCount = new InstanceOverviewCount();
        AtomicInteger todayCount = new AtomicInteger(0);
        AtomicInteger weekCount = new AtomicInteger(0);
        AtomicInteger finishCount = new AtomicInteger(0);
        AtomicInteger unFinishCount = new AtomicInteger(0);
        AtomicInteger monthCount = new AtomicInteger(0);
        List<ProcessInstance> processInstanceList = extProcessStatusMapper.getProcessInstanceList(null);
        processInstanceList.forEach(processInstance -> {
            if (DateUtils.isToday(processInstance.getCreateTime())) {
                todayCount.getAndIncrement();
            }
            if (DateUtils.isThisWeek(processInstance.getCreateTime())) {
                weekCount.getAndIncrement();
            }
            if (DateUtils.isThisMonth(processInstance.getCreateTime())) {
                monthCount.getAndIncrement();
            }
            ProcessStatusEnum processStatus = ProcessStatusEnum.getEnum(processInstance.getStatus());
            assert processStatus != null;
            if (processStatus.equals(ProcessStatusEnum.END)){
                finishCount.getAndIncrement();
            }else {
                unFinishCount.getAndIncrement();
            }
        });
        instanceOverviewCount.setTodayCount(todayCount.get());
        instanceOverviewCount.setWeekCount(weekCount.get());
        instanceOverviewCount.setFinishCount(finishCount.get());
        instanceOverviewCount.setUnFinishCount(unFinishCount.get());
        instanceOverviewCount.setMonthCount(monthCount.get());
        instanceOverviewCount.setTotalCount(processInstanceList.size());
        return instanceOverviewCount;
    }
}
