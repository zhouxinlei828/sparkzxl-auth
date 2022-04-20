package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryItemVO;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryItemDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 字典项 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IDictionaryItemService {


    /**
    * 字典项分页条件查询
    * @param page 分页入参
    * @param dictionaryItemDTO: 字典项DTO分页查询对象
    * @return Page<DictionaryItemVO>
    */
    Page<DictionaryItemVO> page(Page<DictionaryItem> page, DictionaryItemDTO dictionaryItemDTO);


    /**
     * 字典项集合条件查询
     * @param dictionaryItemDTO: 字典项DTO查询对象
     * @return List<DictionaryItemVO>
     */
    List<DictionaryItemVO> list(DictionaryItemDTO dictionaryItemDTO);


    /**
     * 根据id查询字典项
     * @param id id
     * @return DictionaryItemVO
     */
    DictionaryItemVO getById(Long id);

    /**
     * 新增字典项
     * @param dictionaryItemDTO: 字典项新增DTO
     * @return boolean
     */
     boolean save(DictionaryItemDTO dictionaryItemDTO);


    /**
     * 修改字典项
     * @param dictionaryItemDTO 字典项修改DTO
     * @return boolean
     */
     boolean updateById(DictionaryItemDTO dictionaryItemDTO);


    /**
     * 根据id删除字典项
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
      * @param dictionaryItemDTO 字典项导出DTO
      * @param response http response
      */
     void exportData(DictionaryItemDTO dictionaryItemDTO, HttpServletResponse response);
}
