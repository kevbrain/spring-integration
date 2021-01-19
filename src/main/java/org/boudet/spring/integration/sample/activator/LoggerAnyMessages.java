package org.boudet.spring.integration.sample.activator;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.boudet.spring.integration.sample.model.Metric;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("loggerAnyMessage")
public class LoggerAnyMessages {
	
	@ServiceActivator
	public void handle(Message<?> message) throws JsonGenerationException, JsonMappingException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (message.getPayload().getClass() == Metric.class) {
			Metric metric = (Metric) message.getPayload();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(metric);
			log.info(jsonInString);
			
		}
		log.info(Thread.currentThread().getName()+" # "+message.getClass());
		log.info(Thread.currentThread().getName()+" # "+message.getPayload());
		log.info(Thread.currentThread().getName()+" # "+message.getPayload().getClass());
		log.info(Thread.currentThread().getName()+" # "+message.getHeaders());
		/*
		log.info(Thread.currentThread().getName()+" # "+"[ID="+message.getHeaders().getId()
				+",DateReception ="+formatter.format(message.getHeaders().getTimestamp())
				+",Class="+message.getPayload().getClass()+ "]");
				*/	
	}	

}
