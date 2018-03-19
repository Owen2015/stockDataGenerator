package com.owen.stockDataGenerator.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.websocket.DeploymentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.stockDataGenerator.service.WsClientService;
import com.owen.stockDataGenerator.ws.ClientFacade;

@Service
public class WsClientServiceImpl implements WsClientService{

	@Autowired
	private ClientFacade client;
	
	@Override
	public void connect(String uri) throws DeploymentException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		System.out.println("connected, "+uri);
		client.connect(uri);
	}

	@Override
	public void sendText(String text) throws IOException {
		System.out.println("received, "+text);
		// TODO Auto-generated method stub
		client.sendText(text);
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("closed ");
		client.close();
	}

}
