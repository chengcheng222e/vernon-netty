package com.vernon.netty.core.common.http;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Vernon.Chen
 * Date: 13-11-20
 * Time: 下午5:31
 * To change this template use File | Settings | File Templates.
 */
public class HttpServer {
    private static final int PORT = 8082;
    private ChannelFactory channelFactory;
    private ServerBootstrap bootstrap;
    private ChannelGroup channelGroup = new DefaultChannelGroup("nio-server");

    public void start() {
        this.channelFactory = new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool());
        bootstrap = new ServerBootstrap(channelFactory);

        bootstrap.setPipelineFactory(new HttpServerPipelineFactory());

        Channel serverChannel = bootstrap.bind(new InetSocketAddress(PORT));
        channelGroup.add(serverChannel);
    }
}
