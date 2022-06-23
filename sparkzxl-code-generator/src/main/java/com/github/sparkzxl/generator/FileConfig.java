package com.github.sparkzxl.generator;

import lombok.Data;

/**
 * description: 自定义模板文件配置属性
 *
 * @author zhouxinlei
 * @since 2022-02-19 20:53:14
 */
@Data
public class FileConfig {

    private String filePath;

    private String packageName;

    private String fileName;

}
