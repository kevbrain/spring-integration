package org.boudet.spring.integration.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.config.EnableIntegration;

@Configuration
@EnableJpaRepositories("org.boudet.spring.integration.sample.repositories")
@EnableIntegration
public class Config {

}
