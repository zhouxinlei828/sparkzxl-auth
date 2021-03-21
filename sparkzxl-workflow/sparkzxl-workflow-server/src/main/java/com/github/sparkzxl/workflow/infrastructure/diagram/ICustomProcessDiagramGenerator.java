package com.github.sparkzxl.workflow.infrastructure.diagram;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.image.ProcessDiagramGenerator;

import java.awt.*;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * description: Activiti生成流程图片接口
 *
 * @author charles.zhou
 * @date   2020-07-17 13:58:45
 */
public interface ICustomProcessDiagramGenerator extends ProcessDiagramGenerator {

    /**
     * Activiti生成流程图片
     *
     * @param bpmnModel
     * @param imageType
     * @param highLightedActivities
     * @param highLightedFlows
     * @param activityFontName
     * @param labelFontName
     * @param annotationFontName
     * @param customClassLoader
     * @param scaleFactor
     * @param colors
     * @param currIds
     * @return
     */
    InputStream generateDiagram(BpmnModel bpmnModel,
                                String imageType,
                                List<String> highLightedActivities,
                                List<String> highLightedFlows,
                                String activityFontName,
                                String labelFontName,
                                String annotationFontName,
                                ClassLoader customClassLoader,
                                double scaleFactor,
                                Color[] colors,
                                Set<String> currIds);
}
