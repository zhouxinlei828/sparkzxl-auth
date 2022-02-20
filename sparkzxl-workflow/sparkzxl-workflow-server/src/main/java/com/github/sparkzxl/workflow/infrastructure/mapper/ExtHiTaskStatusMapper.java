package com.github.sparkzxl.workflow.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 任务状态记录Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-07-17 13:18:25
 */
@Mapper
public interface ExtHiTaskStatusMapper extends SuperMapper<ExtHiTaskStatus> {

}
