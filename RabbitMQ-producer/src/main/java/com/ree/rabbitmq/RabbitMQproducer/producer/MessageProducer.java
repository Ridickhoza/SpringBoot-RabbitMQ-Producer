package com.ree.rabbitmq.RabbitMQproducer.producer;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ree.rabbitmq.RabbitMQproducer.config.RabbitMqConfig;

@Component
public class MessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message) {
		
		System.out.println(new Date());
		rabbitTemplate.convertAndSend(RabbitMqConfig.ROUTING_KEY,message);
		System.out.println("Is listener returned ::: "+ rabbitTemplate.isReturnListener());
		System.out.println(new Date());
		
	}
	
	
}
