package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Menu;
import com.github.sparkzxl.system.admin.infrastructure.mapper.MenuMapper;
import com.github.sparkzxl.system.admin.domain.repository.IMenuRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 菜单 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class MenuRepository extends ServiceImpl<MenuMapper, Menu> implements IMenuRepository {

}
