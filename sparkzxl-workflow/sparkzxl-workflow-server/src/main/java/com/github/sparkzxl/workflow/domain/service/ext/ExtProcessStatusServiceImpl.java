package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.domain.model.InstanceOverviewCount;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessStatusRepository;
import com.github.sparkzxl.workflow.domain.vo.InstanceOverview;
import com.github.sparkzxl.workflow.infrastructure.constant.ActivitiCache;
import com.github.sparkzxl.workflow.infrastructure.convert.ExtProcessStatusConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ProcessInstance;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessStatusMapper;
import com.github.sparkzxl.workflow.interfaces.dto.act.InstancePageDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 流程历史状态记录 服务实现类
 *
 * @author charles.zhou
 * @date   2020-07-17 13:37:57
 */
@Service
public class ExtProcessStatusServiceImpl extends SuperCacheServiceImpl<ExtProcessStatusMapper, ExtProcessStatus> implements IExtProcessStatusService {

    private final IExtProcessStatusRepository extProcessStatusRepository;

    public ExtProcessStatusServiceImpl(IExtProcessStatusRepository extProcessStatusRepository) {
        this.extProcessStatusRepository = extProcessStatusRepository;
    }

    @Override
    public List<ExtProcessStatus> getExtProcessStatusList(String businessId) {
        return extProcessStatusRepository.getExtProcessStatusList(businessId);
    }

    @Override
    public ExtProcessStatus getExtProcessStatus(String businessId, String processInstanceId) {
        return extProcessStatusRepository.getExtProcessStatus(businessId, processInstanceId);
    }

    @Override
    public PageInfo<ProcessInstance> getProcessInstanceList(InstancePageDTO instancePageDTO) {
        PageInfo<ProcessInstance> processInstancePageInfo = extProcessStatusRepository.getProcessInstanceList(instancePageDTO.getPageNum(),
                instancePageDTO.getPageSize(), instancePageDTO.getName());
        List<ProcessInstance> processInstances = processInstancePageInfo.getList();
        processInstances.forEach(item -> {
            if (ObjectUtils.isNotEmpty(item.getDuration())) {
                item.setDueTime(DateUtils.formatBetween(item.getDuration()));
            }
        });
        processInstancePageInfo.setList(processInstances);
        return processInstancePageInfo;
    }

    @Override
    public InstanceOverview instanceOverview() {
        InstanceOverviewCount instanceOverviewCount = extProcessStatusRepository.instanceOverview();
        return ExtProcessStatusConvert.INSTANCE.convertInstanceOverviewCount(instanceOverviewCount);
    }

    @Override
    protected String getRegion() {
        return ActivitiCache.ACT_TASK_STEP;
    }
}
