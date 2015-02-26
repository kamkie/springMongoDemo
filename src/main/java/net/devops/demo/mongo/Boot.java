package net.devops.demo.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableMongoRepositories
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
