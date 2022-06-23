package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.Menu;
import com.github.sparkzxl.system.admin.domain.repository.IMenuRepository;
import com.github.sparkzxl.system.admin.application.service.IMenuService;
import com.github.sparkzxl.system.admin.domain.convert.MenuConvert;
import com.github.sparkzxl.system.admin.api.model.vo.MenuVO;
import com.github.sparkzxl.system.admin.api.model.dto.MenuDTO;
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
 * 菜单 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements IMenuService {

    private final IMenuRepository iMenuRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param menuDTO: 菜单DTO对象
    * @param page: 分页入参
    * @return Page<MenuVO>
    */
    @Override
    public Page<MenuVO> page(Page<Menu> page, MenuDTO menuDTO) {
        queryPageCheck(menuDTO);
        Menu menu = convertPageQueryMenu(menuDTO);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>(menu);
        buildPageQueryWrapper(menu, queryWrapper);
        Page<Menu> menuPage = iMenuRepository.page(page, queryWrapper);
        return assignment(convertMenuPageVO(menuPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     */
    private void queryPageCheck(MenuDTO menuDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     * @return Menu
     */
     private Menu convertPageQueryMenu(MenuDTO menuDTO){
        return MenuConvert.INSTANCE.convertMenu(menuDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menu: 菜单
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(Menu menu, QueryWrapper<Menu> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuVOPage: 分页显示VO
     * @return Page<Menu>
     */
    private Page<MenuVO> assignment(Page<MenuVO> menuVOPage) {
        menuVOPage.getRecords().forEach(menuVO -> {
        });
        return menuVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<Menu>
     */
     private Page<MenuVO> convertMenuPageVO(Page<Menu> page){
        return MenuConvert.INSTANCE.convertMenuPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     * @return List<MenuVO>
     */
    @Override
    public List<MenuVO> list(MenuDTO menuDTO) {
        queryListCheck(menuDTO);
        Menu menu = convertMenuListQuery(menuDTO);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>(menu);
        buildListQueryWrapper(menu, queryWrapper);
        List<Menu> menuList = iMenuRepository.list(queryWrapper);
        List<MenuVO> menuVOList = convertMenuVOList(menuList);
        return assignment(menuVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     */
     private void queryListCheck(MenuDTO menuDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param menuDTO: 菜单DTO对象
    * @return Page<Menu>
    */
    private Menu convertMenuListQuery(MenuDTO menuDTO){
        return MenuConvert.INSTANCE.convertMenu(menuDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param menu: 菜单
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(Menu menu, QueryWrapper<Menu> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuList: 菜单列表
     * @return List<MenuVO>
     */
     public List<MenuVO> convertMenuVOList(List<Menu> menuList){
         return MenuConvert.INSTANCE.convertMenuVOList(menuList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param menuVOList: 菜单VO列表
      * @return List<Menu>
      */
     private List<MenuVO> assignment(List<MenuVO> menuVOList) {
        menuVOList.forEach(menuVO -> {
        });
        return  menuVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return MenuVO
     */
    @Override
    public MenuVO getById(Long id) {
        Menu menu = iMenuRepository.getById(id);
        MenuVO menuVO = convertMenuVO(menu);
        return assignment(menuVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menu: 菜单
     * @return MenuVO
     */
     private MenuVO convertMenuVO(Menu menu){
        return MenuConvert.INSTANCE.convertMenuVO(menu);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuVO: 菜单VO
     * @return Menu
     */
    private MenuVO assignment(MenuVO menuVO) {
        return menuVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(MenuDTO menuDTO) {
        saveCheck(menuDTO);
        Menu menu = convertMenuSaveModel(menuDTO);
        return iMenuRepository.save(menu);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     */
    private void saveCheck(MenuDTO menuDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     * @return Menu
     */
     private Menu convertMenuSaveModel(MenuDTO menuDTO){
        return MenuConvert.INSTANCE.convertMenu(menuDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(MenuDTO menuDTO) {
        updateCheck(menuDTO);
        Menu menu = convertUpdateMenuModel(menuDTO);
        LambdaUpdateWrapper<Menu> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(menu,lambdaUpdateWrapper);
        return iMenuRepository.update(menu,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     */
     private void updateCheck(MenuDTO menuDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menu: 菜单
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(Menu menu, LambdaUpdateWrapper<Menu> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(Menu::getId,menu.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param menuDTO: 菜单DTO对象
     * @return Menu
     */
    public Menu convertUpdateMenuModel(MenuDTO menuDTO){
        if(ObjectUtils.isEmpty(menuDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return MenuConvert.INSTANCE.convertMenu(menuDTO);
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
        return iMenuRepository.removeById(id);
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
     * @param menuDTO 菜单导出DTO
     * @param response http response
     */
     @Override
     public void exportData(MenuDTO menuDTO, HttpServletResponse response){

    }
}

