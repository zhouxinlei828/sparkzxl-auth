package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Menu;
import com.github.sparkzxl.system.admin.api.model.vo.MenuVO;
import com.github.sparkzxl.system.admin.api.model.dto.MenuDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IMenuService {


    /**
    * 菜单分页条件查询
    * @param page 分页入参
    * @param menuDTO: 菜单DTO分页查询对象
    * @return Page<MenuVO>
    */
    Page<MenuVO> page(Page<Menu> page, MenuDTO menuDTO);


    /**
     * 菜单集合条件查询
     * @param menuDTO: 菜单DTO查询对象
     * @return List<MenuVO>
     */
    List<MenuVO> list(MenuDTO menuDTO);


    /**
     * 根据id查询菜单
     * @param id id
     * @return MenuVO
     */
    MenuVO getById(Long id);

    /**
     * 新增菜单
     * @param menuDTO: 菜单新增DTO
     * @return boolean
     */
     boolean save(MenuDTO menuDTO);


    /**
     * 修改菜单
     * @param menuDTO 菜单修改DTO
     * @return boolean
     */
     boolean updateById(MenuDTO menuDTO);


    /**
     * 根据id删除菜单
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
      * @param menuDTO 菜单导出DTO
      * @param response http response
      */
     void exportData(MenuDTO menuDTO, HttpServletResponse response);
}
