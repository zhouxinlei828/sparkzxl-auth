package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.LoginLog;
import com.github.sparkzxl.system.admin.api.model.vo.LoginLogVO;
import com.github.sparkzxl.system.admin.api.model.dto.LoginLogDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 登录日志 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface ILoginLogService {


    /**
    * 登录日志分页条件查询
    * @param page 分页入参
    * @param loginLogDTO: 登录日志DTO分页查询对象
    * @return Page<LoginLogVO>
    */
    Page<LoginLogVO> page(Page<LoginLog> page, LoginLogDTO loginLogDTO);


    /**
     * 登录日志集合条件查询
     * @param loginLogDTO: 登录日志DTO查询对象
     * @return List<LoginLogVO>
     */
    List<LoginLogVO> list(LoginLogDTO loginLogDTO);


    /**
     * 根据id查询登录日志
     * @param id id
     * @return LoginLogVO
     */
    LoginLogVO getById(Long id);

    /**
     * 新增登录日志
     * @param loginLogDTO: 登录日志新增DTO
     * @return boolean
     */
     boolean save(LoginLogDTO loginLogDTO);


    /**
     * 修改登录日志
     * @param loginLogDTO 登录日志修改DTO
     * @return boolean
     */
     boolean updateById(LoginLogDTO loginLogDTO);


    /**
     * 根据id删除登录日志
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
      * @param loginLogDTO 登录日志导出DTO
      * @param response http response
      */
     void exportData(LoginLogDTO loginLogDTO, HttpServletResponse response);
}
