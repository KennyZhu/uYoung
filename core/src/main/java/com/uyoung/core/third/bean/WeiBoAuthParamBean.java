package com.uyoung.core.third.bean;

/**
 * Desc:微博登录授权接口参数Bean
 * <p/>http://open.weibo.com/wiki/Oauth2/authorize
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:48
 * <br/>User: ylzhu
 */
public class WeiBoAuthParamBean extends AuthParamBaseBean {
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
