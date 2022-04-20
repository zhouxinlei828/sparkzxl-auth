package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.OperateLog;
import com.github.sparkzxl.system.admin.domain.repository.IOperateLogRepository;
import com.github.sparkzxl.system.admin.application.service.IOperateLogService;
import com.github.sparkzxl.system.admin.domain.convert.OperateLogConvert;
import com.github.sparkzxl.system.admin.api.model.vo.OperateLogVO;
import com.github.sparkzxl.system.admin.api.model.dto.OperateLogDTO;
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
 * 系统日志 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OperateLogServiceImpl implements IOperateLogService {

    private final IOperateLogRepository iOperateLogRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param operateLogDTO: 系统日志DTO对象
    * @param page: 分页入参
    * @return Page<OperateLogVO>
    */
    @Override
    public Page<OperateLogVO> page(Page<OperateLog> page, OperateLogDTO operateLogDTO) {
        queryPageCheck(operateLogDTO);
        OperateLog operateLog = convertPageQueryOperateLog(operateLogDTO);
        QueryWrapper<OperateLog> queryWrapper = new QueryWrapper<>(operateLog);
        buildPageQueryWrapper(operateLog, queryWrapper);
        Page<OperateLog> operateLogPage = iOperateLogRepository.page(page, queryWrapper);
        return assignment(convertOperateLogPageVO(operateLogPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     */
    private void queryPageCheck(OperateLogDTO operateLogDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     * @return OperateLog
     */
     private OperateLog convertPageQueryOperateLog(OperateLogDTO operateLogDTO){
        return OperateLogConvert.INSTANCE.convertOperateLog(operateLogDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLog: 系统日志
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(OperateLog operateLog, QueryWrapper<OperateLog> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogVOPage: 分页显示VO
     * @return Page<OperateLog>
     */
    private Page<OperateLogVO> assignment(Page<OperateLogVO> operateLogVOPage) {
        operateLogVOPage.getRecords().forEach(operateLogVO -> {
        });
        return operateLogVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<OperateLog>
     */
     private Page<OperateLogVO> convertOperateLogPageVO(Page<OperateLog> page){
        return OperateLogConvert.INSTANCE.convertOperateLogPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     * @return List<OperateLogVO>
     */
    @Override
    public List<OperateLogVO> list(OperateLogDTO operateLogDTO) {
        queryListCheck(operateLogDTO);
        OperateLog operateLog = convertOperateLogListQuery(operateLogDTO);
        QueryWrapper<OperateLog> queryWrapper = new QueryWrapper<>(operateLog);
        buildListQueryWrapper(operateLog, queryWrapper);
        List<OperateLog> operateLogList = iOperateLogRepository.list(queryWrapper);
        List<OperateLogVO> operateLogVOList = convertOperateLogVOList(operateLogList);
        return assignment(operateLogVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     */
     private void queryListCheck(OperateLogDTO operateLogDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param operateLogDTO: 系统日志DTO对象
    * @return Page<OperateLog>
    */
    private OperateLog convertOperateLogListQuery(OperateLogDTO operateLogDTO){
        return OperateLogConvert.INSTANCE.convertOperateLog(operateLogDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param operateLog: 系统日志
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(OperateLog operateLog, QueryWrapper<OperateLog> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogList: 系统日志列表
     * @return List<OperateLogVO>
     */
     public List<OperateLogVO> convertOperateLogVOList(List<OperateLog> operateLogList){
         return OperateLogConvert.INSTANCE.convertOperateLogVOList(operateLogList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param operateLogVOList: 系统日志VO列表
      * @return List<OperateLog>
      */
     private List<OperateLogVO> assignment(List<OperateLogVO> operateLogVOList) {
        operateLogVOList.forEach(operateLogVO -> {
        });
        return  operateLogVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return OperateLogVO
     */
    @Override
    public OperateLogVO getById(Long id) {
        OperateLog operateLog = iOperateLogRepository.getById(id);
        OperateLogVO operateLogVO = convertOperateLogVO(operateLog);
        return assignment(operateLogVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLog: 系统日志
     * @return OperateLogVO
     */
     private OperateLogVO convertOperateLogVO(OperateLog operateLog){
        return OperateLogConvert.INSTANCE.convertOperateLogVO(operateLog);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogVO: 系统日志VO
     * @return OperateLog
     */
    private OperateLogVO assignment(OperateLogVO operateLogVO) {
        return operateLogVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(OperateLogDTO operateLogDTO) {
        saveCheck(operateLogDTO);
        OperateLog operateLog = convertOperateLogSaveModel(operateLogDTO);
        return iOperateLogRepository.save(operateLog);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     */
    private void saveCheck(OperateLogDTO operateLogDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     * @return OperateLog
     */
     private OperateLog convertOperateLogSaveModel(OperateLogDTO operateLogDTO){
        return OperateLogConvert.INSTANCE.convertOperateLog(operateLogDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(OperateLogDTO operateLogDTO) {
        updateCheck(operateLogDTO);
        OperateLog operateLog = convertUpdateOperateLogModel(operateLogDTO);
        LambdaUpdateWrapper<OperateLog> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(operateLog,lambdaUpdateWrapper);
        return iOperateLogRepository.update(operateLog,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     */
     private void updateCheck(OperateLogDTO operateLogDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLog: 系统日志
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(OperateLog operateLog, LambdaUpdateWrapper<OperateLog> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(OperateLog::getId,operateLog.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param operateLogDTO: 系统日志DTO对象
     * @return OperateLog
     */
    public OperateLog convertUpdateOperateLogModel(OperateLogDTO operateLogDTO){
        if(ObjectUtils.isEmpty(operateLogDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return OperateLogConvert.INSTANCE.convertOperateLog(operateLogDTO);
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
        return iOperateLogRepository.removeById(id);
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
     * @param operateLogDTO 系统日志导出DTO
     * @param response http response
     */
     @Override
     public void exportData(OperateLogDTO operateLogDTO, HttpServletResponse response){

    }
}

