package com.vernon.netty.action;

import com.vernon.netty.core.Context;
import com.vernon.netty.core.MessageForwarder;
import com.vernon.netty.core.MessageResponse;
import com.vernon.netty.core.common.http.StatusCode;
import com.vernon.netty.core.common.util.JsonUtil;
import com.vernon.netty.core.web.action.Action;
import com.vernon.netty.domain.UserLogin;
import com.vernon.netty.service.UserService;
import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:05
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction implements Action {

    private UserService userService = new UserService();

    @Override
    public void handle(Context context) {

        MessageResponse response = null;
        // 获取参数 account, password
        String account = context.getParam("account");
        String password = context.getParam("password");

        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            response = new MessageResponse(StatusCode.PARAMS_ERROR);
            MessageForwarder.notify(context, response);
            return;
        }
        UserLogin user = userService.getUserLogin(account, password);
        if (user == null) {
            response = new MessageResponse(StatusCode.PARAMS_ERROR);
            MessageForwarder.notify(context, response);
            return;
        }
        response = new MessageResponse(StatusCode.DEFAULT);
        response.pushBody("user", user);
        MessageForwarder.notify(context, response);
    }
}
