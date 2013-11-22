package com.vernon.netty.core.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:01
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * JSON串转换为Java泛型对象
     *
     * @param <T>
     * @param jsonString JSON字符串
     * @param tr TypeReference,例如: new TypeReference< List<FamousUser> >(){}
     * @return
     */
    public static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        } else {
            try {
                return (T) objectMapper.readValue(jsonString, tr);
            } catch (Exception e) {
                logger.error("json error:{}" + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Java对象转Json字符串
     *
     * @param object Java对象，可以是对象，数组，List,Map等
     * @return json 字符串
     */
    public static String toJson(Object object) {
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.warn("json error:" + e.getMessage());
        }
        return jsonString;

    }

    /**
     * Json字符串转Java对象
     *
     * @param jsonString
     * @param c
     * @return
     */
    public static Object json2Object(String jsonString, Class<?> c) {
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        } else {
            try {
                return objectMapper.readValue(jsonString, c);
            } catch (Exception e) {
                logger.warn("json error:" + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Json字符串转Map对象
     *
     * @param jsonString
     * @return
     */
    public static Map<String, Object> json2Map(String jsonString) {
        if (StringUtils.isNotBlank(jsonString)) {
            try {
                Map<String, Object> map = objectMapper.readValue(
                        jsonString,
                        new TypeReference<Map<String, Object>>() {
                        }
                );
                return map;
            } catch (Exception e) {
                logger.warn("json error:" + e.getMessage());
            }
        }
        return new HashMap<String, Object>();
    }
}
