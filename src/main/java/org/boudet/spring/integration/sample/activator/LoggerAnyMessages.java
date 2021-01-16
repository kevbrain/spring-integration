package org.boudet.spring.integration.sample.activator;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("loggerAnyMessage")
public class LoggerAnyMessages {
	
	@ServiceActivator
	public void handle(Message<?> message) {

		log.info(Thread.currentThread().getName()+" # "+(String) message.getPayload());
		log.info(Thread.currentThread().getName()+" # "+"[ID="+message.getHeaders().getId()+", TimeStamp:"+message.getHeaders().getTimestamp()+ "]");	
	}	

}
