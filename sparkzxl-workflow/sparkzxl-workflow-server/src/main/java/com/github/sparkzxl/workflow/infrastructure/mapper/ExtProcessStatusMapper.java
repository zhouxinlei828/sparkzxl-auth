package com.github.sparkzxl.workflow.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ProcessInstance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 流程状态记录Mapper 接口
 *
 * @author charles.zhou
 * @date   2020-07-17 13:18:25
 */
@Repository
public interface ExtProcessStatusMapper extends SuperMapper<ExtProcessStatus> {

    /**
     * 查询流程实例列表
     *
     * @param name 流程名称
     * @return List<ProcessInstance>
     */
    List<ProcessInstance> getProcessInstanceList(@Param("name") String name);

}
