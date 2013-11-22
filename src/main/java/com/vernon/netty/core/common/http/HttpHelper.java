package com.vernon.netty.core.common.http;

import static org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Values;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM10:15
 * To change this template use File | Settings | File Templates.
 */
public class HttpHelper {

    private Logger logger = LoggerFactory.getLogger(HttpHelper.class);
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String FORMAT_GMT_DATE = "EEE, d MMM yyyy HH:mm:ss 'GMT'";

    /**
     * 发送
     *
     * @param channel
     * @param message
     */
    public static void sendOK(Channel channel, String message) {
        DefaultHttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK);

        response.setHeader(Names.CONTENT_TYPE, "application/json; charset=UTF-8");

        ChannelBuffer buffer = ChannelBuffers.wrappedBuffer(message.getBytes(UTF8));
        response.setContent(buffer);

        String gmtDate = getGMTDate();
        response.setHeader(Names.DATE, gmtDate);
        response.setHeader(Names.EXPIRES, gmtDate);
        response.setHeader(Names.CONNECTION, Values.KEEP_ALIVE);
        response.setHeader(Names.CONTENT_LENGTH, buffer.readableBytes());
        channel.write(response);
    }

    /**
     * 获取时间
     *
     * @return
     */
    private static String getGMTDate() {
        SimpleDateFormat formater = new SimpleDateFormat(FORMAT_GMT_DATE, Locale.US);
        formater.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formater.format(new Date());
    }
}
