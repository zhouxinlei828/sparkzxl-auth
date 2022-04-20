package com.github.sparkzxl.system.admin.application.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Dictionary;
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryVO;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 字典类型 服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
public interface IDictionaryService {


    /**
    * 字典类型分页条件查询
    * @param page 分页入参
    * @param dictionaryDTO: 字典类型DTO分页查询对象
    * @return Page<DictionaryVO>
    */
    Page<DictionaryVO> page(Page<Dictionary> page, DictionaryDTO dictionaryDTO);


    /**
     * 字典类型集合条件查询
     * @param dictionaryDTO: 字典类型DTO查询对象
     * @return List<DictionaryVO>
     */
    List<DictionaryVO> list(DictionaryDTO dictionaryDTO);


    /**
     * 根据id查询字典类型
     * @param id id
     * @return DictionaryVO
     */
    DictionaryVO getById(Long id);

    /**
     * 新增字典类型
     * @param dictionaryDTO: 字典类型新增DTO
     * @return boolean
     */
     boolean save(DictionaryDTO dictionaryDTO);


    /**
     * 修改字典类型
     * @param dictionaryDTO 字典类型修改DTO
     * @return boolean
     */
     boolean updateById(DictionaryDTO dictionaryDTO);


    /**
     * 根据id删除字典类型
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
      * @param dictionaryDTO 字典类型导出DTO
      * @param response http response
      */
     void exportData(DictionaryDTO dictionaryDTO, HttpServletResponse response);
}
