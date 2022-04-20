package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Dictionary;
import com.github.sparkzxl.system.admin.domain.repository.IDictionaryRepository;
import com.github.sparkzxl.system.admin.application.service.IDictionaryService;
import com.github.sparkzxl.system.admin.domain.convert.DictionaryConvert;
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryVO;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryDTO;
import org.apache.commons.lang3.ObjectUtils;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 字典类型 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements IDictionaryService {

    private final IDictionaryRepository iDictionaryRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param dictionaryDTO: 字典类型DTO对象
    * @param page: 分页入参
    * @return Page<DictionaryVO>
    */
    @Override
    public Page<DictionaryVO> page(Page<Dictionary> page, DictionaryDTO dictionaryDTO) {
        queryPageCheck(dictionaryDTO);
        Dictionary dictionary = convertPageQueryDictionary(dictionaryDTO);
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>(dictionary);
        buildPageQueryWrapper(dictionary, queryWrapper);
        Page<Dictionary> dictionaryPage = iDictionaryRepository.page(page, queryWrapper);
        return assignment(convertDictionaryPageVO(dictionaryPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     */
    private void queryPageCheck(DictionaryDTO dictionaryDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     * @return Dictionary
     */
     private Dictionary convertPageQueryDictionary(DictionaryDTO dictionaryDTO){
        return DictionaryConvert.INSTANCE.convertDictionary(dictionaryDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionary: 字典类型
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Dictionary dictionary, QueryWrapper<Dictionary> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryVOPage: 分页显示VO
     * @return Page<Dictionary>
     */
    private Page<DictionaryVO> assignment(Page<DictionaryVO> dictionaryVOPage) {
        dictionaryVOPage.getRecords().forEach(dictionaryVO -> {
        });
        return dictionaryVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Dictionary>
     */
     private Page<DictionaryVO> convertDictionaryPageVO(Page<Dictionary> page){
        return DictionaryConvert.INSTANCE.convertDictionaryPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     * @return List<DictionaryVO>
     */
    @Override
    public List<DictionaryVO> list(DictionaryDTO dictionaryDTO) {
        queryListCheck(dictionaryDTO);
        Dictionary dictionary = convertDictionaryListQuery(dictionaryDTO);
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>(dictionary);
        buildListQueryWrapper(dictionary, queryWrapper);
        List<Dictionary> dictionaryList = iDictionaryRepository.list(queryWrapper);
        List<DictionaryVO> dictionaryVOList = convertDictionaryVOList(dictionaryList);
        return assignment(dictionaryVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     */
     private void queryListCheck(DictionaryDTO dictionaryDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param dictionaryDTO: 字典类型DTO对象
    * @return Page<Dictionary>
    */
    private Dictionary convertDictionaryListQuery(DictionaryDTO dictionaryDTO){
        return DictionaryConvert.INSTANCE.convertDictionary(dictionaryDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param dictionary: 字典类型
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Dictionary dictionary, QueryWrapper<Dictionary> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryList: 字典类型列表
     * @return List<DictionaryVO>
     */
     public List<DictionaryVO> convertDictionaryVOList(List<Dictionary> dictionaryList){
         return DictionaryConvert.INSTANCE.convertDictionaryVOList(dictionaryList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param dictionaryVOList: 字典类型VO列表
      * @return List<Dictionary>
      */
     private List<DictionaryVO> assignment(List<DictionaryVO> dictionaryVOList) {
        dictionaryVOList.forEach(dictionaryVO -> {
        });
        return  dictionaryVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return DictionaryVO
     */
    @Override
    public DictionaryVO getById(Long id) {
        Dictionary dictionary = iDictionaryRepository.getById(id);
        DictionaryVO dictionaryVO = convertDictionaryVO(dictionary);
        return assignment(dictionaryVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionary: 字典类型
     * @return DictionaryVO
     */
     private DictionaryVO convertDictionaryVO(Dictionary dictionary){
        return DictionaryConvert.INSTANCE.convertDictionaryVO(dictionary);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryVO: 字典类型VO
     * @return Dictionary
     */
    private DictionaryVO assignment(DictionaryVO dictionaryVO) {
        return dictionaryVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(DictionaryDTO dictionaryDTO) {
        saveCheck(dictionaryDTO);
        Dictionary dictionary = convertDictionarySaveModel(dictionaryDTO);
        return iDictionaryRepository.save(dictionary);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     */
    private void saveCheck(DictionaryDTO dictionaryDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     * @return Dictionary
     */
     private Dictionary convertDictionarySaveModel(DictionaryDTO dictionaryDTO){
        return DictionaryConvert.INSTANCE.convertDictionary(dictionaryDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(DictionaryDTO dictionaryDTO) {
        updateCheck(dictionaryDTO);
        Dictionary dictionary = convertUpdateDictionaryModel(dictionaryDTO);
        LambdaUpdateWrapper<Dictionary> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(dictionary,lambdaUpdateWrapper);
        return iDictionaryRepository.update(dictionary,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     */
     private void updateCheck(DictionaryDTO dictionaryDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionary: 字典类型
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Dictionary dictionary, LambdaUpdateWrapper<Dictionary> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Dictionary::getId,dictionary.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO: 字典类型DTO对象
     * @return Dictionary
     */
    public Dictionary convertUpdateDictionaryModel(DictionaryDTO dictionaryDTO){
        if(ObjectUtils.isEmpty(dictionaryDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return DictionaryConvert.INSTANCE.convertDictionary(dictionaryDTO);
    }

    /**
     * 删除
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean deleteById(Long id) {
        return iDictionaryRepository.removeById(id);
    }

    /**
     * Excel导入
     * @author zhouxinlei
     * @since 2022-04-20
     * @param multipartFile: 文件
     * @return Integer
     */
    @Override
    public Integer importExcel(MultipartFile multipartFile){
        return 0;
    }

    /**
     * Excel导出
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryDTO 字典类型导出DTO
     * @param response http response
     */
     @Override
     public void exportData(DictionaryDTO dictionaryDTO, HttpServletResponse response){

    }
}

