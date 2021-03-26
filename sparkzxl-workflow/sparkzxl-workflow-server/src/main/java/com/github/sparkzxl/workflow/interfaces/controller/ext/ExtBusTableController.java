package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 业务表结构管理
 *
 * @author charles.zhou
 * @date 2021-03-25 18:03:38
 */
@ResponseResult
@RestController
@RequestMapping("/business/table")
@WebLog
@Api(tags = "业务表结构管理")
public class ExtBusTableController {

}
