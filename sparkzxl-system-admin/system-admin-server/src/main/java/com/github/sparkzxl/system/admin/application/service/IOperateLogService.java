package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.OperateLog;
import com.github.sparkzxl.system.admin.api.model.vo.OperateLogVO;
import com.github.sparkzxl.system.admin.api.model.dto.OperateLogDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IOperateLogService {


    /**
    * 系统日志分页条件查询
    * @param page 分页入参
    * @param operateLogDTO: 系统日志DTO分页查询对象
    * @return Page<OperateLogVO>
    */
    Page<OperateLogVO> page(Page<OperateLog> page, OperateLogDTO operateLogDTO);


    /**
     * 系统日志集合条件查询
     * @param operateLogDTO: 系统日志DTO查询对象
     * @return List<OperateLogVO>
     */
    List<OperateLogVO> list(OperateLogDTO operateLogDTO);


    /**
     * 根据id查询系统日志
     * @param id id
     * @return OperateLogVO
     */
    OperateLogVO getById(Long id);

    /**
     * 新增系统日志
     * @param operateLogDTO: 系统日志新增DTO
     * @return boolean
     */
     boolean save(OperateLogDTO operateLogDTO);


    /**
     * 修改系统日志
     * @param operateLogDTO 系统日志修改DTO
     * @return boolean
     */
     boolean updateById(OperateLogDTO operateLogDTO);


    /**
     * 根据id删除系统日志
     * @param id id
     * @return boolean
     */
     boolean deleteById(Long id);


    /**
     * Excel导入
     * @param multipartFile 文件
     * @return Integer
     */
     Integer importExcel(MultipartFile multipartFile);


     /**
      * Excel导出
      * @param operateLogDTO 系统日志导出DTO
      * @param response http response
      */
     void exportData(OperateLogDTO operateLogDTO, HttpServletResponse response);
}
