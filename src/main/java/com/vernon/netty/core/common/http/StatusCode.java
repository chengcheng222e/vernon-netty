package com.vernon.netty.core.common.http;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM6:28
 * To change this template use File | Settings | File Templates.
 */
public enum StatusCode {
    DEFAULT(0, "操作成功"),
    GATEWAY_ERROR(1001, "网关错误"),
    PARAMS_ERROR(1002, "参数校验错误"),
    OPERATOR_ERROR(1003, "操作失败"),
    NOT_FOUND_ERROR(1004, "未发现请求地址");

    private int code;
    private String msg;

    private StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
