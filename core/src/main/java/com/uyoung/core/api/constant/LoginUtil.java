package com.uyoung.core.api.constant;

import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
import com.uyoung.core.base.util.DataUtil;
import com.uyoung.core.base.util.EncryptUtil;
import com.uyoung.core.base.util.MD5Util;
import com.uyoung.core.base.util.SpringContextHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Random;

import static com.uyoung.core.base.util.DataUtil.parseParamStr;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public final class LoginUtil {
    private static LoginService loginService = SpringContextHolder.getBean("loginService");
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUtil.class);

    /**
     * @param email
     * @return
     */
    public static String getLoginHash(String email) {
        String source = email + LoginConstant.HASH_KEY + getRandomInt();
        return MD5Util.get(source, CommonConstant.DEFAULT_ENCODE);
    }

    /**
     * @param email
     * @return
     */
    public static String getLoginToken(String email) {
        String source = email + LoginConstant.TOKEN_KEY + getRandomInt();
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
     * @param email
     * @return
     */
    public static Login updateLogin(String email, Integer uid) {
        Login login = new Login();
        login.setEmail(email);
        login.setUid(uid);
        login.setLoginHash(getLoginHash(email));
        login.setLoginToken(getLoginToken(email));
        LOGGER.info("#Update login:" + login.toString());
        loginService.addOrUpdate(login);
        return login;
    }

    /**
     * 加密Code
     *
     * @param email
     * @return
     */
    public static String getSessionId(String email, Integer uid) {
        String source = updateLogin(email, uid).getBaseToString();
        return EncryptUtil.getBASE64(source.getBytes());
    }


    /**
     * 增加Cookie
     *
     * @param response
     * @param email
     * @return
     */
    public static boolean addLoginCookie(HttpServletResponse response, String email, Integer uid) {
        String sessionId = getSessionId(email, uid);
        LOGGER.info("#Add loginCookie sessionId is " + sessionId);
        Cookie emailCookie = new Cookie(LoginConstant.COOKIE_LOGIN_KEY, sessionId);
        emailCookie.setDomain(LoginConstant.COOKIE_DOMAIN);
        emailCookie.setMaxAge(LoginConstant.MAX_LOGIN_SECONDS);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);
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
        if (login.getUid() != null || StringUtils.isBlank(login.getLoginHash()) || StringUtils.isBlank(login.getLoginToken())) {
            return false;
        }
        Login record = loginService.getByUid(login.getUid());
        if (record == null) {
            return false;
        }
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
                return getFromSessionId(new String(EncryptUtil.getFromBASE64(cookie.getValue())));
            }
        }
        return null;
    }

    /**
     * @param sessionId
     * @return
     */
    public static Login getFromSessionId(String sessionId) {
        Map<String, String> dataMap = DataUtil.parseParamStr(sessionId);
        if (dataMap == null || dataMap.size() == 0) {
            return null;
        }
        Login login = new Login();
        login.setUid(Integer.parseInt(dataMap.get("uid")));
        login.setEmail(dataMap.get("email"));
        login.setLoginHash(dataMap.get(LoginConstant.LOGIN_HASH_KEY));
        login.setLoginToken(dataMap.get(LoginConstant.LOGIN_TOKEN_KEY));
        return login;
    }

    /**
     * 参数中获取
     *
     * @param request
     * @return
     */
    public static Login getLoginFromParam(HttpServletRequest request) {
        String sessionId = (String) request.getAttribute(CommonConstant.PARAM_SESSION_ID);
        if (StringUtils.isNotBlank(sessionId)) {
            String sessionIdStr = new String(EncryptUtil.getFromBASE64(sessionId));
            Map<String, String> paramMap = parseParamStr(sessionIdStr);
            Login login = new Login();
            login.setUid(Integer.parseInt(paramMap.get("uid")));
            login.setEmail(paramMap.get("email"));
            login.setLoginHash(paramMap.get("loginToken"));
            login.setLoginToken(paramMap.get("loginHash"));
            LOGGER.info("#Login info is " + login.toString());
            return login;
        } else {
            LOGGER.warn("#Session id is null.");
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(LoginUtil.getRandomInt());
    }
}
