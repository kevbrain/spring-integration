package org.boudet.spring.integration.sample.service;


import java.util.List;

import org.boudet.spring.integration.sample.model.Metric;

public interface MetricsService {
       
    Metric saveMetric(Metric metric);
     
    Iterable<Metric> findall();

}
