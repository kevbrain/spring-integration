package org.boudet.spring.integration.sample.filter;

import java.util.Date;


import org.boudet.spring.integration.sample.model.Metric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class MessageFilterImpl implements MessageSelector {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean accept(Message<?> message) {
        if (message.getPayload().getClass() != Metric.class) {
            return false;
        }
        Metric metric = (Metric) message.getPayload();
        return metric.getDatetime().before(new Date());
    }
	
}
