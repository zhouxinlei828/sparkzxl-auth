package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.domain.repository.IExtHiTaskStatusRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtHiTaskStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 任务历史状态记录 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-17 13:37:57
 */
@Service
public class ExtHiTaskStatusServiceImpl extends SuperServiceImpl<ExtHiTaskStatusMapper, ExtHiTaskStatus> implements IExtHiTaskStatusService {

    @Autowired
    private IExtHiTaskStatusRepository actHiTaskStatusRepository;


    @Override
    public ExtHiTaskStatus getExtHiTaskStatus(String processInstanceId) {
        return actHiTaskStatusRepository.getExtHiTaskStatus(processInstanceId);
    }

    @Override
    public List<ExtHiTaskStatus> getProcessHistory(String processInstanceId) {
        return actHiTaskStatusRepository.getHiTaskStatus(processInstanceId);
    }

}
