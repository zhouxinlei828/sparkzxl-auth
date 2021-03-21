package com.github.sparkzxl.workflow.application.service.act;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * description: 流程定义相关 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 15:26:02
 */
public interface IProcessRepositoryService {

    /**
     * 获取所有部署流程信息
     *
     * @return List<Deployment>
     */
    List<Deployment> deployList();

    /**
     * 根据任务ID获取流程定义
     *
     * @param taskId 任务id
     * @return ProcessDefinition
     */
    ProcessDefinition findProcessDefinitionByTaskId(String taskId);

    /**
     * 根据流程定义key获取相关流程定义对象列表
     *
     * @param processDefinitionKey 流程定义key
     * @return List<ProcessDefinition>
     */
    List<ProcessDefinition> getProcessDefinitionsByKey(String processDefinitionKey);

    /**
     * 获取最新的流程定义信息
     *
     * @param processDefinitionKey 流程定义key
     * @return ProcessDefinition
     */
    ProcessDefinition getProcessDefinitionByKey(String processDefinitionKey);

    /**
     * 根据流程定义id获取定义对象
     *
     * @param processDefinitionId 流程定义id
     * @return ProcessDefinition
     */
    ProcessDefinition getProcessDefinitionById(String processDefinitionId);

    /**
     * 根据流程定义id获取流程定义实体
     *
     * @param processDefinitionId 流程定义id
     * @return ProcessDefinitionEntity
     */
    ProcessDefinitionEntity getProcessDefinitionEntity(String processDefinitionId);

    /**
     * 新增模型
     *
     * @return Model
     */
    Model newModel();

    /**
     * 保存模型
     *
     * @param model 模型
     */
    void saveModel(Model model);

    /**
     * 添加模型信息
     *
     * @param modelId 模型id
     * @param bytes
     */
    void addModelEditorSource(String modelId, byte[] bytes);

    /**
     * 获取模型信息列表
     *
     * @return List<Model>
     */
    List<Model> getModelsOrderByCreateTime();

    /**
     * 部署流程
     *
     * @param modelName   模型名称
     * @param processName 流程名称
     * @param bpmnBytes
     */
    void deployModel(String modelName, String processName, byte[] bpmnBytes);

    /**
     * 根据发布id查询模型
     *
     * @param deploymentId 发布id
     * @return Model
     */
    Model getModelByDeploymentId(String deploymentId);

    /**
     * 根据modelId获取模型信息
     *
     * @param modelId 模型id
     * @return Model
     */
    Model getModelById(String modelId);

    /**
     * 查询所有的模型列表
     *
     * @return
     */
    List<Model> getModelList();

    /**
     * 根据modelId获取模型定义信息
     *
     * @param modelId 模型id
     * @return byte[]
     */
    byte[] getModelEditorSourceByModelId(String modelId);

    /**
     * 根据流程定义ID获取流程定义信息
     *
     * @param processDefinitionId 流程定义id
     * @return BpmnModel
     */
    BpmnModel getBpmnModel(String processDefinitionId);
}
