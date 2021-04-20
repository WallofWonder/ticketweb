package com.dogeyes.zyf.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ZYF
 * @create 2021-4-20 14:53
 */
@Log4j2
@Component
@ServerEndpoint("/bindingRecord")
public class MyWebSocket {

    private Session session;

    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        log.info("【新建连接】，连接总数:" + webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        log.info("【断开连接】，连接总数:" + webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【收到】，客户端的信息:" + message + "，连接总数:" + webSockets.size());
    }

    public void sendMessage(String message){
        log.info("【广播发送】，信息:" + message + "总连接数:{}" + webSockets.size());
        for (MyWebSocket webSocket : webSockets) {
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.info("【广播发送】，信息异常:" + e.fillInStackTrace());
            }
        }
    }
}
