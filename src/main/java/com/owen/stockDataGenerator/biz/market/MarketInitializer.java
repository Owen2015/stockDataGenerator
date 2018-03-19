package com.owen.stockDataGenerator.biz.market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.owen.stockDataGenerator.model.market.Investor;
import com.owen.stockDataGenerator.model.market.Market;
import com.owen.stockDataGenerator.model.market.Stock;

public class MarketInitializer {

	public static Market init(Market market) {
		market=new Market();
		market=initStocks(market);
		market=initInvestor(market);
		return market;
	}
	
	private static Market initStocks(Market market) {
		List<Stock> stocks=new ArrayList<Stock>();
		Stock s1=new Stock();
		s1.setId(0L);
		s1.setName("gu0");
		s1.setPrice(100D);
		stocks.add(s1);
		
		Stock s2=new Stock();
		s2.setId(1L);
		s2.setName("gu1");
		s2.setPrice(200D);
		stocks.add(s2);
		
		Stock s3=new Stock();
		s3.setId(2L);
		s3.setName("gu2");
		s3.setPrice(300D);
		stocks.add(s3);
		
		Stock s4=new Stock();
		s4.setId(3L);
		s4.setName("gu3");
		s4.setPrice(400D);
		stocks.add(s4);
		
		Stock s5=new Stock();
		s5.setId(4L);
		s5.setName("gu4");
		s5.setPrice(500D);
		stocks.add(s5);
		
		market.setStocks(stocks);
		return market;
	}
	
	private static Market initInvestor(Market market) {
		List<Investor> investors=new ArrayList<Investor>();
		Investor v1=new Investor();
		v1.setId(0L);
		v1.setName("zhangsan");
		
		Map<Long,Long> v1share=new HashMap<Long,Long>();
		v1share.put(0L, 2000L);
		v1share.put(1L, 2000L);
		v1share.put(2L, 2000L);
		v1share.put(3L, 2000L);
		v1share.put(4L, 2000L);
		v1.setStocks(v1share);
		investors.add(v1);
		
		Investor v2=new Investor();
		v2.setId(1L);
		v2.setName("lisi");
		
		Map<Long,Long> v2share=new HashMap<Long,Long>();
		v2share.put(0L, 2000L);
		v2share.put(1L, 2000L);
		v2share.put(2L, 2000L);
		v2share.put(3L, 2000L);
		v2share.put(4L, 2000L);
		v2.setStocks(v2share);
		investors.add(v2);
		
		Investor v3=new Investor();
		v3.setId(2L);
		v3.setName("wangwu");
		
		Map<Long,Long> v3share=new HashMap<Long,Long>();
		v3share.put(0L, 2000L);
		v3share.put(1L, 2000L);
		v3share.put(2L, 2000L);
		v3share.put(3L, 2000L);
		v3share.put(4L, 2000L);
		v3.setStocks(v3share);
		investors.add(v3);

		Investor v4=new Investor();
		v4.setId(3L);
		v4.setName("zhaoliu");
		Map<Long,Long> v4share=new HashMap<Long,Long>();
		v4share.put(0L, 2000L);
		v4share.put(1L, 2000L);
		v4share.put(2L, 2000L);
		v4share.put(3L, 2000L);
		v4share.put(4L, 2000L);
		v4.setStocks(v4share);
		investors.add(v4);
		
		Investor v5=new Investor();
		v5.setId(4L);
		v5.setName("zhangsan");
		Map<Long,Long> v5share=new HashMap<Long,Long>();
		v5share.put(0L, 2000L);
		v5share.put(1L, 2000L);
		v5share.put(2L, 2000L);
		v5share.put(3L, 2000L);
		v5share.put(4L, 2000L);
		v5.setStocks(v5share);
		investors.add(v5);
		
		market.setInvestors(investors);
		return market;
	}
	
}
