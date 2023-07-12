package com.ocakarda.springcoredemo.config;

import com.ocakarda.springcoredemo.common.Coach;
import com.ocakarda.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
