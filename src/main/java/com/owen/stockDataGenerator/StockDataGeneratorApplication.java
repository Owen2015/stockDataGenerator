package com.owen.stockDataGenerator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.DeploymentException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.owen.stockDataGenerator.biz.market.MarketRunner;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;
import com.owen.stockDataGenerator.utils.JsonUtil;
import com.owen.stockDataGenerator.ws.ClientFacade;


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
			while(true) {		
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
