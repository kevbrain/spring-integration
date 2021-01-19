package org.boudet.spring.integration.sample.service.impl;

import java.util.List;

import org.boudet.spring.integration.sample.model.Metric;
import org.boudet.spring.integration.sample.repositories.MetricRepository;
import org.boudet.spring.integration.sample.service.MetricSenderService;
import org.boudet.spring.integration.sample.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsServiceImpl implements MetricsService {
	
	@Autowired
	private MetricRepository repo;

	@Override
	public Metric saveMetric(Metric metric) {
		return repo.save(metric);
	}

	@Override
	public Iterable<Metric> findall() {
		return repo.findAll();
	}


	

}
