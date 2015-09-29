package com.uyoung.web.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:
 */
public final class JsonUtil {
    private JsonUtil() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static ObjectMapper getObjectMapper() {
        return MAPPER;
    }

    /**
     * 生成Json
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static String getJsonString(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (IOException e) {
            LOGGER.error("Get json string error.Cause:", e);
        }
        return null;
    }


}
