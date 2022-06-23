package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.User;
import com.github.sparkzxl.system.admin.api.model.vo.UserVO;
import com.github.sparkzxl.system.admin.api.model.dto.UserDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IUserService {


    /**
    * 用户信息分页条件查询
    * @param page 分页入参
    * @param userDTO: 用户信息DTO分页查询对象
    * @return Page<UserVO>
    */
    Page<UserVO> page(Page<User> page, UserDTO userDTO);


    /**
     * 用户信息集合条件查询
     * @param userDTO: 用户信息DTO查询对象
     * @return List<UserVO>
     */
    List<UserVO> list(UserDTO userDTO);


    /**
     * 根据id查询用户信息
     * @param id id
     * @return UserVO
     */
    UserVO getById(Long id);

    /**
     * 新增用户信息
     * @param userDTO: 用户信息新增DTO
     * @return boolean
     */
     boolean save(UserDTO userDTO);


    /**
     * 修改用户信息
     * @param userDTO 用户信息修改DTO
     * @return boolean
     */
     boolean updateById(UserDTO userDTO);


    /**
     * 根据id删除用户信息
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
      * @param userDTO 用户信息导出DTO
      * @param response http response
      */
     void exportData(UserDTO userDTO, HttpServletResponse response);
}
