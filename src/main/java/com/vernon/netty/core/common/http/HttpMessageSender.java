package com.vernon.netty.core.common.http;

import com.vernon.netty.core.Context;
import com.vernon.netty.core.MessageResponse;
import com.vernon.netty.core.common.util.JsonUtil;
import com.vernon.netty.core.MessageSender;
import org.jboss.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM10:10
 * To change this template use File | Settings | File Templates.
 */
public class HttpMessageSender implements MessageSender{

    private static final Logger logger = LoggerFactory.getLogger(HttpMessageSender.class);

    @Override
    public boolean handle(Context context, MessageResponse response) {
        Channel channel = context.getChannel();
        boolean isSendOk = false;
        if (channel != null && channel.isConnected()) {
            Map<String, Object> respMap = response.toMap();
            String json = JsonUtil.toJson(respMap);
            HttpHelper.sendOK(channel, json);
            isSendOk = true;
        }
        logger.info("http,operId={},channelid={},sendOk={}", context.getOperatorId(), channel.getId(), isSendOk);
        return isSendOk;
    }
}
