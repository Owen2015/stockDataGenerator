package com.owen.stockDataGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.websocket.DeploymentException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.owen.stockDataGenerator.biz.market.MarketRunner;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;
import com.owen.stockDataGenerator.utils.JsonUtil;
import com.owen.stockDataGenerator.ws.ClientFacade;

@Component
@SpringBootApplication
public class StockDataGeneratorApplication {

	public static void main(String[] args) throws Exception  { 
		SpringApplication.run(StockDataGeneratorApplication.class, args);
		sendDate();
	}
	private static void sendDate() throws Exception {
		List<TradeBoardElement> tradeBoard=new ArrayList<TradeBoardElement>();
		Thread market=new Thread(new MarketRunner(tradeBoard));
		market.start();
		ClientFacade client=new ClientFacade();
		String uri=getUri();
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
	private static String getUri() throws IOException {
		Resource resource = new ClassPathResource("application.properties");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		Properties prop=new Properties();;
		prop.load(br);
		return prop.getProperty("websocket.server");
	}
}
