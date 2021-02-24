package org.boudet.spring.integration.sample.activator;

import org.boudet.spring.integration.sample.model.Metric;
import org.boudet.spring.integration.sample.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MetricInboundEnpoint {

	@Autowired
    MetricsService metricService;
	
	public Message<?> getAllMetrics(Message<?> msg) {
		Iterable<Metric> metricsList = metricService.findall();
	    return MessageBuilder.withPayload(metricsList).copyHeadersIfAbsent(msg.getHeaders())
	        .setHeader("http_statusCode", HttpStatus.OK).build();
	  }
	
}
