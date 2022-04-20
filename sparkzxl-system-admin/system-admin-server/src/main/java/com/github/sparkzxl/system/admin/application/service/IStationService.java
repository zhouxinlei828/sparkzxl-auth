package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Station;
import com.github.sparkzxl.system.admin.api.model.vo.StationVO;
import com.github.sparkzxl.system.admin.api.model.dto.StationDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IStationService {


    /**
    * 岗位信息分页条件查询
    * @param page 分页入参
    * @param stationDTO: 岗位信息DTO分页查询对象
    * @return Page<StationVO>
    */
    Page<StationVO> page(Page<Station> page, StationDTO stationDTO);


    /**
     * 岗位信息集合条件查询
     * @param stationDTO: 岗位信息DTO查询对象
     * @return List<StationVO>
     */
    List<StationVO> list(StationDTO stationDTO);


    /**
     * 根据id查询岗位信息
     * @param id id
     * @return StationVO
     */
    StationVO getById(Long id);

    /**
     * 新增岗位信息
     * @param stationDTO: 岗位信息新增DTO
     * @return boolean
     */
     boolean save(StationDTO stationDTO);


    /**
     * 修改岗位信息
     * @param stationDTO 岗位信息修改DTO
     * @return boolean
     */
     boolean updateById(StationDTO stationDTO);


    /**
     * 根据id删除岗位信息
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
      * @param stationDTO 岗位信息导出DTO
      * @param response http response
      */
     void exportData(StationDTO stationDTO, HttpServletResponse response);
}
