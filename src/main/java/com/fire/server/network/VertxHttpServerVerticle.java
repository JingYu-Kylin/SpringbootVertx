package com.fire.server.network;

import com.fire.server.controller.GmCommandController;
import com.fire.server.controller.PayCallbackController;
import com.fire.server.controller.PlatformController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VertxHttpServerVerticle extends AbstractVerticle {
    @Value("${port.http}")
    private int httpPort;
    @Override
    public void start() throws Exception {
        System.out.println("HttpPort:" + httpPort);
        HttpServerOptions options = new HttpServerOptions().setPort(httpPort);
        HttpServer httpServer = vertx.createHttpServer(options);

        //web路由器
        Router router = Router.router(vertx);
        router.route(HttpMethod.POST,"/gm/*").handler(GmCommandController::gmRouter);
        router.route(HttpMethod.POST,"/api/*").handler(PlatformController::apiRouter);
        router.route("/pay/*").handler(PayCallbackController::payRouter);

        httpServer.requestHandler(router);
        httpServer.listen();
    }
}
