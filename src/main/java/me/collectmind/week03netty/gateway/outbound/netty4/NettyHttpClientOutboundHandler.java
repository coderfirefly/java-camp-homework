package me.collectmind.week03netty.gateway.outbound.netty4;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端处理器
 *
 * @author monica
 */
public class NettyHttpClientOutboundHandler extends ChannelInboundHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(NettyHttpClientOutboundHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.error("channel active called.");
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse fullHttpResponse = (FullHttpResponse) msg;
        handleResponse(fullHttpResponse);
    }

    private void handleResponse(final FullHttpResponse endpointResponse) throws Exception {
//        FullHttpResponse response = null;
//        ByteBuf buf = response.content();
//        String result = buf.toString(CharsetUtil.UTF_8);
//
//        try {
//            // 处理body
//            ResponseBody responseBody = endpointResponse.();
//            if (responseBody == null) {
////                logger.error("request failed, responseBody is null, codec:{}", endpointResponse.code());
//            }
//            String responseBodyStr = responseBody == null ? "" : responseBody.string();
//            Long contentLength = responseBody == null ? 0 : responseBody.contentLength();
//            byte[] body = StringUtils.getBytesUtf8(responseBodyStr);
//
//            // 封装响应数据包，正常响应返回200，非正常均返回302
//            if (endpointResponse.status() == OK) {
//                response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
//                response.headers().set("Content-Type", "application/json");
//                response.headers().setInt("Content-Length", contentLength.intValue());
//            } else {
//                response = new DefaultFullHttpResponse(HTTP_1_1, FOUND, Unpooled.wrappedBuffer(body));
//                response.headers().set("Content-Type", "application/json");
//                response.headers().setInt("Content-Length", contentLength.intValue());
////                logger.error("request failed, response code: {}", endpointResponse.code());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
//        }
    }


}