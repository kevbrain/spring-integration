package org.boudet.spring.integration.sample.service;

import org.boudet.spring.integration.sample.model.Dovreq;


public interface DovReqReceiver {
	
	void receive(Dovreq dovreq);

}
