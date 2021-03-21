package com.github.sparkzxl.workflow.infrastructure.strategy;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * description: 流程驱动选择器
 *
 * @author charles.zhou
 * @date   2020-07-20 16:14:39
 */
@Component
public class ProcessSolverChooser implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<Integer, AbstractProcessSolver> activitiSolverMap = Maps.newConcurrentMap();


    @PostConstruct
    public void register() {
        Map<String, AbstractProcessSolver> solverMap = applicationContext.getBeansOfType(AbstractProcessSolver.class);
        for (AbstractProcessSolver solver : solverMap.values()) {
            for (Integer support : solver.supports()) {
                activitiSolverMap.put(support, solver);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public AbstractProcessSolver chooser(Integer actType) {
        return activitiSolverMap.get(actType);
    }
}
