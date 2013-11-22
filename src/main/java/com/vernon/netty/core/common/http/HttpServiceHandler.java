package com.vernon.netty.core.common.http;


import com.vernon.netty.core.AppUtil;
import com.vernon.netty.core.Context;
import com.vernon.netty.core.MessageForwarder;
import com.vernon.netty.core.MessageResponse;
import com.vernon.netty.core.web.action.ActionFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: AM11:56
 * To change this template use File | Settings | File Templates.
 */
public class HttpServiceHandler extends SimpleChannelHandler {

    private Logger logger = LoggerFactory.getLogger(HttpServiceHandler.class);
    static Charset UTF8 = Charset.forName("UTF-8");
    static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    static final String userAgentKey = "User-Agent";

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        final int operatorId = AppUtil.operatorIndex.incrementAndGet();
        logger.info("{} ---------- messageReceived start ------------", operatorId);

        // ------------------------ 分析 request ------------------------
        HttpRequest httpRequest = (HttpRequest) e.getMessage();
        Channel channel = e.getChannel();

        logger.info("{}, channelId={}, httpRequest.getUri()={}", operatorId, channel.getId(), httpRequest.getUri());

        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(httpRequest.getUri(), UTF8);

        // path, params, contentType
        String path = queryStringDecoder.getPath();
        Map<String, List<String>> params = queryStringDecoder.getParameters();
        String contentType = httpRequest.getHeader(HttpHeaders.Names.CONTENT_TYPE);

        if (httpRequest.getMethod() == HttpMethod.POST) {
            // 判断是浏览器的 form 表单提交
            if (contentType != null && contentType.startsWith(APPLICATION_X_WWW_FORM_URLENCODED)) {

            }
        }

        Map<String, String> bodyParams = formatReqParam(params);
        Map<String, String> headerParams = new HashMap<String, String>();
        if (httpRequest.containsHeader(userAgentKey)) {
            headerParams.put(userAgentKey, httpRequest.getHeader(userAgentKey));
        }

        int userId = 11241;

        Context context = new Context(userId, operatorId, path, headerParams, bodyParams, channel);
        if (ActionFactory.hasAction(path)) {
            MessageForwarder.receive(context);
        } else {
            // 未找到请求地址
            MessageResponse response = new MessageResponse(StatusCode.NOT_FOUND_ERROR);
            MessageForwarder.notify(context, response);
        }
        logger.info("{} ---------- messageReceived end ------------", operatorId);
    }

    private Map<String, String> formatReqParam(Map<String, List<String>> reqParams) {
        Map<String, String> bodyParams = new HashMap<String, String>();
        if (reqParams != null) {
            Set<String> keySet = reqParams.keySet();
            for (String k : keySet) {
                List<String> v = reqParams.get(k);
                if (v != null && v.size() > 0) {
                    bodyParams.put(k, v.get(0));
                }
            }
        }
        return bodyParams;
    }

}
