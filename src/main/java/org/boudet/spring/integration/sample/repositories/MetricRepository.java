package org.boudet.spring.integration.sample.repositories;

import org.boudet.spring.integration.sample.model.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends CrudRepository<Metric, Integer>{

}
