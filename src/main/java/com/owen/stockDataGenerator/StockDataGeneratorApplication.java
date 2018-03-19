package com.owen.stockDataGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.owen.stockDataGenerator.biz.market.MarketRunner;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;
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
		sendDate();
	}
	public static void sendDate() {
		List<TradeBoardElement> tradeBoard=new ArrayList<TradeBoardElement>();
		Thread market=new Thread(new MarketRunner(tradeBoard));
		market.start();
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
				client.sendText(JsonUtil.toJson(tradeBoard));
				Thread.sleep(1000L);
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
