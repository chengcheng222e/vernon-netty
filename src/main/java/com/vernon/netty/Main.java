package com.vernon.netty;

import com.vernon.netty.core.common.http.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Vernon.Chen
 * Date: 13-11-19
 * Time: 上午8:59
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    // --------------------------------- field names ------------------------------
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.start();
        LOGGER.info("--------------------------- httpServer start ---------------------------");
    }

}
