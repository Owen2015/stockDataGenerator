package com.owen.stockDataGenerator;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

public class WebSocketClientUtil2 {

	private WebSocketClient client=new StandardWebSocketClient();
	
	private WebSocketHandler handler;
	public void init() {
		
	}
}
