package com.github.sparkzxl.workflow.domain.service.act;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.workflow.application.service.act.IActReModelService;
import com.github.sparkzxl.workflow.domain.model.dto.act.ModelPageDTO;
import com.github.sparkzxl.workflow.domain.repository.IActReModelRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ActReModel;
import com.github.sparkzxl.workflow.infrastructure.mapper.ActReModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 模型 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-25 11:14:57
 */
@Service
public class ActReModelServiceImpl extends SuperServiceImpl<ActReModelMapper, ActReModel> implements IActReModelService {

    @Autowired
    private IActReModelRepository actReModelRepository;

    @Override
    public PageInfo<ActReModel> actReModelList(ModelPageDTO modelPageDTO) {
        PageHelper.startPage(modelPageDTO.getPageNum(), modelPageDTO.getPageSize());
        PageInfo<ActReModel> actReModelPageInfo = actReModelRepository.actReModelList(modelPageDTO.getKey(), modelPageDTO.getName());
        List<ActReModel> actReModels = actReModelPageInfo.getList();
        actReModels.forEach(item -> item.setDeployed(item.getDeploymentId() != null ? "已发布" : "未发布"));
        actReModelPageInfo.setList(actReModels);
        return actReModelPageInfo;
    }
}
