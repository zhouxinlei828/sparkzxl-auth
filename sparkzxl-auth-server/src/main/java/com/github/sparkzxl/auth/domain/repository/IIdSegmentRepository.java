package com.github.sparkzxl.auth.domain.repository;

import java.math.BigDecimal;

/**
 * description: 序列生成仓储类
 *
 * @author charles.zhou
 * @date   2021-02-20 17:38:32
 */
public interface IIdSegmentRepository {

    /**
     * 生成id
     *
     * @param businessTag 业务标记
     * @return BigDecimal
     */
    BigDecimal getIdSegment(String businessTag);

}
