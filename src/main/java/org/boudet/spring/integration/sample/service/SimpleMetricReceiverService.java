package org.boudet.spring.integration.sample.service;

import org.boudet.spring.integration.sample.model.Metric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleMetricReceiverService implements MetricReceiverService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void receive(Metric metric) {
        logger.debug("receiving metric : " + metric);
    }
}
