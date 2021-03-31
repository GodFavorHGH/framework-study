package com.haugv.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author haugv
 * @description
 * @date 2021/3/28-12:34 上午
 */
public class MqUtil {
    private static ConnectionFactory connectionFactory;

    public static ConnectionFactory getConnectionFactory(){
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("127.0.0.1");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
            connectionFactory.setVirtualHost("/");
        }
        return connectionFactory;
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        return getConnectionFactory().newConnection();
    }
}
