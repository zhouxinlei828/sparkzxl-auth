package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Dictionary;
import com.github.sparkzxl.system.admin.infrastructure.mapper.DictionaryMapper;
import com.github.sparkzxl.system.admin.domain.repository.IDictionaryRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 字典类型 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class DictionaryRepository extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryRepository {

}
