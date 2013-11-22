package com.vernon.netty.core.web.action;

import com.vernon.netty.action.LoginAction;
import com.vernon.netty.core.Context;
import com.vernon.netty.core.MessageForwarder;
import com.vernon.netty.core.MessageResponse;
import com.vernon.netty.core.common.http.StatusCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:03
 * To change this template use File | Settings | File Templates.
 */
public class ActionFactory {

    static Map<String, Action> CMDS = new HashMap<String, Action>() ;


    private static final String CMD_USER_LOGIN = "/user/login";

    static {
        CMDS.put(CMD_USER_LOGIN, new LoginAction());
    }

    /**
     * 是否含有该请求
     *
     * @param path
     * @return
     */
    public static boolean hasAction(String path) {
        return   CMDS.containsKey(path);
    }

    /**
     * 获取 Action
     *
     * @param context
     * @return
     */
    public static Action getAction(Context context) {
        String path = context.getPath();
        return getAction(path);
    }

    /**
     * 获取 Action
     *
     * @param path
     * @return
     */
    public static Action getAction(String path) {
        Action action = CMDS.get(path);
        if (action == null) {
            action = new Action() {
                @Override
                public void handle(Context context) {

                }
            };
        }
        return action;
    }

}
