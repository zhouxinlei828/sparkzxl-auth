package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.system.admin.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.system.admin.application.service.IDictionaryItemService;
import com.github.sparkzxl.system.admin.domain.convert.DictionaryItemConvert;
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryItemVO;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryItemDTO;
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
 * 字典项 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryItemServiceImpl implements IDictionaryItemService {

    private final IDictionaryItemRepository iDictionaryItemRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param dictionaryItemDTO: 字典项DTO对象
    * @param page: 分页入参
    * @return Page<DictionaryItemVO>
    */
    @Override
    public Page<DictionaryItemVO> page(Page<DictionaryItem> page, DictionaryItemDTO dictionaryItemDTO) {
        queryPageCheck(dictionaryItemDTO);
        DictionaryItem dictionaryItem = convertPageQueryDictionaryItem(dictionaryItemDTO);
        QueryWrapper<DictionaryItem> queryWrapper = new QueryWrapper<>(dictionaryItem);
        buildPageQueryWrapper(dictionaryItem, queryWrapper);
        Page<DictionaryItem> dictionaryItemPage = iDictionaryItemRepository.page(page, queryWrapper);
        return assignment(convertDictionaryItemPageVO(dictionaryItemPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     */
    private void queryPageCheck(DictionaryItemDTO dictionaryItemDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     * @return DictionaryItem
     */
     private DictionaryItem convertPageQueryDictionaryItem(DictionaryItemDTO dictionaryItemDTO){
        return DictionaryItemConvert.INSTANCE.convertDictionaryItem(dictionaryItemDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItem: 字典项
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(DictionaryItem dictionaryItem, QueryWrapper<DictionaryItem> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemVOPage: 分页显示VO
     * @return Page<DictionaryItem>
     */
    private Page<DictionaryItemVO> assignment(Page<DictionaryItemVO> dictionaryItemVOPage) {
        dictionaryItemVOPage.getRecords().forEach(dictionaryItemVO -> {
        });
        return dictionaryItemVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<DictionaryItem>
     */
     private Page<DictionaryItemVO> convertDictionaryItemPageVO(Page<DictionaryItem> page){
        return DictionaryItemConvert.INSTANCE.convertDictionaryItemPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     * @return List<DictionaryItemVO>
     */
    @Override
    public List<DictionaryItemVO> list(DictionaryItemDTO dictionaryItemDTO) {
        queryListCheck(dictionaryItemDTO);
        DictionaryItem dictionaryItem = convertDictionaryItemListQuery(dictionaryItemDTO);
        QueryWrapper<DictionaryItem> queryWrapper = new QueryWrapper<>(dictionaryItem);
        buildListQueryWrapper(dictionaryItem, queryWrapper);
        List<DictionaryItem> dictionaryItemList = iDictionaryItemRepository.list(queryWrapper);
        List<DictionaryItemVO> dictionaryItemVOList = convertDictionaryItemVOList(dictionaryItemList);
        return assignment(dictionaryItemVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     */
     private void queryListCheck(DictionaryItemDTO dictionaryItemDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param dictionaryItemDTO: 字典项DTO对象
    * @return Page<DictionaryItem>
    */
    private DictionaryItem convertDictionaryItemListQuery(DictionaryItemDTO dictionaryItemDTO){
        return DictionaryItemConvert.INSTANCE.convertDictionaryItem(dictionaryItemDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param dictionaryItem: 字典项
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(DictionaryItem dictionaryItem, QueryWrapper<DictionaryItem> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemList: 字典项列表
     * @return List<DictionaryItemVO>
     */
     public List<DictionaryItemVO> convertDictionaryItemVOList(List<DictionaryItem> dictionaryItemList){
         return DictionaryItemConvert.INSTANCE.convertDictionaryItemVOList(dictionaryItemList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param dictionaryItemVOList: 字典项VO列表
      * @return List<DictionaryItem>
      */
     private List<DictionaryItemVO> assignment(List<DictionaryItemVO> dictionaryItemVOList) {
        dictionaryItemVOList.forEach(dictionaryItemVO -> {
        });
        return  dictionaryItemVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return DictionaryItemVO
     */
    @Override
    public DictionaryItemVO getById(Long id) {
        DictionaryItem dictionaryItem = iDictionaryItemRepository.getById(id);
        DictionaryItemVO dictionaryItemVO = convertDictionaryItemVO(dictionaryItem);
        return assignment(dictionaryItemVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItem: 字典项
     * @return DictionaryItemVO
     */
     private DictionaryItemVO convertDictionaryItemVO(DictionaryItem dictionaryItem){
        return DictionaryItemConvert.INSTANCE.convertDictionaryItemVO(dictionaryItem);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemVO: 字典项VO
     * @return DictionaryItem
     */
    private DictionaryItemVO assignment(DictionaryItemVO dictionaryItemVO) {
        return dictionaryItemVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(DictionaryItemDTO dictionaryItemDTO) {
        saveCheck(dictionaryItemDTO);
        DictionaryItem dictionaryItem = convertDictionaryItemSaveModel(dictionaryItemDTO);
        return iDictionaryItemRepository.save(dictionaryItem);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     */
    private void saveCheck(DictionaryItemDTO dictionaryItemDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     * @return DictionaryItem
     */
     private DictionaryItem convertDictionaryItemSaveModel(DictionaryItemDTO dictionaryItemDTO){
        return DictionaryItemConvert.INSTANCE.convertDictionaryItem(dictionaryItemDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(DictionaryItemDTO dictionaryItemDTO) {
        updateCheck(dictionaryItemDTO);
        DictionaryItem dictionaryItem = convertUpdateDictionaryItemModel(dictionaryItemDTO);
        LambdaUpdateWrapper<DictionaryItem> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(dictionaryItem,lambdaUpdateWrapper);
        return iDictionaryItemRepository.update(dictionaryItem,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     */
     private void updateCheck(DictionaryItemDTO dictionaryItemDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItem: 字典项
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(DictionaryItem dictionaryItem, LambdaUpdateWrapper<DictionaryItem> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(DictionaryItem::getId,dictionaryItem.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param dictionaryItemDTO: 字典项DTO对象
     * @return DictionaryItem
     */
    public DictionaryItem convertUpdateDictionaryItemModel(DictionaryItemDTO dictionaryItemDTO){
        if(ObjectUtils.isEmpty(dictionaryItemDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return DictionaryItemConvert.INSTANCE.convertDictionaryItem(dictionaryItemDTO);
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
        return iDictionaryItemRepository.removeById(id);
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
     * @param dictionaryItemDTO 字典项导出DTO
     * @param response http response
     */
     @Override
     public void exportData(DictionaryItemDTO dictionaryItemDTO, HttpServletResponse response){

    }
}

