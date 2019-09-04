package com.fire.server;

import com.fire.server.network.VertxHttpServerVerticle;
import com.fire.server.network.VertxTcpServerVerticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    private VertxTcpServerVerticle vertxTcpServerVerticle;
    @Autowired
    private VertxHttpServerVerticle vertxHttpServerVerticle;

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(vertxTcpServerVerticle);
        Vertx.vertx().deployVerticle(vertxHttpServerVerticle);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}