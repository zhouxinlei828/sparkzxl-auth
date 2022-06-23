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
 * @since 2020-07-17 13:58:45
 */
public interface ICustomProcessDiagramGenerator extends ProcessDiagramGenerator {

    /**
     * Activiti生成流程图片
     *
     * @param bpmnModel             流程模型
     * @param imageType             图片类型
     * @param highLightedActivities 历史高亮活动id
     * @param highLightedFlows      高亮流程
     * @param activityFontName      字体名称
     * @param labelFontName         字体名称
     * @param annotationFontName    字体名称
     * @param customClassLoader     自定义类加载
     * @param scaleFactor           粗细
     * @param colors                颜色
     * @param currIds               当前活动id
     * @return InputStream
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
