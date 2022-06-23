package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Role;
import com.github.sparkzxl.system.admin.domain.repository.IRoleRepository;
import com.github.sparkzxl.system.admin.application.service.IRoleService;
import com.github.sparkzxl.system.admin.domain.convert.RoleConvert;
import com.github.sparkzxl.system.admin.api.model.vo.RoleVO;
import com.github.sparkzxl.system.admin.api.model.dto.RoleDTO;
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
 * 角色信息 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository iRoleRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param roleDTO: 角色信息DTO对象
    * @param page: 分页入参
    * @return Page<RoleVO>
    */
    @Override
    public Page<RoleVO> page(Page<Role> page, RoleDTO roleDTO) {
        queryPageCheck(roleDTO);
        Role role = convertPageQueryRole(roleDTO);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>(role);
        buildPageQueryWrapper(role, queryWrapper);
        Page<Role> rolePage = iRoleRepository.page(page, queryWrapper);
        return assignment(convertRolePageVO(rolePage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     */
    private void queryPageCheck(RoleDTO roleDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     * @return Role
     */
     private Role convertPageQueryRole(RoleDTO roleDTO){
        return RoleConvert.INSTANCE.convertRole(roleDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param role: 角色信息
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Role role, QueryWrapper<Role> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleVOPage: 分页显示VO
     * @return Page<Role>
     */
    private Page<RoleVO> assignment(Page<RoleVO> roleVOPage) {
        roleVOPage.getRecords().forEach(roleVO -> {
        });
        return roleVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Role>
     */
     private Page<RoleVO> convertRolePageVO(Page<Role> page){
        return RoleConvert.INSTANCE.convertRolePageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     * @return List<RoleVO>
     */
    @Override
    public List<RoleVO> list(RoleDTO roleDTO) {
        queryListCheck(roleDTO);
        Role role = convertRoleListQuery(roleDTO);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>(role);
        buildListQueryWrapper(role, queryWrapper);
        List<Role> roleList = iRoleRepository.list(queryWrapper);
        List<RoleVO> roleVOList = convertRoleVOList(roleList);
        return assignment(roleVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     */
     private void queryListCheck(RoleDTO roleDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param roleDTO: 角色信息DTO对象
    * @return Page<Role>
    */
    private Role convertRoleListQuery(RoleDTO roleDTO){
        return RoleConvert.INSTANCE.convertRole(roleDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param role: 角色信息
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Role role, QueryWrapper<Role> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleList: 角色信息列表
     * @return List<RoleVO>
     */
     public List<RoleVO> convertRoleVOList(List<Role> roleList){
         return RoleConvert.INSTANCE.convertRoleVOList(roleList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param roleVOList: 角色信息VO列表
      * @return List<Role>
      */
     private List<RoleVO> assignment(List<RoleVO> roleVOList) {
        roleVOList.forEach(roleVO -> {
        });
        return  roleVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return RoleVO
     */
    @Override
    public RoleVO getById(Long id) {
        Role role = iRoleRepository.getById(id);
        RoleVO roleVO = convertRoleVO(role);
        return assignment(roleVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param role: 角色信息
     * @return RoleVO
     */
     private RoleVO convertRoleVO(Role role){
        return RoleConvert.INSTANCE.convertRoleVO(role);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleVO: 角色信息VO
     * @return Role
     */
    private RoleVO assignment(RoleVO roleVO) {
        return roleVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(RoleDTO roleDTO) {
        saveCheck(roleDTO);
        Role role = convertRoleSaveModel(roleDTO);
        return iRoleRepository.save(role);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     */
    private void saveCheck(RoleDTO roleDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     * @return Role
     */
     private Role convertRoleSaveModel(RoleDTO roleDTO){
        return RoleConvert.INSTANCE.convertRole(roleDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(RoleDTO roleDTO) {
        updateCheck(roleDTO);
        Role role = convertUpdateRoleModel(roleDTO);
        LambdaUpdateWrapper<Role> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(role,lambdaUpdateWrapper);
        return iRoleRepository.update(role,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     */
     private void updateCheck(RoleDTO roleDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param role: 角色信息
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Role role, LambdaUpdateWrapper<Role> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Role::getId,role.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleDTO: 角色信息DTO对象
     * @return Role
     */
    public Role convertUpdateRoleModel(RoleDTO roleDTO){
        if(ObjectUtils.isEmpty(roleDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return RoleConvert.INSTANCE.convertRole(roleDTO);
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
        return iRoleRepository.removeById(id);
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
     * @param roleDTO 角色信息导出DTO
     * @param response http response
     */
     @Override
     public void exportData(RoleDTO roleDTO, HttpServletResponse response){

    }
}

