package org.boudet.spring.integration.sample.service;


import org.boudet.spring.integration.sample.model.Metric;

public interface MetricSenderService {

    void send(Metric metric);
       
    Metric saveMetric(Metric metric);
     

}
