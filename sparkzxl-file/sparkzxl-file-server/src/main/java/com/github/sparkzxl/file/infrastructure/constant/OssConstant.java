package com.github.sparkzxl.file.infrastructure.constant;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * description: oss属性常量
 *
 * @author charles.zhou
 * @date 2020-05-24 12:35:57
 */
public class OssConstant {

    public static final Map<String, String> OSS_EXCEPTION_MAP =
            ImmutableMap.<String, String>builder().
                    put("NoSuchKey", "文件不存在")
                    .build();

}
