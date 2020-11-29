package org.boudet.spring.integration.sample.service;

import org.boudet.spring.integration.sample.model.Metric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HumidityMetricReceiverService implements MetricReceiverService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void receive(Metric metric) {
        logger.debug("received a humidity metric");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
