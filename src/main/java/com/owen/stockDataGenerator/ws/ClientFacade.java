package com.owen.stockDataGenerator.ws;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Resource;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientFacade {

	private WebSocketContainer container=ContainerProvider.getWebSocketContainer();
	
	private Session session;
	
	public void connect(String uri) throws DeploymentException, IOException, URISyntaxException {
		session=container.connectToServer(Client.class, new URI(uri));
		
	}
	
	public void sendText(String text) throws IOException {
		session.getBasicRemote().sendText(text);
	}
	
	public void close() throws IOException {
		session.close();
	}
	
}
