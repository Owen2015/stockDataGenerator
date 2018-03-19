package com.owen.stockDataGenerator.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.websocket.DeploymentException;

public interface WsClientService {

	public void connect(String uri) throws DeploymentException, IOException, URISyntaxException;
	public void sendText(String text) throws IOException;
	public void close() throws IOException;
}
