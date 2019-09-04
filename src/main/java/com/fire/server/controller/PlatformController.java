package com.fire.server.controller;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class PlatformController {
    private static PlatformController platformController = new PlatformController();
    public static Logger logger = LoggerFactory.getLogger(PlatformController.class);

    public static void apiRouter(RoutingContext routingContext){
        HttpServerResponse response = routingContext.response();
        logger.info("123");
//        response.write("你");
//        routingContext.response().end();
        routingContext.response().end("Hello world! 我!");
    }
}
