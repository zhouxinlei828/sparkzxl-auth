package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.IIdSegmentRepository;
import com.github.sparkzxl.auth.infrastructure.entity.IdSegment;
import com.github.sparkzxl.auth.infrastructure.mapper.IdSegmentMapper;
import com.github.sparkzxl.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * description: 序列生成仓储实现类
 *
 * @author charles.zhou
 * @date   2021-02-20 17:38:32
 */
@Repository
public class IdSegmentRepository implements IIdSegmentRepository {

    @Autowired
    private IdSegmentMapper idSegmentMapper;

    @Override
    public BigDecimal getIdSegment(String businessTag) {
        IdSegment idSegment = idSegmentMapper.selectOne(new LambdaQueryWrapper<IdSegment>().eq(IdSegment::getBusinessTag, businessTag));
        BigDecimal maxIdDecimal = new BigDecimal(idSegment.getMaxId().toString());
        BigDecimal stepDecimal = new BigDecimal(idSegment.getStep().toString());
        maxIdDecimal.add(stepDecimal);
        BigDecimal sumDecimal = maxIdDecimal.add(stepDecimal);
        Long maxId = sumDecimal.longValue();
        idSegment.setMaxId(maxId);
        idSegment.setUpdateTime(DateUtils.toLocalDateTime(new Date()));
        idSegmentMapper.updateById(idSegment);
        return sumDecimal;
    }
}
