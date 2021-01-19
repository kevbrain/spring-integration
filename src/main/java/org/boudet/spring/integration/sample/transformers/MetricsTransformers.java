package org.boudet.spring.integration.sample.transformers;

import java.io.IOException;

import org.boudet.spring.integration.sample.model.Metric;
import org.boudet.spring.integration.sample.service.MetricsService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component("metricsTransformers")
public class MetricsTransformers {

	@Autowired
	private MetricsService metricsService;
	
	
	@Transformer
	public Message<Metric> transformKafkaMetricToMetric(Message<String> message) throws JsonParseException, JsonMappingException, IOException {
		log.info(message.getPayload());
		ObjectMapper mapper = new ObjectMapper();
		Metric newMetric = mapper.readValue(message.getPayload(), Metric.class);
		newMetric.setMetric_offset(Math.toIntExact((Long)message.getHeaders().get("kafka_offset")));
		metricsService.saveMetric(newMetric);
		return MessageBuilder.withPayload(newMetric)
				.copyHeaders(message.getHeaders())
				.build();
		
	}
	@Transformer
	public Message<String> transformMetricToKafkaMessage(Message<Metric> message) throws JsonGenerationException, JsonMappingException, IOException {
		log.info(message.getPayload().toString());
		ObjectMapper mapper = new ObjectMapper();
		String metricAsjsonString = mapper.writeValueAsString(message.getPayload());
		return MessageBuilder.withPayload(metricAsjsonString)
				.copyHeaders(message.getHeaders())
				.build();
	}
}
