package org.boudet.spring.integration.sample.service;

import org.boudet.spring.integration.sample.model.Metric;

public interface MetricReceiverService {
    void receive(Metric metric);

}
