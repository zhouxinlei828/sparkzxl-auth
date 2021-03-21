package com.github.sparkzxl.workflow.infrastructure.utils;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

import java.util.Map;

/**
 * description:EL表达式解析
 *
 * @author charles.zhou
 * @date   2020-07-22 17:48:50
 */
public class FelSupport {

    public static Object result(Map<String, Object> map, String expression) {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            ctx.set(entry.getKey(), entry.getValue());
        }
        return fel.eval(expression);
    }
}
