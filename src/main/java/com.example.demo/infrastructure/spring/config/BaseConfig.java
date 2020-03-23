package com.example.demo.infrastructure.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Slf4j
public class BaseConfig {

    @Bean
    public CommandLineRunner commandLineRunnerLocal(ApplicationContext ctx) {
        return args -> {
            log.info("Let's inspect the beans provided by Spring boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName: beanNames) {
                log.info("init bean=" + beanName);
            }
        };
    }

}
