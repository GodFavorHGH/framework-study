package com.haugv.publishsubcribe;

import com.haugv.util.ClientConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublishSubcribeConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接，创建通道
        //2、通道对象创建队列
        //3、给队列绑定交换机
        //4、监听队列中的消息
        Connection connection = ClientConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("publish-subcribe-queue",false,false,false,null);
        //参数1：队列名称；参数2：交换机名称
        channel.queueBind("publish-subcribe-queue","publish-subcribe-exchange",null);
        channel.basicConsume("publish-subcribe-queue", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Exchange:"+envelope.getExchange());
                System.out.println("RoutingKey:"+envelope.getRoutingKey());
                String message = new String(body, "utf-8");
                System.out.println("PublishSubcribeConsumer1接收到消息："+message);
            }
        });
    }
}
