package com.fire.server.network;

import com.fire.server.handler.DecodeHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.NetSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VertxTcpServerVerticle extends AbstractVerticle {
    @Value("${port.tcp}")
    private int tcpPort;
    @Override
    public void start() throws Exception {
        System.out.println("tcpPort:" + tcpPort);
        NetServerOptions options = new NetServerOptions().setPort(tcpPort);
        NetServer server = vertx.createNetServer(options);
        server.connectHandler(this::handle);
        server.close(result -> {
            if(result.succeeded()){
                //TCP server fully closed
                System.out.println("server close succeeded.");
            }else {
                System.out.println("server status: " + result.result().toString());
            }
        });
        server.listen();
    }

    //handle stream
    public void handle(NetSocket socket) {
        System.out.println("Incoming connection!");
        socket.handler(new DecodeHandler(res -> {
            if (res.failed()) {
                // could not parse the message properly
                System.out.println(res.cause());
                return;
            }
            System.out.println(res.result());
        }));

        socket.endHandler(v -> {
        });
    }
}