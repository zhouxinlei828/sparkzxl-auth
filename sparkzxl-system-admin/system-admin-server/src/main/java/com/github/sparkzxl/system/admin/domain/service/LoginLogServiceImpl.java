package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.LoginLog;
import com.github.sparkzxl.system.admin.domain.repository.ILoginLogRepository;
import com.github.sparkzxl.system.admin.application.service.ILoginLogService;
import com.github.sparkzxl.system.admin.domain.convert.LoginLogConvert;
import com.github.sparkzxl.system.admin.api.model.vo.LoginLogVO;
import com.github.sparkzxl.system.admin.api.model.dto.LoginLogDTO;
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
 * 登录日志 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements ILoginLogService {

    private final ILoginLogRepository iLoginLogRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param loginLogDTO: 登录日志DTO对象
    * @param page: 分页入参
    * @return Page<LoginLogVO>
    */
    @Override
    public Page<LoginLogVO> page(Page<LoginLog> page, LoginLogDTO loginLogDTO) {
        queryPageCheck(loginLogDTO);
        LoginLog loginLog = convertPageQueryLoginLog(loginLogDTO);
        QueryWrapper<LoginLog> queryWrapper = new QueryWrapper<>(loginLog);
        buildPageQueryWrapper(loginLog, queryWrapper);
        Page<LoginLog> loginLogPage = iLoginLogRepository.page(page, queryWrapper);
        return assignment(convertLoginLogPageVO(loginLogPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     */
    private void queryPageCheck(LoginLogDTO loginLogDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     * @return LoginLog
     */
     private LoginLog convertPageQueryLoginLog(LoginLogDTO loginLogDTO){
        return LoginLogConvert.INSTANCE.convertLoginLog(loginLogDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLog: 登录日志
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(LoginLog loginLog, QueryWrapper<LoginLog> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogVOPage: 分页显示VO
     * @return Page<LoginLog>
     */
    private Page<LoginLogVO> assignment(Page<LoginLogVO> loginLogVOPage) {
        loginLogVOPage.getRecords().forEach(loginLogVO -> {
        });
        return loginLogVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<LoginLog>
     */
     private Page<LoginLogVO> convertLoginLogPageVO(Page<LoginLog> page){
        return LoginLogConvert.INSTANCE.convertLoginLogPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     * @return List<LoginLogVO>
     */
    @Override
    public List<LoginLogVO> list(LoginLogDTO loginLogDTO) {
        queryListCheck(loginLogDTO);
        LoginLog loginLog = convertLoginLogListQuery(loginLogDTO);
        QueryWrapper<LoginLog> queryWrapper = new QueryWrapper<>(loginLog);
        buildListQueryWrapper(loginLog, queryWrapper);
        List<LoginLog> loginLogList = iLoginLogRepository.list(queryWrapper);
        List<LoginLogVO> loginLogVOList = convertLoginLogVOList(loginLogList);
        return assignment(loginLogVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     */
     private void queryListCheck(LoginLogDTO loginLogDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param loginLogDTO: 登录日志DTO对象
    * @return Page<LoginLog>
    */
    private LoginLog convertLoginLogListQuery(LoginLogDTO loginLogDTO){
        return LoginLogConvert.INSTANCE.convertLoginLog(loginLogDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param loginLog: 登录日志
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(LoginLog loginLog, QueryWrapper<LoginLog> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogList: 登录日志列表
     * @return List<LoginLogVO>
     */
     public List<LoginLogVO> convertLoginLogVOList(List<LoginLog> loginLogList){
         return LoginLogConvert.INSTANCE.convertLoginLogVOList(loginLogList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param loginLogVOList: 登录日志VO列表
      * @return List<LoginLog>
      */
     private List<LoginLogVO> assignment(List<LoginLogVO> loginLogVOList) {
        loginLogVOList.forEach(loginLogVO -> {
        });
        return  loginLogVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return LoginLogVO
     */
    @Override
    public LoginLogVO getById(Long id) {
        LoginLog loginLog = iLoginLogRepository.getById(id);
        LoginLogVO loginLogVO = convertLoginLogVO(loginLog);
        return assignment(loginLogVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLog: 登录日志
     * @return LoginLogVO
     */
     private LoginLogVO convertLoginLogVO(LoginLog loginLog){
        return LoginLogConvert.INSTANCE.convertLoginLogVO(loginLog);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogVO: 登录日志VO
     * @return LoginLog
     */
    private LoginLogVO assignment(LoginLogVO loginLogVO) {
        return loginLogVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(LoginLogDTO loginLogDTO) {
        saveCheck(loginLogDTO);
        LoginLog loginLog = convertLoginLogSaveModel(loginLogDTO);
        return iLoginLogRepository.save(loginLog);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     */
    private void saveCheck(LoginLogDTO loginLogDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     * @return LoginLog
     */
     private LoginLog convertLoginLogSaveModel(LoginLogDTO loginLogDTO){
        return LoginLogConvert.INSTANCE.convertLoginLog(loginLogDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(LoginLogDTO loginLogDTO) {
        updateCheck(loginLogDTO);
        LoginLog loginLog = convertUpdateLoginLogModel(loginLogDTO);
        LambdaUpdateWrapper<LoginLog> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(loginLog,lambdaUpdateWrapper);
        return iLoginLogRepository.update(loginLog,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     */
     private void updateCheck(LoginLogDTO loginLogDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLog: 登录日志
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(LoginLog loginLog, LambdaUpdateWrapper<LoginLog> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(LoginLog::getId,loginLog.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param loginLogDTO: 登录日志DTO对象
     * @return LoginLog
     */
    public LoginLog convertUpdateLoginLogModel(LoginLogDTO loginLogDTO){
        if(ObjectUtils.isEmpty(loginLogDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return LoginLogConvert.INSTANCE.convertLoginLog(loginLogDTO);
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
        return iLoginLogRepository.removeById(id);
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
     * @param loginLogDTO 登录日志导出DTO
     * @param response http response
     */
     @Override
     public void exportData(LoginLogDTO loginLogDTO, HttpServletResponse response){

    }
}

