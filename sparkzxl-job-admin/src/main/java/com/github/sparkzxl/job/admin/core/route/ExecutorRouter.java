package com.github.sparkzxl.job.admin.core.route;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.biz.model.TriggerParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * description:
 *
 * @author charles.zhou
 * @date   2021-03-12 15:48:35
 */
public abstract class ExecutorRouter {
    protected static Logger logger = LoggerFactory.getLogger(ExecutorRouter.class);

    /**
     * route address
     *
     * @param triggerParam 触发参数
     * @param addressList  地址列表
     * @return ReturnT.content=address
     */
    public abstract ReturnT<String> route(TriggerParam triggerParam, List<String> addressList);

}
