package org.boudet.spring.integration.sample.service;

import org.boudet.spring.integration.sample.model.Dovreq;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("dovReqReceiverServiceActivator")
public class SimpleLoggerDovreqReceiver {
	
	@ServiceActivator
	public void handle(Message<Dovreq> message) {
		
		System.out.println(Thread.currentThread().getName()+" ---> DovReq message Received = "+message);
		
			

	}	

}
