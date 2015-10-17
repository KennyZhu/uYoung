package com.uyoung.core.third.bean;

import com.uyoung.core.third.enums.ThirdPlatformEnum;

/**
 * Desc:微博登录授权接口参数Bean
 * <p/>http://open.weibo.com/wiki/Oauth2/authorize
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:48
 * <br/>User: ylzhu
 */
public class WeiBoAuthParamBean extends AuthParamBaseBean {

    private static final String APP_KEY = "1375588776";
    private static final String APP_SECRET = "07f14d91a5289cc5b7e586f4e88458b6";
    private static final String AUTH_BASE_URL = "https://api.weibo.com/oauth2/authorize?";
    private static final String TOKEN_BASE_URL = "https://api.weibo.com/oauth2/access_token?";

    @Override
    public String getAuthBaseUrl() {
        return AUTH_BASE_URL;
    }

    @Override
    public String getTokenBaseUrl() {
        return TOKEN_BASE_URL;
    }

    @Override
    public String getAppKey() {
        return APP_KEY;
    }

    @Override
    public String getAppSecret() {
        return APP_SECRET;
    }

    @Override
    public ThirdPlatformEnum getThirdPlatform() {
        return ThirdPlatformEnum.WEIBO;
    }

    /**
     * 授权页面终端类型
     */
    private DisplayEnum display;

    public DisplayEnum getDisplay() {
        return display;
    }

    public void setDisplay(DisplayEnum display) {
        this.display = display;
    }

    enum DisplayEnum {
        /**
         * 默认的授权页面，适用于web浏览器。
         */
        DEFAULT("default"),
        /**
         * 移动终端的授权页面，适用于支持html5的手机
         */
        MOBILE("mobile");
        private String value;

        DisplayEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
