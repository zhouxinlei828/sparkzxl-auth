package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Area;
import com.github.sparkzxl.system.admin.api.model.vo.AreaVO;
import com.github.sparkzxl.system.admin.api.model.dto.AreaDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IAreaService {


    /**
    * 地区表分页条件查询
    * @param page 分页入参
    * @param areaDTO: 地区表DTO分页查询对象
    * @return Page<AreaVO>
    */
    Page<AreaVO> page(Page<Area> page, AreaDTO areaDTO);


    /**
     * 地区表集合条件查询
     * @param areaDTO: 地区表DTO查询对象
     * @return List<AreaVO>
     */
    List<AreaVO> list(AreaDTO areaDTO);


    /**
     * 根据id查询地区表
     * @param id id
     * @return AreaVO
     */
    AreaVO getById(Long id);

    /**
     * 新增地区表
     * @param areaDTO: 地区表新增DTO
     * @return boolean
     */
     boolean save(AreaDTO areaDTO);


    /**
     * 修改地区表
     * @param areaDTO 地区表修改DTO
     * @return boolean
     */
     boolean updateById(AreaDTO areaDTO);


    /**
     * 根据id删除地区表
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
      * @param areaDTO 地区表导出DTO
      * @param response http response
      */
     void exportData(AreaDTO areaDTO, HttpServletResponse response);
}
