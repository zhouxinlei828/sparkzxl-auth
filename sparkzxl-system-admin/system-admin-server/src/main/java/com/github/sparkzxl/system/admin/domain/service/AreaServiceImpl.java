package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Area;
import com.github.sparkzxl.system.admin.domain.repository.IAreaRepository;
import com.github.sparkzxl.system.admin.application.service.IAreaService;
import com.github.sparkzxl.system.admin.domain.convert.AreaConvert;
import com.github.sparkzxl.system.admin.api.model.vo.AreaVO;
import com.github.sparkzxl.system.admin.api.model.dto.AreaDTO;
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
 * 地区表 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements IAreaService {

    private final IAreaRepository iAreaRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param areaDTO: 地区表DTO对象
    * @param page: 分页入参
    * @return Page<AreaVO>
    */
    @Override
    public Page<AreaVO> page(Page<Area> page, AreaDTO areaDTO) {
        queryPageCheck(areaDTO);
        Area area = convertPageQueryArea(areaDTO);
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>(area);
        buildPageQueryWrapper(area, queryWrapper);
        Page<Area> areaPage = iAreaRepository.page(page, queryWrapper);
        return assignment(convertAreaPageVO(areaPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     */
    private void queryPageCheck(AreaDTO areaDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     * @return Area
     */
     private Area convertPageQueryArea(AreaDTO areaDTO){
        return AreaConvert.INSTANCE.convertArea(areaDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param area: 地区表
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Area area, QueryWrapper<Area> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaVOPage: 分页显示VO
     * @return Page<Area>
     */
    private Page<AreaVO> assignment(Page<AreaVO> areaVOPage) {
        areaVOPage.getRecords().forEach(areaVO -> {
        });
        return areaVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Area>
     */
     private Page<AreaVO> convertAreaPageVO(Page<Area> page){
        return AreaConvert.INSTANCE.convertAreaPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     * @return List<AreaVO>
     */
    @Override
    public List<AreaVO> list(AreaDTO areaDTO) {
        queryListCheck(areaDTO);
        Area area = convertAreaListQuery(areaDTO);
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>(area);
        buildListQueryWrapper(area, queryWrapper);
        List<Area> areaList = iAreaRepository.list(queryWrapper);
        List<AreaVO> areaVOList = convertAreaVOList(areaList);
        return assignment(areaVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     */
     private void queryListCheck(AreaDTO areaDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param areaDTO: 地区表DTO对象
    * @return Page<Area>
    */
    private Area convertAreaListQuery(AreaDTO areaDTO){
        return AreaConvert.INSTANCE.convertArea(areaDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param area: 地区表
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Area area, QueryWrapper<Area> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaList: 地区表列表
     * @return List<AreaVO>
     */
     public List<AreaVO> convertAreaVOList(List<Area> areaList){
         return AreaConvert.INSTANCE.convertAreaVOList(areaList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param areaVOList: 地区表VO列表
      * @return List<Area>
      */
     private List<AreaVO> assignment(List<AreaVO> areaVOList) {
        areaVOList.forEach(areaVO -> {
        });
        return  areaVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return AreaVO
     */
    @Override
    public AreaVO getById(Long id) {
        Area area = iAreaRepository.getById(id);
        AreaVO areaVO = convertAreaVO(area);
        return assignment(areaVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param area: 地区表
     * @return AreaVO
     */
     private AreaVO convertAreaVO(Area area){
        return AreaConvert.INSTANCE.convertAreaVO(area);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaVO: 地区表VO
     * @return Area
     */
    private AreaVO assignment(AreaVO areaVO) {
        return areaVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(AreaDTO areaDTO) {
        saveCheck(areaDTO);
        Area area = convertAreaSaveModel(areaDTO);
        return iAreaRepository.save(area);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     */
    private void saveCheck(AreaDTO areaDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     * @return Area
     */
     private Area convertAreaSaveModel(AreaDTO areaDTO){
        return AreaConvert.INSTANCE.convertArea(areaDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(AreaDTO areaDTO) {
        updateCheck(areaDTO);
        Area area = convertUpdateAreaModel(areaDTO);
        LambdaUpdateWrapper<Area> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(area,lambdaUpdateWrapper);
        return iAreaRepository.update(area,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     */
     private void updateCheck(AreaDTO areaDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param area: 地区表
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Area area, LambdaUpdateWrapper<Area> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Area::getId,area.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param areaDTO: 地区表DTO对象
     * @return Area
     */
    public Area convertUpdateAreaModel(AreaDTO areaDTO){
        if(ObjectUtils.isEmpty(areaDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return AreaConvert.INSTANCE.convertArea(areaDTO);
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
        return iAreaRepository.removeById(id);
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
     * @param areaDTO 地区表导出DTO
     * @param response http response
     */
     @Override
     public void exportData(AreaDTO areaDTO, HttpServletResponse response){

    }
}

