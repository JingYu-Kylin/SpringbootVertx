package com.fire.server.controller;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class GmCommandController {
    private static GmCommandController gmCommandController = new GmCommandController();
    public static Logger logger = LoggerFactory.getLogger(GmCommandController.class);

    public static void gmRouter(RoutingContext routingContext){
        HttpServerRequest request = routingContext.request();
        HttpServerResponse response = routingContext.response();
        switch (request.uri()) {
            case "/gm/sendCmd":
                routingContext.response().end("/gm/sendCmd");
                logger.info("/gm/sendCmd");
                break;
            case "/gm/sendGift":
                routingContext.response().end("/gm/sendGift");
                logger.info("/gm/sendGift");
                break;
            case "/gm/sendEmail":
                routingContext.response().end("/gm/sendEmail");
                logger.info("/gm/sendEmail");
                break;
        }
//        response.write("你");
//        routingContext.response().end();

    }
}
