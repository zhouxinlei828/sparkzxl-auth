package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Station;
import com.github.sparkzxl.system.admin.domain.repository.IStationRepository;
import com.github.sparkzxl.system.admin.application.service.IStationService;
import com.github.sparkzxl.system.admin.domain.convert.StationConvert;
import com.github.sparkzxl.system.admin.api.model.vo.StationVO;
import com.github.sparkzxl.system.admin.api.model.dto.StationDTO;
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
 * 岗位信息 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StationServiceImpl implements IStationService {

    private final IStationRepository iStationRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param stationDTO: 岗位信息DTO对象
    * @param page: 分页入参
    * @return Page<StationVO>
    */
    @Override
    public Page<StationVO> page(Page<Station> page, StationDTO stationDTO) {
        queryPageCheck(stationDTO);
        Station station = convertPageQueryStation(stationDTO);
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>(station);
        buildPageQueryWrapper(station, queryWrapper);
        Page<Station> stationPage = iStationRepository.page(page, queryWrapper);
        return assignment(convertStationPageVO(stationPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     */
    private void queryPageCheck(StationDTO stationDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     * @return Station
     */
     private Station convertPageQueryStation(StationDTO stationDTO){
        return StationConvert.INSTANCE.convertStation(stationDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param station: 岗位信息
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Station station, QueryWrapper<Station> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationVOPage: 分页显示VO
     * @return Page<Station>
     */
    private Page<StationVO> assignment(Page<StationVO> stationVOPage) {
        stationVOPage.getRecords().forEach(stationVO -> {
        });
        return stationVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Station>
     */
     private Page<StationVO> convertStationPageVO(Page<Station> page){
        return StationConvert.INSTANCE.convertStationPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     * @return List<StationVO>
     */
    @Override
    public List<StationVO> list(StationDTO stationDTO) {
        queryListCheck(stationDTO);
        Station station = convertStationListQuery(stationDTO);
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>(station);
        buildListQueryWrapper(station, queryWrapper);
        List<Station> stationList = iStationRepository.list(queryWrapper);
        List<StationVO> stationVOList = convertStationVOList(stationList);
        return assignment(stationVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     */
     private void queryListCheck(StationDTO stationDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param stationDTO: 岗位信息DTO对象
    * @return Page<Station>
    */
    private Station convertStationListQuery(StationDTO stationDTO){
        return StationConvert.INSTANCE.convertStation(stationDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param station: 岗位信息
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Station station, QueryWrapper<Station> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationList: 岗位信息列表
     * @return List<StationVO>
     */
     public List<StationVO> convertStationVOList(List<Station> stationList){
         return StationConvert.INSTANCE.convertStationVOList(stationList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param stationVOList: 岗位信息VO列表
      * @return List<Station>
      */
     private List<StationVO> assignment(List<StationVO> stationVOList) {
        stationVOList.forEach(stationVO -> {
        });
        return  stationVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return StationVO
     */
    @Override
    public StationVO getById(Long id) {
        Station station = iStationRepository.getById(id);
        StationVO stationVO = convertStationVO(station);
        return assignment(stationVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param station: 岗位信息
     * @return StationVO
     */
     private StationVO convertStationVO(Station station){
        return StationConvert.INSTANCE.convertStationVO(station);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationVO: 岗位信息VO
     * @return Station
     */
    private StationVO assignment(StationVO stationVO) {
        return stationVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(StationDTO stationDTO) {
        saveCheck(stationDTO);
        Station station = convertStationSaveModel(stationDTO);
        return iStationRepository.save(station);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     */
    private void saveCheck(StationDTO stationDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     * @return Station
     */
     private Station convertStationSaveModel(StationDTO stationDTO){
        return StationConvert.INSTANCE.convertStation(stationDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(StationDTO stationDTO) {
        updateCheck(stationDTO);
        Station station = convertUpdateStationModel(stationDTO);
        LambdaUpdateWrapper<Station> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(station,lambdaUpdateWrapper);
        return iStationRepository.update(station,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     */
     private void updateCheck(StationDTO stationDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param station: 岗位信息
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Station station, LambdaUpdateWrapper<Station> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Station::getId,station.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param stationDTO: 岗位信息DTO对象
     * @return Station
     */
    public Station convertUpdateStationModel(StationDTO stationDTO){
        if(ObjectUtils.isEmpty(stationDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return StationConvert.INSTANCE.convertStation(stationDTO);
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
        return iStationRepository.removeById(id);
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
     * @param stationDTO 岗位信息导出DTO
     * @param response http response
     */
     @Override
     public void exportData(StationDTO stationDTO, HttpServletResponse response){

    }
}

