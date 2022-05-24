package com.github.sparkzxl.mock.controller;

import com.github.sparkzxl.annotation.response.Response;
import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import com.github.sparkzxl.mock.DictionaryProvider;
import com.google.common.collect.Sets;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.SetUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * description: Mock管理
 *
 * @author zhouxinlei
 * @since 2022-04-04 15:05:42
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/mock")
@Response
@Api(tags = "Mock管理")
public class MockController {

    private final DictionaryProvider dictionaryProvider;

    @ApiOperation(value = "Mock数据")
    @GetMapping("/findDictionaryItemMap")
    public Map<String, DictionaryItemDTO> findDictionaryItemMap() {
        return dictionaryProvider.findDictionaryItemMap("EDUCATION", Sets.newHashSet("COLLEGE"));
    }

}
