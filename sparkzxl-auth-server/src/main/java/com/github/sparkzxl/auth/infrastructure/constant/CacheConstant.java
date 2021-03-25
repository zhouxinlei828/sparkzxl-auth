package com.github.sparkzxl.auth.infrastructure.constant;

/**
 * description: 缓存常量
 *
 * @author charles.zhou
 * @date   2020-07-28 11:01:07
 */
public class CacheConstant {

    /**
     * 验证码 前缀
     * 完整key: captcha:{key} -> str
     */
    public static String CAPTCHA = "captcha";


    /**
     * 菜单 前缀
     * 完整key: menu:{menuId} -> obj
     */
    public static String MENU = "menu";
    /**
     * 组织 前缀
     * 完整key: station:{stationId} -> obj
     */
    public static String ORG = "org";
    /**
     * 岗位 前缀
     * 完整key: station:{stationId} -> obj
     */
    public static String STATION = "station";

    /**
     * 资源 前缀
     * 完整key: resource:{resourceId} -> obj
     */
    public static String RESOURCE = "resource";

    /**
     * 角色 前缀
     * 完整key: role:{roleId}
     */
    public static String ROLE = "role";

    /**
     * 角色拥有那些菜单 前缀
     * 完整key: role_menu:{ROLE_ID} -> [MENU_ID, MENU_ID, ...]
     */
    public static String ROLE_MENU = "role_menu";
    /**
     * 角色拥有那些资源 前缀
     * 完整key: role_resource:{ROLE_ID} -> [RESOURCE_ID, ...]
     */
    public static String ROLE_RESOURCE = "role_resource";

    /**
     * 用户 前缀
     * 完整key: user:classTypeName:{USER_ID} -> [ROLE_ID, ...]
     */
    public static String USER = "user";

    /**
     * 用户拥有那些角色 前缀
     * 完整key: user_role:{USER_ID} -> [ROLE_ID, ...]
     */
    public static String USER_ROLE = "user_role";
    /**
     * 用户拥有的菜单 前缀
     * 完整key: user_menu:{userId} -> [MENU_ID, MENU_ID, ...]
     */
    public static String USER_MENU = "user_menu";
    /**
     * 用户拥有的资源 前缀
     * 完整key: user_resource:{userId} -> [RESOURCE_ID, ...]
     */
    public static String USER_RESOURCE = "user_resource";

    /**
     * 登录总次数
     * login_log_total:{TENANT} -> Long
     */
    public static String LOGIN_LOG_TOTAL = "login_log_total";
    /**
     * 今日登录总次数
     * login_log_today:{TENANT}:{today} -> Long
     */
    public static String LOGIN_LOG_TODAY = "login_log_today";
    /**
     * 今日登录总ip
     * login_log_todayip:{TENANT}:{today} -> Map
     */
    public static String LOGIN_LOG_TODAY_IP = "login_log_todayip";
    /**
     * 最近10访问记录
     * login_log_tenday:{TENANT}:{today}:{account} -> Map
     */
    public static String LOGIN_LOG_TEN_DAY = "login_log_tenday";
    /**
     * 登录总次数
     * login_log_browser:{TENANT} -> Map
     */
    public static String LOGIN_LOG_BROWSER = "login_log_browser";
    /**
     * 登录总次数
     * login_log_system{TENANT} -> Map
     */
    public static String LOGIN_LOG_SYSTEM = "login_log_system";

    /**
     * 地区 前缀
     * 完整key: area:{id} -> obj
     */
    public static String AREA = "area";
    /**
     * 所有地区 前缀
     * 完整key: area_all -> [AREA_ID]
     */
    public static String AREA_ALL = "area_all";

    /**
     * 字典 前缀
     * 完整key: dictionary_item:{id} -> obj
     */
    public static String DICTIONARY_ITEM = "dictionary_item";

    /**
     * 字典 前缀
     * 完整key: dictionary:{id} -> obj
     */
    public static String DICTIONARY = "dictionary";


    public static String FRONT_STATE = "front_state";


    public static final String RESOURCE_ROLES_MAP = "auth:resource_roles_map";

}
