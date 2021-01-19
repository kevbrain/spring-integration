package org.boudet.spring.integration.sample.controller;

import java.util.List;

import org.boudet.spring.integration.sample.model.Dovreq;
import org.boudet.spring.integration.sample.model.Metric;
import org.boudet.spring.integration.sample.service.DovReqReceiver;
import org.boudet.spring.integration.sample.service.MetricSenderService;
import org.boudet.spring.integration.sample.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    @Autowired
    MetricSenderService metricSenderService;
    
    @Autowired
    MetricsService metricService;
    
    @Autowired
    DovReqReceiver dovreqreceiverService;

    
    @PostMapping(path = "/metric")
    void metric(@RequestBody Metric metric) {
    	metricSenderService.send(metric);
    }
    
    
    @PostMapping(path = "/dovreq")
    void receiveDovReq (@RequestBody Dovreq msg) {
    	dovreqreceiverService.receive(msg);
    }
    
    @ResponseBody
    @GetMapping("/metric/list")
    public Iterable<Metric> getAllMetrics() {
        return metricService.findall();
    }
}
