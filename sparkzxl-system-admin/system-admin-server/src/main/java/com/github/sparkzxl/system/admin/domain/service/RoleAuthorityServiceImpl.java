package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.system.admin.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.system.admin.application.service.IRoleAuthorityService;
import com.github.sparkzxl.system.admin.domain.convert.RoleAuthorityConvert;
import com.github.sparkzxl.system.admin.api.model.vo.RoleAuthorityVO;
import com.github.sparkzxl.system.admin.api.model.dto.RoleAuthorityDTO;
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
 * 角色的资源 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleAuthorityServiceImpl implements IRoleAuthorityService {

    private final IRoleAuthorityRepository iRoleAuthorityRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param roleAuthorityDTO: 角色的资源DTO对象
    * @param page: 分页入参
    * @return Page<RoleAuthorityVO>
    */
    @Override
    public Page<RoleAuthorityVO> page(Page<RoleAuthority> page, RoleAuthorityDTO roleAuthorityDTO) {
        queryPageCheck(roleAuthorityDTO);
        RoleAuthority roleAuthority = convertPageQueryRoleAuthority(roleAuthorityDTO);
        QueryWrapper<RoleAuthority> queryWrapper = new QueryWrapper<>(roleAuthority);
        buildPageQueryWrapper(roleAuthority, queryWrapper);
        Page<RoleAuthority> roleAuthorityPage = iRoleAuthorityRepository.page(page, queryWrapper);
        return assignment(convertRoleAuthorityPageVO(roleAuthorityPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     */
    private void queryPageCheck(RoleAuthorityDTO roleAuthorityDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     * @return RoleAuthority
     */
     private RoleAuthority convertPageQueryRoleAuthority(RoleAuthorityDTO roleAuthorityDTO){
        return RoleAuthorityConvert.INSTANCE.convertRoleAuthority(roleAuthorityDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthority: 角色的资源
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(RoleAuthority roleAuthority, QueryWrapper<RoleAuthority> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityVOPage: 分页显示VO
     * @return Page<RoleAuthority>
     */
    private Page<RoleAuthorityVO> assignment(Page<RoleAuthorityVO> roleAuthorityVOPage) {
        roleAuthorityVOPage.getRecords().forEach(roleAuthorityVO -> {
        });
        return roleAuthorityVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<RoleAuthority>
     */
     private Page<RoleAuthorityVO> convertRoleAuthorityPageVO(Page<RoleAuthority> page){
        return RoleAuthorityConvert.INSTANCE.convertRoleAuthorityPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     * @return List<RoleAuthorityVO>
     */
    @Override
    public List<RoleAuthorityVO> list(RoleAuthorityDTO roleAuthorityDTO) {
        queryListCheck(roleAuthorityDTO);
        RoleAuthority roleAuthority = convertRoleAuthorityListQuery(roleAuthorityDTO);
        QueryWrapper<RoleAuthority> queryWrapper = new QueryWrapper<>(roleAuthority);
        buildListQueryWrapper(roleAuthority, queryWrapper);
        List<RoleAuthority> roleAuthorityList = iRoleAuthorityRepository.list(queryWrapper);
        List<RoleAuthorityVO> roleAuthorityVOList = convertRoleAuthorityVOList(roleAuthorityList);
        return assignment(roleAuthorityVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     */
     private void queryListCheck(RoleAuthorityDTO roleAuthorityDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param roleAuthorityDTO: 角色的资源DTO对象
    * @return Page<RoleAuthority>
    */
    private RoleAuthority convertRoleAuthorityListQuery(RoleAuthorityDTO roleAuthorityDTO){
        return RoleAuthorityConvert.INSTANCE.convertRoleAuthority(roleAuthorityDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param roleAuthority: 角色的资源
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(RoleAuthority roleAuthority, QueryWrapper<RoleAuthority> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityList: 角色的资源列表
     * @return List<RoleAuthorityVO>
     */
     public List<RoleAuthorityVO> convertRoleAuthorityVOList(List<RoleAuthority> roleAuthorityList){
         return RoleAuthorityConvert.INSTANCE.convertRoleAuthorityVOList(roleAuthorityList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param roleAuthorityVOList: 角色的资源VO列表
      * @return List<RoleAuthority>
      */
     private List<RoleAuthorityVO> assignment(List<RoleAuthorityVO> roleAuthorityVOList) {
        roleAuthorityVOList.forEach(roleAuthorityVO -> {
        });
        return  roleAuthorityVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return RoleAuthorityVO
     */
    @Override
    public RoleAuthorityVO getById(Long id) {
        RoleAuthority roleAuthority = iRoleAuthorityRepository.getById(id);
        RoleAuthorityVO roleAuthorityVO = convertRoleAuthorityVO(roleAuthority);
        return assignment(roleAuthorityVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthority: 角色的资源
     * @return RoleAuthorityVO
     */
     private RoleAuthorityVO convertRoleAuthorityVO(RoleAuthority roleAuthority){
        return RoleAuthorityConvert.INSTANCE.convertRoleAuthorityVO(roleAuthority);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityVO: 角色的资源VO
     * @return RoleAuthority
     */
    private RoleAuthorityVO assignment(RoleAuthorityVO roleAuthorityVO) {
        return roleAuthorityVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(RoleAuthorityDTO roleAuthorityDTO) {
        saveCheck(roleAuthorityDTO);
        RoleAuthority roleAuthority = convertRoleAuthoritySaveModel(roleAuthorityDTO);
        return iRoleAuthorityRepository.save(roleAuthority);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     */
    private void saveCheck(RoleAuthorityDTO roleAuthorityDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     * @return RoleAuthority
     */
     private RoleAuthority convertRoleAuthoritySaveModel(RoleAuthorityDTO roleAuthorityDTO){
        return RoleAuthorityConvert.INSTANCE.convertRoleAuthority(roleAuthorityDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(RoleAuthorityDTO roleAuthorityDTO) {
        updateCheck(roleAuthorityDTO);
        RoleAuthority roleAuthority = convertUpdateRoleAuthorityModel(roleAuthorityDTO);
        LambdaUpdateWrapper<RoleAuthority> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(roleAuthority,lambdaUpdateWrapper);
        return iRoleAuthorityRepository.update(roleAuthority,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     */
     private void updateCheck(RoleAuthorityDTO roleAuthorityDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthority: 角色的资源
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(RoleAuthority roleAuthority, LambdaUpdateWrapper<RoleAuthority> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(RoleAuthority::getId,roleAuthority.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param roleAuthorityDTO: 角色的资源DTO对象
     * @return RoleAuthority
     */
    public RoleAuthority convertUpdateRoleAuthorityModel(RoleAuthorityDTO roleAuthorityDTO){
        if(ObjectUtils.isEmpty(roleAuthorityDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return RoleAuthorityConvert.INSTANCE.convertRoleAuthority(roleAuthorityDTO);
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
        return iRoleAuthorityRepository.removeById(id);
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
     * @param roleAuthorityDTO 角色的资源导出DTO
     * @param response http response
     */
     @Override
     public void exportData(RoleAuthorityDTO roleAuthorityDTO, HttpServletResponse response){

    }
}

