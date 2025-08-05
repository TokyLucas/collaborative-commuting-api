package itu.mbds.collaborativecommutingapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import itu.mbds.collaborativecommutingapi.dtos.P2PPositionMessage;

@Controller
public class WebSocketP2PController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/position")
    public void broadcastPosition(P2PPositionMessage msg) {
        String destination = "/topic/peer-" + msg.getRideId();
        messagingTemplate.convertAndSend(destination, msg);
    }
}
