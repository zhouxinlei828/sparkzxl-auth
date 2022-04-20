package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Parameter;
import com.github.sparkzxl.system.admin.domain.repository.IParameterRepository;
import com.github.sparkzxl.system.admin.application.service.IParameterService;
import com.github.sparkzxl.system.admin.domain.convert.ParameterConvert;
import com.github.sparkzxl.system.admin.api.model.vo.ParameterVO;
import com.github.sparkzxl.system.admin.api.model.dto.ParameterDTO;
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
 * 系统参数 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ParameterServiceImpl implements IParameterService {

    private final IParameterRepository iParameterRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param parameterDTO: 系统参数DTO对象
    * @param page: 分页入参
    * @return Page<ParameterVO>
    */
    @Override
    public Page<ParameterVO> page(Page<Parameter> page, ParameterDTO parameterDTO) {
        queryPageCheck(parameterDTO);
        Parameter parameter = convertPageQueryParameter(parameterDTO);
        QueryWrapper<Parameter> queryWrapper = new QueryWrapper<>(parameter);
        buildPageQueryWrapper(parameter, queryWrapper);
        Page<Parameter> parameterPage = iParameterRepository.page(page, queryWrapper);
        return assignment(convertParameterPageVO(parameterPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     */
    private void queryPageCheck(ParameterDTO parameterDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     * @return Parameter
     */
     private Parameter convertPageQueryParameter(ParameterDTO parameterDTO){
        return ParameterConvert.INSTANCE.convertParameter(parameterDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameter: 系统参数
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Parameter parameter, QueryWrapper<Parameter> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterVOPage: 分页显示VO
     * @return Page<Parameter>
     */
    private Page<ParameterVO> assignment(Page<ParameterVO> parameterVOPage) {
        parameterVOPage.getRecords().forEach(parameterVO -> {
        });
        return parameterVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Parameter>
     */
     private Page<ParameterVO> convertParameterPageVO(Page<Parameter> page){
        return ParameterConvert.INSTANCE.convertParameterPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     * @return List<ParameterVO>
     */
    @Override
    public List<ParameterVO> list(ParameterDTO parameterDTO) {
        queryListCheck(parameterDTO);
        Parameter parameter = convertParameterListQuery(parameterDTO);
        QueryWrapper<Parameter> queryWrapper = new QueryWrapper<>(parameter);
        buildListQueryWrapper(parameter, queryWrapper);
        List<Parameter> parameterList = iParameterRepository.list(queryWrapper);
        List<ParameterVO> parameterVOList = convertParameterVOList(parameterList);
        return assignment(parameterVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     */
     private void queryListCheck(ParameterDTO parameterDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param parameterDTO: 系统参数DTO对象
    * @return Page<Parameter>
    */
    private Parameter convertParameterListQuery(ParameterDTO parameterDTO){
        return ParameterConvert.INSTANCE.convertParameter(parameterDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param parameter: 系统参数
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Parameter parameter, QueryWrapper<Parameter> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterList: 系统参数列表
     * @return List<ParameterVO>
     */
     public List<ParameterVO> convertParameterVOList(List<Parameter> parameterList){
         return ParameterConvert.INSTANCE.convertParameterVOList(parameterList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param parameterVOList: 系统参数VO列表
      * @return List<Parameter>
      */
     private List<ParameterVO> assignment(List<ParameterVO> parameterVOList) {
        parameterVOList.forEach(parameterVO -> {
        });
        return  parameterVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return ParameterVO
     */
    @Override
    public ParameterVO getById(Long id) {
        Parameter parameter = iParameterRepository.getById(id);
        ParameterVO parameterVO = convertParameterVO(parameter);
        return assignment(parameterVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameter: 系统参数
     * @return ParameterVO
     */
     private ParameterVO convertParameterVO(Parameter parameter){
        return ParameterConvert.INSTANCE.convertParameterVO(parameter);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterVO: 系统参数VO
     * @return Parameter
     */
    private ParameterVO assignment(ParameterVO parameterVO) {
        return parameterVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(ParameterDTO parameterDTO) {
        saveCheck(parameterDTO);
        Parameter parameter = convertParameterSaveModel(parameterDTO);
        return iParameterRepository.save(parameter);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     */
    private void saveCheck(ParameterDTO parameterDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     * @return Parameter
     */
     private Parameter convertParameterSaveModel(ParameterDTO parameterDTO){
        return ParameterConvert.INSTANCE.convertParameter(parameterDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(ParameterDTO parameterDTO) {
        updateCheck(parameterDTO);
        Parameter parameter = convertUpdateParameterModel(parameterDTO);
        LambdaUpdateWrapper<Parameter> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(parameter,lambdaUpdateWrapper);
        return iParameterRepository.update(parameter,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     */
     private void updateCheck(ParameterDTO parameterDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameter: 系统参数
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Parameter parameter, LambdaUpdateWrapper<Parameter> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Parameter::getId,parameter.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param parameterDTO: 系统参数DTO对象
     * @return Parameter
     */
    public Parameter convertUpdateParameterModel(ParameterDTO parameterDTO){
        if(ObjectUtils.isEmpty(parameterDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return ParameterConvert.INSTANCE.convertParameter(parameterDTO);
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
        return iParameterRepository.removeById(id);
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
     * @param parameterDTO 系统参数导出DTO
     * @param response http response
     */
     @Override
     public void exportData(ParameterDTO parameterDTO, HttpServletResponse response){

    }
}

