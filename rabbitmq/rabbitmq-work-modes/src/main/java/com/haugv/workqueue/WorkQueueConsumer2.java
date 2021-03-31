package com.haugv.workqueue;

import com.haugv.util.ClientConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WorkQueueConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ClientConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.basicConsume("",new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Exchange:"+envelope.getExchange());
                System.out.println("RoutingKey:"+envelope.getRoutingKey());
                String message = new String(body, "utf-8");
                System.out.println(message);
            }
        });
    }
}
