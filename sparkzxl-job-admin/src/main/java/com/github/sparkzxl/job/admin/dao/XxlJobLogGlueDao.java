package com.github.sparkzxl.job.admin.dao;

import com.github.sparkzxl.job.admin.core.model.XxlJobLogGlue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * job log for glue
 * @author xuxueli 2016-5-19 18:04:56
 */
@Mapper
public interface XxlJobLogGlueDao {

	int save(XxlJobLogGlue xxlJobLogGlue);

	List<XxlJobLogGlue> findByJobId(@Param("jobId") int jobId);

	int removeOld(@Param("jobId") int jobId, @Param("limit") int limit);

	int deleteByJobId(@Param("jobId") int jobId);

}
