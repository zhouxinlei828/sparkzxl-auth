package com.github.sparkzxl.workflow.infrastructure.config;

import cn.hutool.core.util.IdUtil;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.stereotype.Component;

/**
 * description: activiti自定义主键生成策略（雪花）
 *
 * @author charles.zhou
 * @date   2020-12-04 09:14:45
*/
@Component
public class SnowFlakeGenerator implements IdGenerator {

    @Override
    public String getNextId() {
        return IdUtil.getSnowflake(0,10).nextIdStr();
    }
}
