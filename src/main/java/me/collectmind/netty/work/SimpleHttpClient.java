package me.collectmind.netty.work;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 作业2：写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801
 * <p>
 * Created by monica on 2020/11/6.
 */
public class SimpleHttpClient {
    private final static Logger logger = LoggerFactory.getLogger(SimpleHttpClient.class);

    private OkHttpClient client;

    private Request request;

    public SimpleHttpClient(long timeout, String url) {
        this.client = buildClient(timeout);
        this.request = buildRequest(url);
    }

    public static void main(String[] args) {
        try {
            SimpleHttpClient simpleHttpClient = new SimpleHttpClient(2000, "http://localhost:8804/test");
            simpleHttpClient.doRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建客户端
     * @param timeout
     * @return
     */
    private OkHttpClient buildClient(long timeout) {
        return new OkHttpClient().newBuilder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .writeTimeout(timeout, TimeUnit.MILLISECONDS)
                .build();
    }

    /**
     * 创建请求体
     * @param url
     * @return
     */
    private Request buildRequest(String url) {
        return new Request.Builder().url(url).get().build();
    }

    /**
     * 处理请求
     */
    public void doRequest() {
        try {
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    logger.error("client request failed", e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        if (response.code() == 200) {
                            ResponseBody body = response.body();
                            if (body == null) {
                                logger.error("request failed, request body is null");
                                return;
                            }

                            String result = body.string();
                            logger.error("code:200, request success ? {}", result.contains("hello, netty"));

                        } else {
                            logger.error("request failed, response code: {}", response.code());
                        }
                    } catch (Exception e) {
                        logger.error("response handle callback encountered exception:", e);
                    }
                }
            });
        } catch (Exception e) {
            logger.error("client do request encountered error", e);
        }
    }
}
