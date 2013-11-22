package com.vernon.netty.core;

import com.vernon.netty.core.Context;
import com.vernon.netty.core.MessageResponse;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM10:09
 * To change this template use File | Settings | File Templates.
 */
public interface MessageSender {
    boolean handle(Context context, MessageResponse response);
}
