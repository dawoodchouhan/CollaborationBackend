package com.niit.collaborationbackend.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.niit.collaborationbackend.model.Message;
import com.niit.collaborationbackend.model.OutputMessage;

@Controller
public class ChatForumController {

private static final Logger Logger = LoggerFactory.getLogger(ChatController.class);
	
	@MessageMapping("/chat_forum")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message) {
		Logger.debug("Calling the method sendMessage");
		Logger.debug(" Message : ", message.getMessage());
		
		Logger.debug(" Message ID : ", message.getId());
		
		return new OutputMessage(message , new Date());
	}
}
