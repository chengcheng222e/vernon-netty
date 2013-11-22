package com.vernon.netty.core;

import org.jboss.netty.channel.Channel;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:01
 * To change this template use File | Settings | File Templates.
 */
public class Context {

    // ----------------------------------- field names ----------------------------------------

    private final Integer userId;
    private final Integer operatorId;
    private final String path;
    private final Map<String, String> headerParams;
    private final Map<String, String> bodyParams;
    private final Channel channel;


    public Context(int userId,
                   int operatorId,
                   String path,
                   Map<String, String> headerParams,
                   Map<String, String> bodyParams,
                   Channel channel) {
        this.userId = userId;
        this.operatorId = operatorId;
        this.path = path;
        this.headerParams = headerParams;
        this.bodyParams = bodyParams;
        this.channel = channel;
    }

    // ------------------------------ setter / getter methods ----------------------------------

    public Map<String, String> getBodyParams() {
        return bodyParams;
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public String getPath() {
        return path;
    }

    public Integer getUserId() {
        return userId;
    }

    public Channel getChannel() {
        return channel;
    }

    // -------------------------------------- other methods -----------------------------------

    /**
     * 获取 channelId
     *
     * @return
     */
    public int getChannelId() {
        if (channel != null) {
            return channel.getId();
        }
        return 0;
    }

    /**
     * 根据 key 获取 Map 里的参数
     *
     * @param key
     * @return
     */
    public String getParam(String key) {
        if (bodyParams != null) {
            return bodyParams.get(key);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Context{" +
                "bodyParams=" + bodyParams +
                ", userId=" + userId +
                ", operatorId=" + operatorId +
                ", path='" + path + '\'' +
                ", headerParams=" + headerParams +
                ", channel=" + channel +
                '}';
    }
}
