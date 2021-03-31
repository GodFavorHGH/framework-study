package com.haugv.routing;

import com.haugv.util.ClientConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RoutingConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接，创建通道
        //2、创建队列
        //3、绑定交换机
        //4、监听队列中的消息
        Connection connection = ClientConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("routing-queue",false,false,false,null);
        channel.queueBind("routing-queue","routing-exchange","routing");
        channel.basicConsume("routing-queue", true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("RoutingKey:"+envelope.getRoutingKey());
                System.out.println("Exchange:"+envelope.getExchange());
                String message = new String(body,"utf-8");
                System.out.println("RoutingConsumer1接收到的消息:"+message);
            }
        });
    }
}
