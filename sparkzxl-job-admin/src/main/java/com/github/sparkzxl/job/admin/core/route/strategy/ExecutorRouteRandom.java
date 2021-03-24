package com.github.sparkzxl.job.admin.core.route.strategy;

import com.github.sparkzxl.job.admin.core.route.ExecutorRouter;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.biz.model.TriggerParam;

import java.util.List;
import java.util.Random;

/**
 * description:
 *
 * @author charles.zhou
 * @date   2021-03-12 16:12:56
*/
public class ExecutorRouteRandom extends ExecutorRouter {

    private static final Random LOCAL_RANDOM = new Random();

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList) {
        String address = addressList.get(LOCAL_RANDOM.nextInt(addressList.size()));
        return new ReturnT<>(address);
    }

}
