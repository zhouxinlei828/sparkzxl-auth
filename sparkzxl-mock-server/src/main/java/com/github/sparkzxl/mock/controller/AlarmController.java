package com.github.sparkzxl.mock.controller;

import com.github.sparkzxl.alarm.annotation.Alarm;
import com.github.sparkzxl.alarm.annotation.AlarmParam;
import com.github.sparkzxl.alarm.entity.AlarmLink;
import com.github.sparkzxl.alarm.entity.AlarmRequest;
import com.github.sparkzxl.alarm.entity.AlarmResponse;
import com.github.sparkzxl.alarm.entity.ImageText;
import com.github.sparkzxl.alarm.entity.dingtalk.DingTalkActionCard;
import com.github.sparkzxl.alarm.enums.MessageSubType;
import com.github.sparkzxl.alarm.send.AlarmSender;
import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * description: Mock管理
 *
 * @author zhouxinlei
 * @since 2022-04-04 15:05:42
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/alarm")
@Response
@Api(tags = "告警管理")
public class AlarmController {

    private final AlarmSender alarmSender;

    @ApiOperation("testAlarmImageText")
    @GetMapping("testAlarmImageText")
    public AlarmResponse testAlarmImageText() {
        AlarmRequest request = new AlarmRequest();
        request.setTitle("测试");
        request.setContent("hello world");
        request.setAtAll(true);
        Map<String, Object> hashMap = Maps.newHashMap();
        List<ImageText> imageTexts = Lists.newArrayList();
        ImageText imageText = ImageText.instance("测试", "https://open.dingtalk.com/document/group/message-types-and-data-format", "https://oss.sparksys.top/halo/1002_1582561737870.jpg");
        imageTexts.add(imageText);
        hashMap.put("imageTexts", imageTexts);
        request.setVariables(hashMap);
        return alarmSender.send(MessageSubType.IMAGE_TEXT, request);
    }

    @ApiOperation("testAlarmLink")
    @GetMapping("testAlarmLink")
    public AlarmResponse testAlarmLink() {
        AlarmRequest request = new AlarmRequest();
        request.setTitle("测试");
        request.setContent("hello world");
        request.setAtAll(true);
        Map<String, Object> hashMap = Maps.newHashMap();
        AlarmLink alarmLink = AlarmLink.instance("测试", "哈哈哈哈", "https://open.dingtalk.com/document/group/message-types-and-data-format", "https://oss.sparksys.top/halo/1002_1582561737870.jpg");
        hashMap.put("alarmLink", alarmLink);
        request.setVariables(hashMap);
        return alarmSender.send(MessageSubType.LINK, request);
    }

    @ApiOperation("testAlarmActionCard")
    @GetMapping("testAlarmActionCard")
    public AlarmResponse testAlarmActionCard() {
        AlarmRequest request = new AlarmRequest();
        request.setTitle("测试");
        request.setContent("hello world");
        request.setAtAll(true);
        Map<String, Object> hashMap = Maps.newHashMap();
        List<DingTalkActionCard.ActionCard.Button> buttonList = Lists.newArrayList();
        DingTalkActionCard.ActionCard.Button button = new DingTalkActionCard.ActionCard.Button("内容不错", "https://www.dingtalk.com/");
        buttonList.add(button);
        DingTalkActionCard.ActionCard actionCard = new DingTalkActionCard.ActionCard("测试", "哈哈哈哈", "0", buttonList);
        hashMap.put("actionCard", actionCard);
        request.setVariables(hashMap);
        return alarmSender.send(MessageSubType.ACTION_CARD, request);
    }

    @ApiOperation("testAlarmAspect")
    @GetMapping("testAlarmAspect")
    @Alarm(name = "测试告警", messageType = MessageSubType.MARKDOWN, templateId = "gbw-claims-notify", extractParams = "tenantId")
    public String testAlarmAspect(@AlarmParam("id") String id, @AlarmParam("name") String name) {
        System.out.println(id);
        System.out.println(name);
        ExceptionAssert.failure("1111");
        return "ok";
    }
}
