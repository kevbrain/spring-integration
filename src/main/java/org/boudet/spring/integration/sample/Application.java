package org.boudet.spring.integration.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
//@ImportResource({"classpath*:*-context.xml"})
@ImportResource({"file:${metrics.context.classpath}*-context.xml"})
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


}