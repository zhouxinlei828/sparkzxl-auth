package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Menu;
import com.github.sparkzxl.system.admin.api.model.dto.MenuDTO;
import com.github.sparkzxl.system.admin.api.model.vo.MenuVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 菜单 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface MenuConvert {

    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    /**
     * menuDTO转换为Menu
     *
     * @param menuDTO 菜单DTO对象
     * @return Menu
     */
    Menu convertMenu(MenuDTO menuDTO);

    /**
     * Menu转换为MenuVO
     *
     * @param menu 菜单DTO对象
     * @return MenuVO
     */
    MenuVO convertMenuVO(Menu menu);

    /**
     * menu列表转换为MenuVO列表
     *
     * @param menuList 菜单列表
     * @return List<MenuVO>
     */
    List<MenuVO> convertMenuVOList(List<Menu> menuList);

    /**
     * 菜单分页对象转换为MenuVO分页对象
     *
     * @param menuPage 菜单分页对象
     * @return Page<MenuVO>
     */
    Page<MenuVO> convertMenuPageVO(Page<Menu> menuPage);
}
