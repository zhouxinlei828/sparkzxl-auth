package com.github.sparkzxl.workflow.domain.service.model;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessDetailService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskRuleService;
import com.github.sparkzxl.workflow.application.service.model.IModelerService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessDetail;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:模型控制 服务实现类
 *
 * @author charles.zhou
 * @date   2020-07-17 14:55:23
 */
@Service
@Slf4j
@Transactional(transactionManager = "transactionManager", rollbackFor = Exception.class)
public class ModelerServiceImpl implements IModelerService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IExtProcessDetailService extProcessDetailService;

    @Autowired
    private IExtProcessTaskRuleService extProcessTaskRuleService;

    @Override
    public String createModel(String name, String key) {
        Model model = repositoryService.newModel();
        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, "");
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());
        repositoryService.saveModel(model);
        createObjectNode(model.getId());
        log.info("创建模型结束，返回模型ID：{}", model.getId());
        return model.getId();
    }

    /**
     * 创建模型时完善ModelEditorSource
     *
     * @param modelId 模型id
     */
    private void createObjectNode(String modelId) {
        log.info("创建模型完善ModelEditorSource入参模型ID：{}", modelId);
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.set("stencilset", stencilSetNode);
        try {
            repositoryService.addModelEditorSource(modelId, editorNode.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.info("创建模型时完善ModelEditorSource服务异常：{}", e.getMessage());
        }
        log.info("创建模型完善ModelEditorSource结束");
    }

    @Override
    public boolean publishProcess(String modelId) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());
            if (bytes == null) {
                log.error("部署ID:{}的模型数据为空，请先设计流程并成功保存，再进行发布", modelId);
                return false;
            }
            JsonNode modelNode = new ObjectMapper().readTree(bytes);
            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            Deployment deployment = repositoryService.createDeployment()
                    .name(modelData.getName())
                    .addBpmnModel(modelData.getKey() + ".bpmn20.xml", model)
                    .deploy();
            modelData.setDeploymentId(deployment.getId());
            repositoryService.saveModel(modelData);
            return true;
        } catch (Exception e) {
            log.error("部署modelId:{}模型服务异常：{}", modelId, e);
        }
        return false;
    }

    @Override
    public boolean revokePublish(String modelId) {
        Model modelData = repositoryService.getModel(modelId);
        if (null != modelData) {
            try {
                //参数不加true:为普通删除，如果当前规则下有正在执行的流程，则抛异常
                //参数加true:为级联删除,会删除和当前规则相关的所有信息，包括历史
                if (StringUtils.isNotEmpty(modelData.getDeploymentId())) {
                    repositoryService.deleteDeployment(modelData.getDeploymentId(), true);
                }
                return true;
            } catch (Exception e) {
                log.error("撤销已部署流程服务异常：{}", e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteModel(String modelId) {
        Model modelData = repositoryService.getModel(modelId);
        if (null != modelData) {
            try {
                ProcessInstance pi = runtimeService.createProcessInstanceQuery().processDefinitionKey(modelData.getKey()).singleResult();
                if (null != pi) {
                    SparkZxlExceptionAssert.businessFail("该流程正在运作，请勿删除");
                }
                if (StringUtils.isNotEmpty(modelData.getDeploymentId())) {
                    repositoryService.deleteDeployment(modelData.getDeploymentId());
                }
                List<ExtProcessDetail> processDetails =
                        extProcessDetailService.list(new QueryWrapper<ExtProcessDetail>().lambda().eq(ExtProcessDetail::getModelId, modelId));
                List<Long> processDetailIds = processDetails.stream().map(ExtProcessDetail::getId).collect(Collectors.toList());
                if (ListUtils.isNotEmpty(processDetailIds)) {
                    extProcessTaskRuleService.remove(new QueryWrapper<ExtProcessTaskRule>().lambda().in(ExtProcessTaskRule::getProcessDetailId,
                            processDetailIds));
                    extProcessDetailService.removeByIds(processDetailIds);
                }
                repositoryService.deleteModel(modelId);
                return true;
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error("删除流程实例服务异常：{}", e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean deleteModels(List<String> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            ids.forEach(this::deleteModel);
        }
        return true;
    }
}
