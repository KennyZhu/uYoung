package com.uyoung.core.api.constant;

/**
 * Desc:
 * <p/>Date: 2015-10-13
 * <br/>Time: 15:17
 * <br/>User: ylzhu
 */
public final class CommonConstant {

    /**
     * 用户默认头像URL
     */
    public static final String DEFAULT_AVATAR_URL = "";
    /**
     * 默认编码格式
     */
    public static final String DEFAULT_ENCODE = "UTF-8";

    /**
     * 活动开始时间，不能晚于当前时间+90天
     */
    public static final long MAX_ACTIVITY_TIME_INTERVAL = 1000 * 60 * 60 * 24 * 90L;

    /**
     * 活动报名时间，不能超过7天
     */
    public static final long MAX_ACTIVITY_SIGNUP_TIME = 1000 * 3600 * 24 * 7L;


    /**
     * '北京','上海','广州','深圳','杭州','大连','武汉','成都'
     */
    public static final Integer[] CITIES = new Integer[]{382, 412, 357, 314, 359, 270, 170, 32};


    /**
     * 加密数据
     */
    public static final String PARAM_DATA = "data";

    /**
     * 时间戳
     */
    public static final String PARAM_STAMP = "stamp";


    /**
     * Session Id
     */
    public static final String PARAM_SESSION_ID = "sessionId";


}
