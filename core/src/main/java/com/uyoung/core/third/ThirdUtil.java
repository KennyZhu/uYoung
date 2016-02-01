package com.uyoung.core.third;

import com.uyoung.core.third.enums.ThirdPlatformEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public final class ThirdUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdUtil.class);

    /**
     * @param thirdUid
     * @param platformEnum
     * @return
     */
    public static String getEmail(String thirdUid, ThirdPlatformEnum platformEnum) {
        if (StringUtils.isBlank(thirdUid) || platformEnum == null) {
            LOGGER.error("#Invalid param.");
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
            LOGGER.warn("#Get platformEnum by userType :" + userType + " return null.");
            return null;
        }
        return getEmail(thirdUid, platformEnum);
    }
}
