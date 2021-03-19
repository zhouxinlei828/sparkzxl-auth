package com.github.sparkzxl.auth.domain.constant;


import com.github.sparkzxl.auth.infrastructure.enums.SexEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/7 9:19 上午
 */
public class AuthorizationConstant {

    public static final Map<Integer, String> SEX_MAP = new HashMap<Integer, String>(3) {
        {
            put(SexEnum.MAN.getCode(),SexEnum.MAN.getDesc());
            put(SexEnum.WOMAN.getCode(),SexEnum.WOMAN.getDesc());
            put(SexEnum.NONE.getCode(),SexEnum.NONE.getDesc());
        }
    };


}
