package com.gmail.deamon999.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "com.gmail.deamon999.scheduler.repository")
@EnableMongoRepositories(value = "com.gmail.deamon999.scheduler.repository_mongo")
public class SchedulerApplication implements ApplicationRunner {
    Logger log = LoggerFactory.getLogger(SchedulerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}

