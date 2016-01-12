package com.uyoung.core.third;

import com.uyoung.core.third.enums.ThirdPlatformEnum;
import org.apache.commons.lang.StringUtils;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public final class ThirdUtil {

    /**
     * @param thirdUid
     * @param platformEnum
     * @return
     */
    public static String getEmail(String thirdUid, ThirdPlatformEnum platformEnum) {
        if (StringUtils.isBlank(thirdUid) || platformEnum == null) {
            return null;
        }
        return thirdUid + platformEnum.getEmailSuffix();
    }

    /**
     * @param thirdUid
     * @param userType
     * @return
     */
    public static String getEmail(String thirdUid, int userType) {
        if (StringUtils.isBlank(thirdUid)) {
            return null;
        }
        ThirdPlatformEnum platformEnum = ThirdPlatformEnum.getByCode(userType);
        if (platformEnum == null) {
            return null;
        }
        return getEmail(thirdUid, platformEnum);
    }
}
