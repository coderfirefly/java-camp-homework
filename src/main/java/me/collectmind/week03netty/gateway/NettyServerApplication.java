package me.collectmind.week03netty.gateway;

import me.collectmind.week03netty.gateway.inbound.HttpInboundServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Netty网关应用
 *
 * 将对网关的请求转发给后端服务
 *   http://localhost:8888/test  ==> gateway API
 *   http://localhost:8808/test  ==> backend service
 *
 * @author kimmking
 */
public class NettyServerApplication {
    private final static Logger logger = LoggerFactory.getLogger(NettyServerApplication.class);
    private final static String GATEWAY_NAME = "NIOGateway";
    private final static String GATEWAY_VERSION = "1.0.0";
    
    public static void main(String[] args) {
        // 网关代理的后端服务地址
        String proxyServer = System.getProperty("proxyServer","http://localhost:8808");

        // 网关服务的端口号
        String proxyPort = System.getProperty("proxyPort","8888");
        int port = Integer.parseInt(proxyPort);

        logger.info("{} {} starting...", GATEWAY_NAME, GATEWAY_VERSION);
        // 定义一个网关服务器
        HttpInboundServer server = new HttpInboundServer(port, proxyServer);
        logger.info( "{} {} started at http://localhost: {} for server:{}",
                GATEWAY_NAME, GATEWAY_VERSION, port, proxyServer);

        try {
            server.run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
