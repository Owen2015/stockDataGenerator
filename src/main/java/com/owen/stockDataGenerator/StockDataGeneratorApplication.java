package com.owen.stockDataGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.owen.stockDataGenerator.utils.JsonUtil;
import com.owen.stockDataGenerator.ws.Client;
import com.owen.stockDataGenerator.ws.ClientFacade;
import com.owen.stockDataGenerator.ws.Message;

@SpringBootApplication
public class StockDataGeneratorApplication {

	//@Value("${websocket.server}")
	private static String uri;
	
	public static void main(String[] args)  { 
		SpringApplication.run(StockDataGeneratorApplication.class, args);
/*		WebSocketClientWrapper client=new WebSocketClientWrapper();
		client.send("test");*/
		
/*		 WebSocketContainer container = ContainerProvider.getWebSocketContainer(); // 获取WebSocket连接器，其中具体实现可以参照websocket-api.jar的源码,Class.forName("org.apache.tomcat.websocket.WsWebSocketContainer");
		 String uri = "ws://localhost:3000/v2/ws";
		 Session session = container.connectToServer(Client.class, new URI(uri)); // 连接会话
		 session.getBasicRemote().sendText("123132132131"); // 发送文本消息
		 session.getBasicRemote().sendText("4564546");
		 session.close();*/
		
		
/*		ClientFacade client=new ClientFacade();
		uri="ws://localhost:3000/receiver";
		client.connect(uri);
		Date d;
		SimpleDateFormat smt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(true) {		
			d=new Date();
			client.sendText(smt.format(d));
			Thread.sleep(1000L);
		}*/
		sendDate();
	}
	public static void sendDate() {
		ClientFacade client=new ClientFacade();
		//uri="ws://localhost:3000/receiver";
		uri="ws://localhost:3000/receiver";
		try {
			client.connect(uri);
			Date d;
			SimpleDateFormat smt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while(true) {		
				d=new Date();
				Message msg=new Message();
				msg.setTopic("test");
				msg.setContent(smt.format(d));
				client.sendText(JsonUtil.toJson(msg));
				Thread.sleep(20000L);
			}
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
