package com.vernon.netty.core;

import com.vernon.netty.core.common.http.StatusCode;
import com.vernon.netty.core.common.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM6:39
 * To change this template use File | Settings | File Templates.
 */
public class MessageResponse {

    // ---------------------------------  field names --------------------------------
    private Integer code;
    private String msg;
    private Object body;

    public MessageResponse(StatusCode statusCode) {
        setCodeAndMsg(statusCode);
    }

    // --------------------------  setter / getter methods ---------------------------

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    // --------------------------------- other methods --------------------------------

    /**
     * 设置状态码与信息
     *
     * @param statusCode
     */
    public void setCodeAndMsg(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    /**
     * 返回的 JSON 格式, code,msg,body3个部分
     *
     * @return
     */
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("body", body);
        return map;
    }

    /**
     * 给 body 赋值
     *
     * @param key
     * @param value
     */
    public void pushBody(String key, Object value) {
        if (body == null) {
            body = new HashMap<String, Object>();
        }
        if (body instanceof Map) {
            ((Map) body).put(key, value);
        } else {
            throw new UnsupportedOperationException("body不支持pubBody操作");
        }
    }


}
