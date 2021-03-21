package com.github.sparkzxl.workflow.domain.service.act;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DatePattern;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.database.factory.CustomThreadFactory;
import com.github.sparkzxl.workflow.application.service.act.IProcessHistoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.dto.ProcessHistory;
import com.github.sparkzxl.workflow.dto.ProcessHistoryParam;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.github.sparkzxl.workflow.infrastructure.diagram.CustomProcessDiagramGeneratorImpl;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.enums.TaskStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.utils.CloseableUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.TaskInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * description: 历史流程 服务实现类
 *
 * @author charles.zhou
 * @date   2020-07-17 15:21:22
 */
@Service
@Slf4j
public class ProcessHistoryServiceImpl implements IProcessHistoryService {

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,
            Runtime.getRuntime().availableProcessors() + 1,
            10,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(30),
            new CustomThreadFactory());

    @Autowired
    private HistoryService historyService;

    @Autowired
    private IProcessRepositoryService processRepositoryService;

    @Autowired
    private IProcessTaskService processTaskService;

    @Autowired
    private IProcessRuntimeService processRuntimeService;

    @Autowired
    private IExtHiTaskStatusService actHiTaskStatusService;

    @Autowired
    private CustomProcessDiagramGeneratorImpl processDiagramGenerator;

    @Autowired
    private IExtProcessStatusService processTaskStatusService;

    @Override
    public HistoricProcessInstance getHistoricProcessInstance(String processInstanceId) {
        return historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
    }

    @Override
    public List<HistoricTaskInstance> getHistoricTasksByAssigneeId(String assignee) {
        return historyService.createHistoricTaskInstanceQuery().taskAssignee(assignee).list();
    }

    @Override
    public List<HistoricTaskInstance> getHistoricTasksByProcessInstanceId(String processInstanceId) {
        return historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).orderByTaskId().asc().list();
    }

    @Override
    public HistoricTaskInstance getHistoricTasksByTaskId(String taskId) {
        return historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
    }

    private List<ProcessHistory> getProcessHistoryByBusinessId(String businessId) {
        List<ExtProcessStatus> processStatusList = processTaskStatusService.getExtProcessStatusList(businessId);
        List<ProcessHistory> processHistories = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(processStatusList)) {
            List<String> processInstanceIds = processStatusList.stream().map(ExtProcessStatus::getProcessInstanceId)
                    .collect(Collectors.toList());
            processInstanceIds.forEach(processInstanceId -> {
                try {
                    List<ProcessHistory> processHistoryList = getProcessHistories(processInstanceId);
                    processHistories.addAll(processHistoryList);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        return processHistories;
    }

    private List<ProcessHistory> getProcessHistories(String processInstanceId) throws InterruptedException, ExecutionException {
        CompletableFuture<List<ProcessHistory>> hiActInsCompletableFuture =
                CompletableFuture.supplyAsync(() -> buildActivityProcessHistory(processInstanceId), threadPoolExecutor);

        CompletableFuture<List<ProcessHistory>> hiTaskInsCompletableFuture =
                CompletableFuture.supplyAsync(() -> buildTaskProcessHistory(processInstanceId), threadPoolExecutor);

        CompletableFuture<List<ProcessHistory>> processHistoryCompletableFuture = hiActInsCompletableFuture
                .thenCombine(hiTaskInsCompletableFuture, org.apache.commons.collections4.ListUtils::union);
        List<ProcessHistory> processHistories = processHistoryCompletableFuture.get();
        processHistories.sort(Comparator.comparing(ProcessHistory::getStartTime));
        return processHistories;
    }

    private List<ProcessHistory> getProcessHistoryByProcessInstanceId(String processInstanceId) throws ExecutionException, InterruptedException {
        return getProcessHistories(processInstanceId);
    }

    private List<ProcessHistory> buildTaskProcessHistory(String processInstanceId) {
        List<ProcessHistory> processHistories = Lists.newArrayList();
        try {
            // 异步获取历史任务状态
            CompletableFuture<List<ExtHiTaskStatus>> hiTaskStatusCompletableFuture =
                    CompletableFuture.supplyAsync(() -> actHiTaskStatusService.getProcessHistory(processInstanceId));
            CompletableFuture<List<HistoricTaskInstance>> hiTakInsCompletableFuture =
                    CompletableFuture.supplyAsync(() -> getHistoricTasksByProcessInstanceId(processInstanceId));
            CompletableFuture<List<Comment>> completableFuture =
                    hiTakInsCompletableFuture(processInstanceId).thenCompose(historicTaskInstance -> {
                        List<String> taskIds = historicTaskInstance.stream().map(TaskInfo::getId).collect(Collectors.toList());
                        return hiCommentCompletableFuture(taskIds, "comment");
                    });
            List<ExtHiTaskStatus> actHiTaskStatusList = hiTaskStatusCompletableFuture.get();
            List<HistoricTaskInstance> historicTaskInstances = hiTakInsCompletableFuture.get();
            List<Comment> commentList = completableFuture.get();
            historicTaskInstances.forEach(historicTaskInstance -> {

                ProcessHistory processHistory = ProcessHistory.builder()
                        .processInstanceId(processInstanceId)
                        .taskName(historicTaskInstance.getName())
                        .startTime(historicTaskInstance.getStartTime())
                        .endTime(historicTaskInstance.getEndTime())
                        .duration(historicTaskInstance.getDurationInMillis())
                        .assignee(historicTaskInstance.getAssignee())
                        .dueDate(historicTaskInstance.getDueDate())
                        .build();
                if (ObjectUtils.isNotEmpty(historicTaskInstance.getDurationInMillis())) {
                    String durationTime = DateUtils.formatBetween(historicTaskInstance.getDurationInMillis());
                    processHistory.setDurationTime(durationTime);
                    Optional<ExtHiTaskStatus> actHiTaskStatusOptional =
                            actHiTaskStatusList.stream().filter(item -> StringUtils.equals(historicTaskInstance.getId(),
                                    item.getTaskId())).findFirst();
                    actHiTaskStatusOptional.ifPresent(value -> processHistory.setTaskStatus(value.getTaskStatus()));
                    if (ListUtils.isNotEmpty(commentList)) {
                        processHistory.setComment(commentList.stream().filter(item -> historicTaskInstance.getId().equals(item.getTaskId())).map(Comment::getFullMessage).collect(Collectors.toList()));
                    }
                } else {
                    processHistory.setTaskStatus(TaskStatusEnum.IN_HAND.getDesc());
                }
                processHistories.add(processHistory);
            });
        } catch (Exception e) {
            log.error("查询任务历史发生异常 Exception {}", e.getMessage());
        }
        return processHistories;
    }

    public CompletableFuture<List<HistoricTaskInstance>> hiTakInsCompletableFuture(String processInstanceId) {
        return CompletableFuture.supplyAsync(() -> getHistoricTasksByProcessInstanceId(processInstanceId), threadPoolExecutor);
    }

    public CompletableFuture<List<Comment>> hiCommentCompletableFuture(List<String> taskIds, String type) {
        return CompletableFuture.supplyAsync(() -> processTaskService.getTaskComments(taskIds, type), threadPoolExecutor);
    }

    private List<ProcessHistory> buildActivityProcessHistory(String processInstanceId) {
        List<ProcessHistory> processHistories = Lists.newArrayList();
        List<HistoricActivityInstance> historicActivityInstances = getHistoricActivityInstance(processInstanceId);
        List<HistoricActivityInstance> specialHistoricActivityInstances =
                historicActivityInstances.stream().filter(item -> WorkflowConstants.ActType.START_EVENT.equals(item.getActivityType())
                        || WorkflowConstants.ActType.END_EVENT.equals(item.getActivityType()))
                        .collect(Collectors.toList());
        specialHistoricActivityInstances.forEach(historicActivityInstance -> {
            ProcessHistory processHistory = ProcessHistory.builder()
                    .processInstanceId(processInstanceId)
                    .startTime(historicActivityInstance.getStartTime())
                    .endTime(historicActivityInstance.getEndTime())
                    .duration(historicActivityInstance.getDurationInMillis())
                    .assignee(historicActivityInstance.getAssignee())
                    .build();
            if (WorkflowConstants.ActType.START_EVENT.equals(historicActivityInstance.getActivityType())) {
                processHistory.setTaskStatus(TaskStatusEnum.START.getDesc());
                processHistory.setTaskName("启动流程");
                processHistory.setDurationTime(DateUtils.formatBetween(historicActivityInstance.getStartTime(), historicActivityInstance.getEndTime()));
            }
            if (WorkflowConstants.ActType.END_EVENT.equals(historicActivityInstance.getActivityType())) {
                processHistory.setTaskStatus(TaskStatusEnum.END.getDesc());
                processHistory.setTaskName("完成流程");
                processHistory.setDurationTime(DateUtils.formatBetween(historicActivityInstance.getStartTime(), historicActivityInstance.getEndTime()));
            }
            processHistories.add(processHistory);
        });
        return processHistories;
    }

    public List<HistoricActivityInstance> getHistoricActivityInstance(String processInstanceId) {
        return historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
                .orderByHistoricActivityInstanceId().asc().list();
    }

    @Override
    public String getProcessImage(String processInstanceId) {
        InputStream imageStream = null;
        String imageBase64 = "";
        try {
            if (StringUtils.isBlank(processInstanceId)) {
                log.error("参数为空");
            }
            // 获取历史流程实例
            HistoricProcessInstance processInstance = getHistoricProcessInstance(processInstanceId);

            // 获取流程定义ID
            String processDefinitionId = processInstance.getProcessDefinitionId();

            // 获取流程定义信息
            BpmnModel bpmnModel = processRepositoryService.getBpmnModel(processDefinitionId);

            // 获取流程历史中已执行节点
            List<HistoricActivityInstance> historicActivityInstance = getHistoricActivityInstance(processInstanceId);

            // 高亮环节id集合
            List<String> highLightedActivitis = new ArrayList<>();
            for (HistoricActivityInstance tempActivity : historicActivityInstance) {
                String activityId = tempActivity.getActivityId();
                highLightedActivitis.add(activityId);
            }

            // 高亮线路id集合
            List<String> highLightedFlows = getHighLightedFlows(bpmnModel, historicActivityInstance);

            Set<String> currIds = processRuntimeService.getExecutionByProcInsId(processInstanceId)
                    .stream().map(Execution::getActivityId).collect(Collectors.toSet());

            imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,
                    highLightedFlows, "宋体", "宋体", "宋体",
                    null, 1.0,
                    new Color[]{WorkflowConstants.COLOR_NORMAL, WorkflowConstants.COLOR_CURRENT}, currIds);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = imageStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] processImageByte = output.toByteArray();
            imageBase64 = "data:image/jpeg;base64,".concat(Base64.encode(processImageByte));
        } catch (IOException e) {
            throw new RuntimeException("获取流程图出错", e);
        } finally {
            CloseableUtils.close(imageStream);
        }
        return imageBase64;
    }

    private List<String> getHighLightedFlows(BpmnModel bpmnModel, List<HistoricActivityInstance> historicActivityInstances) {
        // 24小时制
        SimpleDateFormat df = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        // 用以保存高亮的线flowId
        List<String> highFlows = Lists.newArrayList();

        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {
            // 对历史流程节点进行遍历
            // 得到节点定义的详细信息
            FlowNode activityImpl = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(i).getActivityId());
            // 用以保存后续开始时间相同的节点
            List<FlowNode> sameStartTimeNodes = Lists.newArrayList();
            FlowNode sameActivityImpl1 = null;
            // 第一个节点
            HistoricActivityInstance activityInstance = historicActivityInstances.get(i);
            HistoricActivityInstance activityInstance1;

            for (int k = i + 1; k <= historicActivityInstances.size() - 1; k++) {
                // 后续第1个节点
                activityInstance1 = historicActivityInstances.get(k);

                // 都是usertask，且主节点与后续节点的开始时间相同，说明不是真实的后继节点
                if ("userTask".equals(activityInstance.getActivityType()) && "userTask".equals(activityInstance1.getActivityType()) &&
                        df.format(activityInstance.getStartTime()).equals(df.format(activityInstance1.getStartTime()))) {
                } else {
                    // 找到紧跟在后面的一个节点
                    sameActivityImpl1 = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(k).getActivityId());
                    break;
                }
            }
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                // 后续第一个节点
                HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);
                // 后续第二个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);

                // 如果第一个节点和第二个节点开始时间相同保存
                if (df.format(activityImpl1.getStartTime()).equals(df.format(activityImpl2.getStartTime()))) {
                    FlowNode sameActivityImpl2 = (FlowNode) bpmnModel.getMainProcess().getFlowElement(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    // 有不相同跳出循环
                    break;
                }
            }
            // 取出节点的所有出去的线
            List<SequenceFlow> pvmTransitions = activityImpl.getOutgoingFlows();

            // 对所有的线进行遍历
            for (SequenceFlow pvmTransition : pvmTransitions) {
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                FlowNode pvmActivityImpl = (FlowNode) bpmnModel.getMainProcess().getFlowElement(pvmTransition.getTargetRef());
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }

    @Override
    public List<ProcessHistory> processHistoryList(ProcessHistoryParam processHistoryParam) {
        if (processHistoryParam.getType().equals(1)) {
            return getProcessHistoryByBusinessId(processHistoryParam.getBusinessId());
        } else {
            try {
                return getProcessHistoryByProcessInstanceId(processHistoryParam.getProcessInstanceId());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
                log.error("获取流程历史发生异常：{}", e.getMessage());
                return null;
            }
        }
    }
}
