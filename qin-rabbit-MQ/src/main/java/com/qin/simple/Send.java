package com.qin.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.qin.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
	private static final String QUEUE_NAME = "test_simple_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		// ��ȡһ������
		Connection conn = ConnectionUtil.getConnection();
		// ����һ��ͨ��
		Channel channel = conn.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String msg = "Hello Simple 0001! ";
		channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		System.out.println("---send-msg=" + msg);
		channel.close();
		conn.close();

	}

}
