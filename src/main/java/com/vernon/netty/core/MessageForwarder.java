package com.vernon.netty.core;

import com.vernon.netty.core.common.http.HttpMessageSender;
import com.vernon.netty.core.common.http.StatusCode;
import com.vernon.netty.core.web.action.Action;
import com.vernon.netty.core.web.action.ActionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageForwarder {

    private static Logger logger = LoggerFactory.getLogger(MessageForwarder.class);
    private static ExecutorService notifyPool = Executors.newFixedThreadPool(4);

    private MessageForwarder() {
    }

    /**
     * 接收消息
     *
     * @param context
     */
    public static void receive(Context context) {
        int operatorId = context.getOperatorId();
        try {
            logger.info("operatorId={}, channelId={},接收消息receive msg: {}",
                    operatorId, context.getChannelId(), context.toString());
            Action cmd = ActionFactory.getAction(context);
            cmd.handle(context);
        } catch (Exception e) {
            logger.error("{} 执行handle出现异常context:{}", operatorId, context, e);
            MessageResponse msgResponse = new MessageResponse(StatusCode.OPERATOR_ERROR);
            MessageForwarder.notify(context, msgResponse);
        }
    }

    /**
     * 通知
     *
     * @param context
     * @param response
     */
    public static void notify(final Context context, final MessageResponse response) {
        notifyPool.submit(new Runnable() {
            @Override
            public void run() {
                logger.info("operatorId={}, channelId={}, 响应结果notify msg : {}",
                        context.getOperatorId(), context.getChannelId(), response.toMap());
                // 这里默认为是 Http 发送
                HttpMessageSender messageSender = new HttpMessageSender();
                messageSender.handle(context, response);
            }
        });
    }

}
