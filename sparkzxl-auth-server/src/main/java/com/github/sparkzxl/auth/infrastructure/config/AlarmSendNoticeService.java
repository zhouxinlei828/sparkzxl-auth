package com.github.sparkzxl.auth.infrastructure.config;

import com.github.sparkzxl.alarm.entity.AlarmRequest;
import com.github.sparkzxl.alarm.enums.MessageSubType;
import com.github.sparkzxl.alarm.send.AlarmSender;
import com.github.sparkzxl.database.plugins.SqlMonitorMessage;
import com.github.sparkzxl.database.send.AbstractSendNoticeService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * description:
 *
 * @author zhouxinlei
 * @since 2022-06-16 17:43:34
 */
@Component
public class AlarmSendNoticeService extends AbstractSendNoticeService {
    private final AlarmSender alarmSender;

    private final String MESSAGE_TEMPLATE = "- SQL类型：<font color=\"#FF5252\">#{[type]}</font>\n" +
            "\n" +
            "- 检测耗时：**[#{[checkTime]}]ms**\n" +
            "\n" +
            "- 执行耗时：**[#{[executeTime]}]ms**\n" +
            "\n" +
            "- SQLId：**#{[sqlId]}**\n" +
            "\n" +
            "- SQL语句：**#{[sql]}**\n" +
            "\n" +
            "- 异常信息：\n```\n#{[exceptionMsg]}\n```\n" +
            "\n" +
            "- 方法调用信息：\n```\n#{[stackTrace]}\n```\n" +
            "\n";

    public AlarmSendNoticeService(AlarmSender alarmSender) {
        this.alarmSender = alarmSender;
    }

    @Override
    public void sendNotice(SqlMonitorMessage sqlMonitorMessage) {
        AlarmRequest request = new AlarmRequest();
        request.setTitle("SQL告警通知");
        request.setContent(MESSAGE_TEMPLATE);
        request.setAtAll(true);
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("type", sqlMonitorMessage.getType().name());
        variables.put("sqlId", sqlMonitorMessage.getSqlId());
        variables.put("sql", sqlMonitorMessage.getSql());
        variables.put("exceptionMsg", sqlMonitorMessage.getExceptionMsg());
        variables.put("stackTrace", sqlMonitorMessage.getStackTrace());
        variables.put("checkTime", sqlMonitorMessage.getCheckTime());
        variables.put("executeTime", sqlMonitorMessage.getExecuteTime());
        request.setVariables(variables);
        alarmSender.send(MessageSubType.MARKDOWN, request);
    }
}
