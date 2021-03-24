package com.github.sparkzxl.job.admin.core.route.strategy;

import com.github.sparkzxl.job.admin.core.route.ExecutorRouter;
import com.github.sparkzxl.job.admin.core.scheduler.XxlJobScheduler;
import com.github.sparkzxl.job.admin.core.util.I18nUtil;
import com.xxl.job.core.biz.ExecutorBiz;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.biz.model.TriggerParam;

import java.util.List;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFailover extends ExecutorRouter {

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList) {

        StringBuilder beatResultSb = new StringBuilder();
        for (String address : addressList) {
            // beat
            ReturnT<String> beatResult;
            try {
                ExecutorBiz executorBiz = XxlJobScheduler.getExecutorBiz(address);
                beatResult = executorBiz.beat();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                beatResult = new ReturnT<>(ReturnT.FAIL_CODE, "" + e);
            }
            beatResultSb.append((beatResultSb.length() > 0) ? "<br><br>" : "")
                    .append(I18nUtil.getString("jobconf_beat")).append("：")
                    .append("<br>address：").append(address)
                    .append("<br>code：").append(beatResult.getCode())
                    .append("<br>msg：").append(beatResult.getMsg());

            // beat success
            if (beatResult.getCode() == ReturnT.SUCCESS_CODE) {

                beatResult.setMsg(beatResultSb.toString());
                beatResult.setContent(address);
                return beatResult;
            }
        }
        return new ReturnT<>(ReturnT.FAIL_CODE, beatResultSb.toString());

    }
}
