package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.ISegmentIdRepository;
import com.github.sparkzxl.auth.infrastructure.entity.SegmentId;
import com.github.sparkzxl.auth.infrastructure.mapper.SegmentIdMapper;
import com.github.sparkzxl.core.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * description: 序列生成仓储实现类
 *
 * @author charles.zhou
 * @since 2021-02-20 17:38:32
 */
@Repository
public class SegmentIdRepository implements ISegmentIdRepository {

    @Autowired
    private SegmentIdMapper segmentIdMapper;

    @Override
    public BigDecimal getSegmentId(String businessTag) {
        SegmentId segmentId = segmentIdMapper.selectOne(new LambdaQueryWrapper<SegmentId>().eq(SegmentId::getBusinessTag, businessTag));
        BigDecimal maxIdDecimal = new BigDecimal(segmentId.getMaxId().toString());
        BigDecimal stepDecimal = new BigDecimal(segmentId.getStep().toString());
        maxIdDecimal.add(stepDecimal);
        BigDecimal sumDecimal = maxIdDecimal.add(stepDecimal);
        Long maxId = sumDecimal.longValue();
        segmentId.setMaxId(maxId);
        segmentId.setUpdateTime(DateUtils.toLocalDateTime(new Date()));
        segmentIdMapper.updateById(segmentId);
        return sumDecimal;
    }
}
