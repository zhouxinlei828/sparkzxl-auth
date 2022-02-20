package com.github.sparkzxl.auth.infrastructure.constant;

/**
 * description: 仅仅用于记录 RemoteField 注解相关的 接口和方法名称
 * 切记，该类下的接口和方法，一定要自己手动创建，否则会注入失败
 *
 * @author charles.zhou
 * @date 2020-07-19 09:25:48
 */
public class EchoConstant {

    /**
     * 组织 仓储查询类
     */
    public static final String ORG_ID_CLASS = "coreOrgRepository";

    /**
     * 职位 仓储查询类
     */
    public static final String STATION_ID_CLASS = "coreStationRepository";

    /**
     * 数据字典项 service查询类
     */
    public static final String DICTIONARY_ITEM_CLASS = "dictionaryItemRepository";


}
