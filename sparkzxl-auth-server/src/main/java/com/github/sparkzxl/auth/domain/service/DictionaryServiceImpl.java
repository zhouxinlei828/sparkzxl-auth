package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IDictionaryService;
import com.github.sparkzxl.auth.infrastructure.entity.Dictionary;
import com.github.sparkzxl.auth.infrastructure.mapper.DictionaryMapper;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * description: 字典类型 服务实现类
 *
 * @author charles.zhou
 * @since 2020-07-28 19:44:24
 */
@Service
public class DictionaryServiceImpl extends SuperServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

}
