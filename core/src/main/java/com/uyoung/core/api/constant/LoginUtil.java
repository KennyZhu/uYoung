package com.uyoung.core.api.constant;

import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
import com.uyoung.core.base.util.EncryptUtil;
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
    public static String getLoginHash(String accountId) {
        String source = accountId + LoginConstant.HASH_KEY + getRandomInt();
        return MD5Util.get(source, CommonConstant.DEFAULT_ENCODE);
    }

    /**
     * @param accountId
     * @return
     */
    public static String getLoginToken(String accountId) {
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
    public static Login updateLogin(String accountId) {
        Login login = new Login();
        login.setAccountId(accountId);
        login.setLoginHash(getLoginHash(accountId));
        login.setLoginToken(getLoginToken(accountId));
        loginService.addOrUpdate(login);
        return login;
    }

    /**
     * 加密Code
     *
     * @param accountId
     * @return
     */
    public static String getSessionId(String accountId) {
        String source = updateLogin(accountId).getBaseToString();
        return EncryptUtil.encryptCode(source, String.valueOf(System.currentTimeMillis()));
    }


    /**
     * 增加Cookie
     *
     * @param response
     * @param accountId
     * @return
     */
    public static boolean addLoginCookie(HttpServletResponse response, String accountId) {
        Cookie accountIdCookie = new Cookie(LoginConstant.LOGIN_ACCOUNT_KEY, updateLogin(accountId).getBaseToString());
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
        Login login = getLoginFromCookie(request);
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
        return login.getLoginHash().equals(record.getLoginHash()) && login.getLoginToken().equals(record.getLoginToken());

    }

    /**
     * @param request
     * @return
     */
    public static Login getLoginFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (LoginConstant.COOKIE_LOGIN_KEY.equals(cookie.getName())) {
                return (Login) JsonUtil.parse(cookie.getValue(), Login.class);
            }
        }
        return null;
    }

    /**
     * 参数中获取
     *
     * @param request
     * @return
     */
    public static Login getLoginFromParam(HttpServletRequest request) {
        String accountId = (String) request.getAttribute(LoginConstant.LOGIN_ACCOUNT_KEY);
        String hash = (String) request.getAttribute(LoginConstant.LOGIN_HASH_KEY);
        String token = (String) request.getAttribute(LoginConstant.LOGIN_TOKEN_KEY);
        Login login = new Login();
        login.setAccountId(accountId);
        login.setLoginHash(hash);
        login.setLoginToken(token);
        return login;
    }

    public static void main(String[] args) {
        System.out.println(LoginUtil.getRandomInt());
    }
}
