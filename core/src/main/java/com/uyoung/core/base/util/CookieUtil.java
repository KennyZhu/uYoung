package com.uyoung.core.base.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:
 * <p/>Date: 2015-11-10
 * <br/>Time: 18:12
 * <br/>User: ylzhu
 */
public final class CookieUtil {
    private CookieUtil() {

    }

    /**
     * @param request
     * @return
     */
    public boolean addLoginCookie(HttpServletRequest request) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
