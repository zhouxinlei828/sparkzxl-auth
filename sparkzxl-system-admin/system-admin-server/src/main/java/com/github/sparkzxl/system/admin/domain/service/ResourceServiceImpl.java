package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Resource;
import com.github.sparkzxl.system.admin.domain.repository.IResourceRepository;
import com.github.sparkzxl.system.admin.application.service.IResourceService;
import com.github.sparkzxl.system.admin.domain.convert.ResourceConvert;
import com.github.sparkzxl.system.admin.api.model.vo.ResourceVO;
import com.github.sparkzxl.system.admin.api.model.dto.ResourceDTO;
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
 * 资源信息 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements IResourceService {

    private final IResourceRepository iResourceRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param resourceDTO: 资源信息DTO对象
    * @param page: 分页入参
    * @return Page<ResourceVO>
    */
    @Override
    public Page<ResourceVO> page(Page<Resource> page, ResourceDTO resourceDTO) {
        queryPageCheck(resourceDTO);
        Resource resource = convertPageQueryResource(resourceDTO);
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>(resource);
        buildPageQueryWrapper(resource, queryWrapper);
        Page<Resource> resourcePage = iResourceRepository.page(page, queryWrapper);
        return assignment(convertResourcePageVO(resourcePage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     */
    private void queryPageCheck(ResourceDTO resourceDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     * @return Resource
     */
     private Resource convertPageQueryResource(ResourceDTO resourceDTO){
        return ResourceConvert.INSTANCE.convertResource(resourceDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resource: 资源信息
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Resource resource, QueryWrapper<Resource> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceVOPage: 分页显示VO
     * @return Page<Resource>
     */
    private Page<ResourceVO> assignment(Page<ResourceVO> resourceVOPage) {
        resourceVOPage.getRecords().forEach(resourceVO -> {
        });
        return resourceVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Resource>
     */
     private Page<ResourceVO> convertResourcePageVO(Page<Resource> page){
        return ResourceConvert.INSTANCE.convertResourcePageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     * @return List<ResourceVO>
     */
    @Override
    public List<ResourceVO> list(ResourceDTO resourceDTO) {
        queryListCheck(resourceDTO);
        Resource resource = convertResourceListQuery(resourceDTO);
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>(resource);
        buildListQueryWrapper(resource, queryWrapper);
        List<Resource> resourceList = iResourceRepository.list(queryWrapper);
        List<ResourceVO> resourceVOList = convertResourceVOList(resourceList);
        return assignment(resourceVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     */
     private void queryListCheck(ResourceDTO resourceDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param resourceDTO: 资源信息DTO对象
    * @return Page<Resource>
    */
    private Resource convertResourceListQuery(ResourceDTO resourceDTO){
        return ResourceConvert.INSTANCE.convertResource(resourceDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param resource: 资源信息
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Resource resource, QueryWrapper<Resource> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceList: 资源信息列表
     * @return List<ResourceVO>
     */
     public List<ResourceVO> convertResourceVOList(List<Resource> resourceList){
         return ResourceConvert.INSTANCE.convertResourceVOList(resourceList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param resourceVOList: 资源信息VO列表
      * @return List<Resource>
      */
     private List<ResourceVO> assignment(List<ResourceVO> resourceVOList) {
        resourceVOList.forEach(resourceVO -> {
        });
        return  resourceVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return ResourceVO
     */
    @Override
    public ResourceVO getById(Long id) {
        Resource resource = iResourceRepository.getById(id);
        ResourceVO resourceVO = convertResourceVO(resource);
        return assignment(resourceVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resource: 资源信息
     * @return ResourceVO
     */
     private ResourceVO convertResourceVO(Resource resource){
        return ResourceConvert.INSTANCE.convertResourceVO(resource);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceVO: 资源信息VO
     * @return Resource
     */
    private ResourceVO assignment(ResourceVO resourceVO) {
        return resourceVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(ResourceDTO resourceDTO) {
        saveCheck(resourceDTO);
        Resource resource = convertResourceSaveModel(resourceDTO);
        return iResourceRepository.save(resource);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     */
    private void saveCheck(ResourceDTO resourceDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     * @return Resource
     */
     private Resource convertResourceSaveModel(ResourceDTO resourceDTO){
        return ResourceConvert.INSTANCE.convertResource(resourceDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(ResourceDTO resourceDTO) {
        updateCheck(resourceDTO);
        Resource resource = convertUpdateResourceModel(resourceDTO);
        LambdaUpdateWrapper<Resource> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(resource,lambdaUpdateWrapper);
        return iResourceRepository.update(resource,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     */
     private void updateCheck(ResourceDTO resourceDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resource: 资源信息
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Resource resource, LambdaUpdateWrapper<Resource> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Resource::getId,resource.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param resourceDTO: 资源信息DTO对象
     * @return Resource
     */
    public Resource convertUpdateResourceModel(ResourceDTO resourceDTO){
        if(ObjectUtils.isEmpty(resourceDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return ResourceConvert.INSTANCE.convertResource(resourceDTO);
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
        return iResourceRepository.removeById(id);
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
     * @param resourceDTO 资源信息导出DTO
     * @param response http response
     */
     @Override
     public void exportData(ResourceDTO resourceDTO, HttpServletResponse response){

    }
}

