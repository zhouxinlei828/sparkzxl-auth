package com.github.sparkzxl.workflow.interfaces.controller.model;

import com.github.sparkzxl.alarm.entity.AlarmRequest;
import com.github.sparkzxl.alarm.entity.AlarmResponse;
import com.github.sparkzxl.alarm.enums.MessageSubType;
import com.github.sparkzxl.alarm.send.AlarmSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:
 *
 * @author charles.zhou
 * @date 2020-10-02 10:35:45
 */
@AllArgsConstructor
@Api(tags = "页面管理")
@Controller
public class IndexController {

    @Autowired
    private AlarmSender alarmSender;

    @ApiOperation("流程图设计页")
    @GetMapping("editor")
    public String editor() {
        return "index";
    }

    @ApiOperation("mock alarm")
    @GetMapping("alarm")
    @ResponseBody
    public AlarmResponse testAlarm() {
        AlarmRequest request = new AlarmRequest();
        request.setTitle("测试");
        request.setContent("hello world");
        request.setAtAll(true);
        return alarmSender.send(MessageSubType.TEXT, request);
    }
}
