package com.akudama.books.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
