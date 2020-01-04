package com.qin.pb;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.qin.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
	private static final String EXCHAGE_NAME = "test_exchange_fanout";

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection conn = ConnectionUtil.getConnection();
		Channel channel = conn.createChannel();
		// ����������
		channel.exchangeDeclare(EXCHAGE_NAME, "fanout");
		// ������Ϣ
		String msg = "hello qin ! ";
		String routingKey="error";
		channel.basicPublish(EXCHAGE_NAME, routingKey, null, msg.getBytes());
		System.out.println("������Ϣ=" + msg);
		channel.close();
		conn.close();
	}
}
