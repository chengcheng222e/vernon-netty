package com.vernon.netty.core.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-22
 * Time: AM10:13
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {

    private static final String EMPTY = "";

    /**
     * 如果是空的字符串返回 EMPTY, 否则原路返回
     *
     * @param source
     * @return
     */
    public String getStr(String source) {
        if (StringUtils.isBlank(source)) {
            return EMPTY;
        }
        return source;
    }
}
