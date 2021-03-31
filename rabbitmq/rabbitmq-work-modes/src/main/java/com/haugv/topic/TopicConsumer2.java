package com.haugv.topic;

import com.haugv.util.ClientConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.获取连接，创建通道
        //2.通道创建队列
        //3.给队列绑定交换机
        //4.监听队列中的消息
        Connection connection = ClientConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("topic-queue",false,false,false,null);
        channel.queueBind("topic-queue","topic-exchange","rabbitmq.#");
        channel.basicConsume("topic-queue", true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"utf-8");
                System.out.println("TopicConsumer1接收到的消息："+message);
            }
        });
    }
}
