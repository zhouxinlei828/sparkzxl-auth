package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Organization;
import com.github.sparkzxl.system.admin.domain.repository.IOrganizationRepository;
import com.github.sparkzxl.system.admin.application.service.IOrganizationService;
import com.github.sparkzxl.system.admin.domain.convert.OrganizationConvert;
import com.github.sparkzxl.system.admin.api.model.vo.OrganizationVO;
import com.github.sparkzxl.system.admin.api.model.dto.OrganizationDTO;
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
 * 组织 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements IOrganizationService {

    private final IOrganizationRepository iOrganizationRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param organizationDTO: 组织DTO对象
    * @param page: 分页入参
    * @return Page<OrganizationVO>
    */
    @Override
    public Page<OrganizationVO> page(Page<Organization> page, OrganizationDTO organizationDTO) {
        queryPageCheck(organizationDTO);
        Organization organization = convertPageQueryOrganization(organizationDTO);
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>(organization);
        buildPageQueryWrapper(organization, queryWrapper);
        Page<Organization> organizationPage = iOrganizationRepository.page(page, queryWrapper);
        return assignment(convertOrganizationPageVO(organizationPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     */
    private void queryPageCheck(OrganizationDTO organizationDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     * @return Organization
     */
     private Organization convertPageQueryOrganization(OrganizationDTO organizationDTO){
        return OrganizationConvert.INSTANCE.convertOrganization(organizationDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organization: 组织
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Organization organization, QueryWrapper<Organization> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationVOPage: 分页显示VO
     * @return Page<Organization>
     */
    private Page<OrganizationVO> assignment(Page<OrganizationVO> organizationVOPage) {
        organizationVOPage.getRecords().forEach(organizationVO -> {
        });
        return organizationVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Organization>
     */
     private Page<OrganizationVO> convertOrganizationPageVO(Page<Organization> page){
        return OrganizationConvert.INSTANCE.convertOrganizationPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     * @return List<OrganizationVO>
     */
    @Override
    public List<OrganizationVO> list(OrganizationDTO organizationDTO) {
        queryListCheck(organizationDTO);
        Organization organization = convertOrganizationListQuery(organizationDTO);
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>(organization);
        buildListQueryWrapper(organization, queryWrapper);
        List<Organization> organizationList = iOrganizationRepository.list(queryWrapper);
        List<OrganizationVO> organizationVOList = convertOrganizationVOList(organizationList);
        return assignment(organizationVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     */
     private void queryListCheck(OrganizationDTO organizationDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param organizationDTO: 组织DTO对象
    * @return Page<Organization>
    */
    private Organization convertOrganizationListQuery(OrganizationDTO organizationDTO){
        return OrganizationConvert.INSTANCE.convertOrganization(organizationDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param organization: 组织
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Organization organization, QueryWrapper<Organization> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationList: 组织列表
     * @return List<OrganizationVO>
     */
     public List<OrganizationVO> convertOrganizationVOList(List<Organization> organizationList){
         return OrganizationConvert.INSTANCE.convertOrganizationVOList(organizationList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param organizationVOList: 组织VO列表
      * @return List<Organization>
      */
     private List<OrganizationVO> assignment(List<OrganizationVO> organizationVOList) {
        organizationVOList.forEach(organizationVO -> {
        });
        return  organizationVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return OrganizationVO
     */
    @Override
    public OrganizationVO getById(Long id) {
        Organization organization = iOrganizationRepository.getById(id);
        OrganizationVO organizationVO = convertOrganizationVO(organization);
        return assignment(organizationVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organization: 组织
     * @return OrganizationVO
     */
     private OrganizationVO convertOrganizationVO(Organization organization){
        return OrganizationConvert.INSTANCE.convertOrganizationVO(organization);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationVO: 组织VO
     * @return Organization
     */
    private OrganizationVO assignment(OrganizationVO organizationVO) {
        return organizationVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(OrganizationDTO organizationDTO) {
        saveCheck(organizationDTO);
        Organization organization = convertOrganizationSaveModel(organizationDTO);
        return iOrganizationRepository.save(organization);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     */
    private void saveCheck(OrganizationDTO organizationDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     * @return Organization
     */
     private Organization convertOrganizationSaveModel(OrganizationDTO organizationDTO){
        return OrganizationConvert.INSTANCE.convertOrganization(organizationDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(OrganizationDTO organizationDTO) {
        updateCheck(organizationDTO);
        Organization organization = convertUpdateOrganizationModel(organizationDTO);
        LambdaUpdateWrapper<Organization> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(organization,lambdaUpdateWrapper);
        return iOrganizationRepository.update(organization,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     */
     private void updateCheck(OrganizationDTO organizationDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organization: 组织
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Organization organization, LambdaUpdateWrapper<Organization> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Organization::getId,organization.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param organizationDTO: 组织DTO对象
     * @return Organization
     */
    public Organization convertUpdateOrganizationModel(OrganizationDTO organizationDTO){
        if(ObjectUtils.isEmpty(organizationDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return OrganizationConvert.INSTANCE.convertOrganization(organizationDTO);
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
        return iOrganizationRepository.removeById(id);
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
     * @param organizationDTO 组织导出DTO
     * @param response http response
     */
     @Override
     public void exportData(OrganizationDTO organizationDTO, HttpServletResponse response){

    }
}

