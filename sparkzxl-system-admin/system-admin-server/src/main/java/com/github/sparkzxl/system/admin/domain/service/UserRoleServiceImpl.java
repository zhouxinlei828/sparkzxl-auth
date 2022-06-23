package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.UserRole;
import com.github.sparkzxl.system.admin.domain.repository.IUserRoleRepository;
import com.github.sparkzxl.system.admin.application.service.IUserRoleService;
import com.github.sparkzxl.system.admin.domain.convert.UserRoleConvert;
import com.github.sparkzxl.system.admin.api.model.vo.UserRoleVO;
import com.github.sparkzxl.system.admin.api.model.dto.UserRoleDTO;
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
 * 角色分配	账号角色绑定 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {

    private final IUserRoleRepository iUserRoleRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
    * @param page: 分页入参
    * @return Page<UserRoleVO>
    */
    @Override
    public Page<UserRoleVO> page(Page<UserRole> page, UserRoleDTO userRoleDTO) {
        queryPageCheck(userRoleDTO);
        UserRole userRole = convertPageQueryUserRole(userRoleDTO);
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>(userRole);
        buildPageQueryWrapper(userRole, queryWrapper);
        Page<UserRole> userRolePage = iUserRoleRepository.page(page, queryWrapper);
        return assignment(convertUserRolePageVO(userRolePage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     */
    private void queryPageCheck(UserRoleDTO userRoleDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     * @return UserRole
     */
     private UserRole convertPageQueryUserRole(UserRoleDTO userRoleDTO){
        return UserRoleConvert.INSTANCE.convertUserRole(userRoleDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRole: 角色分配	账号角色绑定
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(UserRole userRole, QueryWrapper<UserRole> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleVOPage: 分页显示VO
     * @return Page<UserRole>
     */
    private Page<UserRoleVO> assignment(Page<UserRoleVO> userRoleVOPage) {
        userRoleVOPage.getRecords().forEach(userRoleVO -> {
        });
        return userRoleVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<UserRole>
     */
     private Page<UserRoleVO> convertUserRolePageVO(Page<UserRole> page){
        return UserRoleConvert.INSTANCE.convertUserRolePageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     * @return List<UserRoleVO>
     */
    @Override
    public List<UserRoleVO> list(UserRoleDTO userRoleDTO) {
        queryListCheck(userRoleDTO);
        UserRole userRole = convertUserRoleListQuery(userRoleDTO);
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>(userRole);
        buildListQueryWrapper(userRole, queryWrapper);
        List<UserRole> userRoleList = iUserRoleRepository.list(queryWrapper);
        List<UserRoleVO> userRoleVOList = convertUserRoleVOList(userRoleList);
        return assignment(userRoleVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     */
     private void queryListCheck(UserRoleDTO userRoleDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
    * @return Page<UserRole>
    */
    private UserRole convertUserRoleListQuery(UserRoleDTO userRoleDTO){
        return UserRoleConvert.INSTANCE.convertUserRole(userRoleDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param userRole: 角色分配	账号角色绑定
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(UserRole userRole, QueryWrapper<UserRole> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleList: 角色分配	账号角色绑定列表
     * @return List<UserRoleVO>
     */
     public List<UserRoleVO> convertUserRoleVOList(List<UserRole> userRoleList){
         return UserRoleConvert.INSTANCE.convertUserRoleVOList(userRoleList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param userRoleVOList: 角色分配	账号角色绑定VO列表
      * @return List<UserRole>
      */
     private List<UserRoleVO> assignment(List<UserRoleVO> userRoleVOList) {
        userRoleVOList.forEach(userRoleVO -> {
        });
        return  userRoleVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return UserRoleVO
     */
    @Override
    public UserRoleVO getById(Long id) {
        UserRole userRole = iUserRoleRepository.getById(id);
        UserRoleVO userRoleVO = convertUserRoleVO(userRole);
        return assignment(userRoleVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRole: 角色分配	账号角色绑定
     * @return UserRoleVO
     */
     private UserRoleVO convertUserRoleVO(UserRole userRole){
        return UserRoleConvert.INSTANCE.convertUserRoleVO(userRole);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleVO: 角色分配	账号角色绑定VO
     * @return UserRole
     */
    private UserRoleVO assignment(UserRoleVO userRoleVO) {
        return userRoleVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(UserRoleDTO userRoleDTO) {
        saveCheck(userRoleDTO);
        UserRole userRole = convertUserRoleSaveModel(userRoleDTO);
        return iUserRoleRepository.save(userRole);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     */
    private void saveCheck(UserRoleDTO userRoleDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     * @return UserRole
     */
     private UserRole convertUserRoleSaveModel(UserRoleDTO userRoleDTO){
        return UserRoleConvert.INSTANCE.convertUserRole(userRoleDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(UserRoleDTO userRoleDTO) {
        updateCheck(userRoleDTO);
        UserRole userRole = convertUpdateUserRoleModel(userRoleDTO);
        LambdaUpdateWrapper<UserRole> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(userRole,lambdaUpdateWrapper);
        return iUserRoleRepository.update(userRole,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     */
     private void updateCheck(UserRoleDTO userRoleDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRole: 角色分配	账号角色绑定
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(UserRole userRole, LambdaUpdateWrapper<UserRole> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(UserRole::getId,userRole.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userRoleDTO: 角色分配	账号角色绑定DTO对象
     * @return UserRole
     */
    public UserRole convertUpdateUserRoleModel(UserRoleDTO userRoleDTO){
        if(ObjectUtils.isEmpty(userRoleDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return UserRoleConvert.INSTANCE.convertUserRole(userRoleDTO);
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
        return iUserRoleRepository.removeById(id);
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
     * @param userRoleDTO 角色分配	账号角色绑定导出DTO
     * @param response http response
     */
     @Override
     public void exportData(UserRoleDTO userRoleDTO, HttpServletResponse response){

    }
}

