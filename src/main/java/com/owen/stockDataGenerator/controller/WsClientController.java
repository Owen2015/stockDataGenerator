package com.owen.stockDataGenerator.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.websocket.DeploymentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.owen.stockDataGenerator.service.WsClientService;

@Controller
public class WsClientController {
	
	@Autowired
	private WsClientService wsClientService;
	
	@RequestMapping(value="/connect",method=RequestMethod.POST)
	@ResponseBody
	public String connect(@RequestParam("uri")String uri) {
		try {
			wsClientService.connect(uri);
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.toString();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.toString();
		}
		return "success";
	}
	
	@RequestMapping(value="/sendText",method=RequestMethod.POST)
	@ResponseBody
	public String sendText(@RequestParam("text") String text) {
		try {
			wsClientService.sendText(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
		return "success";
	}
	
	@RequestMapping(value="/close",method=RequestMethod.POST)
	@ResponseBody
	public String close() {
		try {
			wsClientService.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.toString();
		}
		
		return "success";
	}

}
