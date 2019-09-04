package com.fire.server.controller;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PayCallbackController {
    private static PayCallbackController payCallbackController = new PayCallbackController();
    public static Logger logger = LoggerFactory.getLogger(PayCallbackController.class);

    public static void payRouter(RoutingContext routingContext){
        HttpServerRequest request = routingContext.request();
//        HttpServerResponse response = routingContext.response();

        String baseUrl = "http://127.0.0.1:8080/AMS";
        String requestUrl = baseUrl + "/payment/callback/liujiu";
        String data = "order_no=123&userID=123&productID=123&appID=123&serverID=1&money=30&extension={pid:123}&status=1&time=123456789&sign=b853f5cdcbbe3e33834fd3cd0c44162c";

        System.out.println("start");
        for (int i= 0; i < 100; i++) {
            HttpURLConnection connection = null;
            String response = "1";
            try {
                System.out.println("Request url:" + requestUrl);
                // 创建连接
                URL url = new URL(requestUrl);
                connection = (HttpURLConnection) url.openConnection();

                connection.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(
                        connection.getOutputStream(), "UTF-8");

                // write parameters
                writer.write(data);
                writer.flush();

                // Get the response
                StringBuffer answer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    answer.append(line);
                }
                writer.close();
                reader.close();

                // Output the response
                response = answer.toString();
                System.out.println(response);
                // 断开连接
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("end");
        switch (request.uri()) {
            case "/pay/jinZhu":
                logger.info("/pay/jinZhu");
                break;
            case "/pay/quick":
                logger.info("/pay/quick");
                break;
            case "/pay/moLin":
                logger.info("/pay/moLin");
                break;
        }

        logger.info("123");
//        response.write("你");
//        routingContext.response().end();
        routingContext.response().end("Hello world! 我!");
    }
}
