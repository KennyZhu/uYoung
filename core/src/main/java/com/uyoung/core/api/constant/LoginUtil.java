package com.uyoung.core.api.constant;

import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
import com.uyoung.core.base.util.JsonUtil;
import com.uyoung.core.base.util.MD5Util;
import com.uyoung.core.base.util.SpringContextHolder;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public final class LoginUtil {
    private static LoginService loginService = SpringContextHolder.getBean("loginService");


    /**
     * @param accountId
     * @return
     */
    public static final String getLoginHash(String accountId) {
        String source = accountId + LoginConstant.HASH_KEY + getRandomInt();
        return MD5Util.get(source, CommonConstant.DEFAULT_ENCODE);
    }

    /**
     * @param accountId
     * @return
     */
    public static final String getLoginToken(String accountId) {
        String source = accountId + LoginConstant.TOKEN_KEY + getRandomInt();
        return MD5Util.get(source, CommonConstant.DEFAULT_ENCODE);
    }

    /**
     * @return
     */
    private static long getRandomInt() {
        Random random = new Random();
        return random.nextLong();
    }


    /**
     * 获取LoginCookie
     *
     * @param accountId
     * @return
     */
    public static Login getLoginCookieByAccountId(String accountId) {
        Login loginCookie = new Login();
        loginCookie.setAccountId(accountId);
        loginCookie.setLoginHash(getLoginHash(accountId));
        loginCookie.setLoginToken(getLoginToken(accountId));
        return loginCookie;
    }

    /**
     * 增加Cookie
     *
     * @param response
     * @param accountId
     * @return
     */
    public static boolean addLoginCookie(HttpServletResponse response, String accountId) {
        Cookie accountIdCookie = new Cookie(LoginConstant.COOKIE_LOGIN_ACCOUNT, getLoginCookieByAccountId(accountId).getBaseToString());
        accountIdCookie.setDomain(LoginConstant.COOKIE_DOMAIN);
        accountIdCookie.setMaxAge(LoginConstant.MAX_LOGIN_SECONDS);
        response.addCookie(accountIdCookie);
        return true;
    }

    /**
     * 检查是否登录
     *
     * @param request
     * @return
     */
    public static boolean checkLogin(HttpServletRequest request) {
        Login login = getLoginCookie(request);
        return checkLogin(login);
    }

    public static boolean checkLogin(Login login) {
        if (login == null) {
            return false;
        }
        if (StringUtils.isBlank(login.getAccountId()) || StringUtils.isBlank(login.getLoginHash()) || StringUtils.isBlank(login.getLoginToken())) {
            return false;
        }
        Login record = loginService.getByAccountId(login.getAccountId());
        if (login.getLoginHash().equals(record.getLoginHash()) && login.getLoginToken().equals(record.getLoginToken())) {
            return true;
        }
        return false;

    }

    /**
     * @param request
     * @return
     */
    public static Login getLoginCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (LoginConstant.COOKIE_LOGIN_KEY.equals(cookie.getName())) {
                return (Login) JsonUtil.parse(cookie.getValue(), Login.class);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(LoginUtil.getRandomInt());
    }
}
