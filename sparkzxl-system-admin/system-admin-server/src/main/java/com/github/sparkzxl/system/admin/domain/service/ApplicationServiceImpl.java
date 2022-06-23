package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Application;
import com.github.sparkzxl.system.admin.domain.repository.IApplicationRepository;
import com.github.sparkzxl.system.admin.application.service.IApplicationService;
import com.github.sparkzxl.system.admin.domain.convert.ApplicationConvert;
import com.github.sparkzxl.system.admin.api.model.vo.ApplicationVO;
import com.github.sparkzxl.system.admin.api.model.dto.ApplicationDTO;
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
 * 应用 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements IApplicationService {

    private final IApplicationRepository iApplicationRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param applicationDTO: 应用DTO对象
    * @param page: 分页入参
    * @return Page<ApplicationVO>
    */
    @Override
    public Page<ApplicationVO> page(Page<Application> page, ApplicationDTO applicationDTO) {
        queryPageCheck(applicationDTO);
        Application application = convertPageQueryApplication(applicationDTO);
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>(application);
        buildPageQueryWrapper(application, queryWrapper);
        Page<Application> applicationPage = iApplicationRepository.page(page, queryWrapper);
        return assignment(convertApplicationPageVO(applicationPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     */
    private void queryPageCheck(ApplicationDTO applicationDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     * @return Application
     */
     private Application convertPageQueryApplication(ApplicationDTO applicationDTO){
        return ApplicationConvert.INSTANCE.convertApplication(applicationDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param application: 应用
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Application application, QueryWrapper<Application> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationVOPage: 分页显示VO
     * @return Page<Application>
     */
    private Page<ApplicationVO> assignment(Page<ApplicationVO> applicationVOPage) {
        applicationVOPage.getRecords().forEach(applicationVO -> {
        });
        return applicationVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Application>
     */
     private Page<ApplicationVO> convertApplicationPageVO(Page<Application> page){
        return ApplicationConvert.INSTANCE.convertApplicationPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     * @return List<ApplicationVO>
     */
    @Override
    public List<ApplicationVO> list(ApplicationDTO applicationDTO) {
        queryListCheck(applicationDTO);
        Application application = convertApplicationListQuery(applicationDTO);
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>(application);
        buildListQueryWrapper(application, queryWrapper);
        List<Application> applicationList = iApplicationRepository.list(queryWrapper);
        List<ApplicationVO> applicationVOList = convertApplicationVOList(applicationList);
        return assignment(applicationVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     */
     private void queryListCheck(ApplicationDTO applicationDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param applicationDTO: 应用DTO对象
    * @return Page<Application>
    */
    private Application convertApplicationListQuery(ApplicationDTO applicationDTO){
        return ApplicationConvert.INSTANCE.convertApplication(applicationDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param application: 应用
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Application application, QueryWrapper<Application> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationList: 应用列表
     * @return List<ApplicationVO>
     */
     public List<ApplicationVO> convertApplicationVOList(List<Application> applicationList){
         return ApplicationConvert.INSTANCE.convertApplicationVOList(applicationList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param applicationVOList: 应用VO列表
      * @return List<Application>
      */
     private List<ApplicationVO> assignment(List<ApplicationVO> applicationVOList) {
        applicationVOList.forEach(applicationVO -> {
        });
        return  applicationVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return ApplicationVO
     */
    @Override
    public ApplicationVO getById(Long id) {
        Application application = iApplicationRepository.getById(id);
        ApplicationVO applicationVO = convertApplicationVO(application);
        return assignment(applicationVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param application: 应用
     * @return ApplicationVO
     */
     private ApplicationVO convertApplicationVO(Application application){
        return ApplicationConvert.INSTANCE.convertApplicationVO(application);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationVO: 应用VO
     * @return Application
     */
    private ApplicationVO assignment(ApplicationVO applicationVO) {
        return applicationVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(ApplicationDTO applicationDTO) {
        saveCheck(applicationDTO);
        Application application = convertApplicationSaveModel(applicationDTO);
        return iApplicationRepository.save(application);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     */
    private void saveCheck(ApplicationDTO applicationDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     * @return Application
     */
     private Application convertApplicationSaveModel(ApplicationDTO applicationDTO){
        return ApplicationConvert.INSTANCE.convertApplication(applicationDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(ApplicationDTO applicationDTO) {
        updateCheck(applicationDTO);
        Application application = convertUpdateApplicationModel(applicationDTO);
        LambdaUpdateWrapper<Application> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(application,lambdaUpdateWrapper);
        return iApplicationRepository.update(application,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     */
     private void updateCheck(ApplicationDTO applicationDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param application: 应用
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Application application, LambdaUpdateWrapper<Application> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Application::getId,application.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param applicationDTO: 应用DTO对象
     * @return Application
     */
    public Application convertUpdateApplicationModel(ApplicationDTO applicationDTO){
        if(ObjectUtils.isEmpty(applicationDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return ApplicationConvert.INSTANCE.convertApplication(applicationDTO);
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
        return iApplicationRepository.removeById(id);
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
     * @param applicationDTO 应用导出DTO
     * @param response http response
     */
     @Override
     public void exportData(ApplicationDTO applicationDTO, HttpServletResponse response){

    }
}

