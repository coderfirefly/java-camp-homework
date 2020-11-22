package me.collectmind.week03netty.gateway.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import me.collectmind.week03netty.gateway.outbound.httpclient4.HttpOutboundHandler;
import me.collectmind.week03netty.gateway.outbound.okhttp.OkhttpOutboundHandler;

/**
 * 不同的客户端实现该接口
 *
 * @see HttpOutboundHandler
 * @see OkhttpOutboundHandler
 *
 * Created by monica on 2020/11/14.
 */
public interface OutboundHandler {

    /**
     *
     * @param fullRequest
     * @param ctx
     */
    void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx);

}
