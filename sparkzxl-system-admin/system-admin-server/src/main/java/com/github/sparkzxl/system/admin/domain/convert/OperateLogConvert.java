package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.OperateLog;
import com.github.sparkzxl.system.admin.api.model.dto.OperateLogDTO;
import com.github.sparkzxl.system.admin.api.model.vo.OperateLogVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 系统日志 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface OperateLogConvert {

    OperateLogConvert INSTANCE = Mappers.getMapper(OperateLogConvert.class);

    /**
     * operateLogDTO转换为OperateLog
     *
     * @param operateLogDTO 系统日志DTO对象
     * @return OperateLog
     */
    OperateLog convertOperateLog(OperateLogDTO operateLogDTO);

    /**
     * OperateLog转换为OperateLogVO
     *
     * @param operateLog 系统日志DTO对象
     * @return OperateLogVO
     */
    OperateLogVO convertOperateLogVO(OperateLog operateLog);

    /**
     * operateLog列表转换为OperateLogVO列表
     *
     * @param operateLogList 系统日志列表
     * @return List<OperateLogVO>
     */
    List<OperateLogVO> convertOperateLogVOList(List<OperateLog> operateLogList);

    /**
     * 系统日志分页对象转换为OperateLogVO分页对象
     *
     * @param operateLogPage 系统日志分页对象
     * @return Page<OperateLogVO>
     */
    Page<OperateLogVO> convertOperateLogPageVO(Page<OperateLog> operateLogPage);
}
