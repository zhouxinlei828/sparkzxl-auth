package com.github.sparkzxl.auth.infrastructure.constant;

/**
 * description: 仅仅用于记录 RemoteField 注解相关的 接口和方法名称
 * 切记，该类下的接口和方法，一定要自己手动创建，否则会注入失败
 *
 * @author charles.zhou
 * @date 2020-07-19 09:25:48
 */
public class EchoConstant {

    public static final String FIND_NAME_BY_IDS = "findNameByIds";
    public static final String FIND_BY_IDS = "findByIds";

    /**
     * 组织 仓储查询类
     */
    public static final String ORG_ID_CLASS = "coreOrgServiceImpl";
    /**
     * 组织 feign查询类
     */
    public static final String ORG_ID_FEIGN_CLASS = "orgApi";

    /**
     * 组织 查询方法
     */
    public static final String ORG_ID_METHOD = "findOrgByIds";
    public static final String ORG_ID_NAME_METHOD = "findOrgNameByIds";


    /**
     * 用户 service查询类
     */
    public static final String USER_ID_CLASS = "userServiceImpl";
    /**
     * 用户 feign查询类
     */
    public static final String USER_ID_FEIGN_CLASS = "userApi";

    /**
     * 用户 查询方法
     */
    public static final String USER_ID_METHOD = "findUserByIds";
    public static final String USER_ID_NAME_METHOD = "findUserNameByIds";


    /**
     * 职位 仓储查询类
     */
    public static final String STATION_ID_CLASS = "coreStationRepository";

    /**
     * 职位 查询方法
     */
    public static final String STATION_ID_METHOD = "findStationByIds";

    /**
     * 数据字典项 service查询类
     */
    public static final String DICTIONARY_ITEM_CLASS = "dictionaryItemServiceImpl";

    /**
     * 数据字典项 api查询方法
     */
    public static final String DICTIONARY_ITEM_METHOD = "findDictionaryItem";
}
