package com.owen.stockDataGenerator;

/*import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;

import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Value;

public class WebSocketClientWrapper {
	private WebSocketClient client;
	
	public WebSocketClientWrapper() throws URISyntaxException {
		init();
	}
	public WebSocketClientWrapper getInstance() throws URISyntaxException {
		if(clientUtil==null) {
			return new WebSocketClientWrapper();
		}else
			return clientUtil;
	}
	
	@Value("${websocket.server}") 
	private String websocketServer;
	
	
	public void init() throws URISyntaxException {
		client = new WebSocketClient(new URI(websocketServer), new Draft_17()) {

			@Override
			public void onOpen(ServerHandshake arg0) {
				System.out.println("打开链接");
			}

			@Override
			public void onMessage(String arg0) {
				System.out.println("收到消息" + arg0);
			}

			@Override
			public void onError(Exception arg0) {
				arg0.printStackTrace();
				System.out.println("发生错误已关闭");
			}

			@Override
			public void onClose(int arg0, String arg1, boolean arg2) {
				System.out.println("链接已关闭");
			}

			@Override
			public void onMessage(ByteBuffer bytes) {
				try {
					System.out.println(new String(bytes.array(), "utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

		};
		client.connect();
	}

	public void send(byte[] bytes) {
		client.send(bytes);
	}
	
	public void send(String text) {
		client.send(text);
	}
	public void close() {
		client.close();
	}
		public static void main(String[] args)
	throws URISyntaxException, NotYetConnectedException, UnsupportedEncodingException {
client = new WebSocketClient(new URI(websocketServer), new Draft_17()) {

	@Override
	public void onOpen(ServerHandshake arg0) {
		System.out.println("打开链接");
	}

	@Override
	public void onMessage(String arg0) {
		System.out.println("收到消息" + arg0);
	}

	@Override
	public void onError(Exception arg0) {
		arg0.printStackTrace();
		System.out.println("发生错误已关闭");
	}

	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		System.out.println("链接已关闭");
	}

	@Override
	public void onMessage(ByteBuffer bytes) {
		try {
			System.out.println(new String(bytes.array(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

};

client.connect();

while (!client.getReadyState().equals(READYSTATE.OPEN)) {
	System.out.println("还没有打开");
}
System.out.println("打开了");
send("hello world".getBytes("utf-8"));
client.send("hello world");
}
}
*/