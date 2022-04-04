package com.github.sparkzxl.auth.infrastructure.constant;

/**
 * description: 业务常量类
 *
 * @author zhouxinlei
 * @date 2021-07-11 09:47:39
 */
public class BizConstant {

    /*=====================字典==========================*/
    /**
     * 职位状态
     */
    public static final String POSITION_STATUS = "POSITION_STATUS";
    /**
     * 民族
     */
    public static final String SEX = "SEX";
    /**
     * 民族
     */
    public static final String NATION = "NATION";
    /**
     * 学历
     */
    public static final String EDUCATION = "EDUCATION";
    /**
     * 行政区级
     */
    public static final String AREA_LEVEL = "AREA_LEVEL";
    /**
     * 机构类型
     */
    public static final String ORG_TYPE = "ORG_TYPE";
    public static final String[] ALL = new String[]{
            EDUCATION, NATION, POSITION_STATUS, AREA_LEVEL, ORG_TYPE
    };

    /*=====================角色==========================*/
    /**
     * 普通用户角色code
     */
    public static final String USER_CODE = "USER";

    /**
     * 用户信息查询路径
     */
    public static final String USER_PATH = "/user/userinfo";

    /**
     * 用户信息查询路径
     */
    public static final String USER_ROUTER_PATH = "/user/routers";

    /*=====================缓存==========================*/
    /**
     * 验证码 前缀
     * 完整key: captcha:{key} -> str
     */
    public static final String CAPTCHA = "captcha";


    /**
     * 菜单 前缀
     * 完整key: menu:{menuId} -> obj
     */
    public static final String MENU = "menu";
    /**
     * 组织 前缀
     * 完整key: station:{stationId} -> obj
     */
    public static final String ORG = "org";
    /**
     * 岗位 前缀
     * 完整key: station:{stationId} -> obj
     */
    public static final String STATION = "station";

    /**
     * 资源 前缀
     * 完整key: resource:{resourceId} -> obj
     */
    public static final String RESOURCE = "resource";

    /**
     * 角色 前缀
     * 完整key: role:{roleId}
     */
    public static final String ROLE = "role";

    /**
     * 角色拥有那些菜单 前缀
     * 完整key: role_menu:{ROLE_ID} -> [MENU_ID, MENU_ID, ...]
     */
    public static final String ROLE_MENU = "role_menu";
    /**
     * 角色拥有那些资源 前缀
     * 完整key: role_resource:{ROLE_ID} -> [RESOURCE_ID, ...]
     */
    public static final String ROLE_RESOURCE = "role_resource";

    /**
     * 用户 前缀
     * 完整key: user:classTypeName:{USER_ID} -> [ROLE_ID, ...]
     */
    public static final String USER = "user";

    /**
     * 用户拥有那些角色 前缀
     * 完整key: user_role:{USER_ID} -> [ROLE_ID, ...]
     */
    public static final String USER_ROLE = "user_role";
    /**
     * 用户拥有的菜单 前缀
     * 完整key: user_menu:{userId} -> [MENU_ID, MENU_ID, ...]
     */
    public static final String USER_MENU = "user_menu";
    /**
     * 用户拥有的资源 前缀
     * 完整key: user_resource:{userId} -> [RESOURCE_ID, ...]
     */
    public static final String USER_RESOURCE = "user_resource";

    /**
     * 登录总次数
     * login_log_total:{TENANT} -> Long
     */
    public static final String LOGIN_LOG_TOTAL = "login_log_total";
    /**
     * 今日登录总次数
     * login_log_today:{TENANT}:{today} -> Long
     */
    public static final String LOGIN_LOG_TODAY = "login_log_today";
    /**
     * 今日登录总ip
     * login_log_todayip:{TENANT}:{today} -> Map
     */
    public static final String LOGIN_LOG_TODAY_IP = "login_log_today_ip";
    /**
     * 最近10访问记录
     * login_log_tenday:{TENANT}:{today}:{account} -> Map
     */
    public static final String LOGIN_LOG_TEN_DAY = "login_log_tenday";
    /**
     * 登录总次数
     * login_log_browser:{TENANT} -> Map
     */
    public static final String LOGIN_LOG_BROWSER = "login_log_browser";
    /**
     * 登录总次数
     * login_log_system{TENANT} -> Map
     */
    public static final String LOGIN_LOG_SYSTEM = "login_log_system";

    /**
     * 地区 前缀
     * 完整key: area:{id} -> obj
     */
    public static final String AREA = "area";

    /**
     * 字典 前缀
     * 完整key: dictionary_item:{id} -> obj
     */
    public static final String DICTIONARY_ITEM = "dictionary_item";

    /**
     * 字典 前缀
     * 完整key: dictionary:{id} -> obj
     */
    public static final String DICTIONARY = "dictionary";


    public static final String FRONT_STATE = "front_state";


    /*=====================扫包==========================*/

    public static final String BUSINESS_PACKAGE = "com.github.sparkzxl.auth";

    public static final String BUSINESS_FEIGN_PACKAGE = "com.github.sparkzxl.auth.interfaces.client";


    /*=====================扫包==========================*/

    public static final String TENANT_SERVICE_ = "sparkzxl-tenant-server";
}
