package com.github.sparkzxl.workflow.application.service.model;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * description: activiti在线流程设计 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 14:30:32
 */
public interface IModelService {

    /**
     * 获取流程json信息
     *
     * @param modelId 流程模型id
     * @return ObjectNode
     */
    ObjectNode getEditorJson(String modelId);

    /**
     * 保存流程
     *
     * @param modelId     模型id
     * @param name        模型名称
     * @param description 描述
     * @param jsonXml     json
     * @param svgXml      svg
     * @return boolean
     */
    boolean saveModel(String modelId, String name, String description, String jsonXml, String svgXml);

    /**
     * 获取流程json文件
     *
     * @return String
     */
    String getProcessJson();

}
