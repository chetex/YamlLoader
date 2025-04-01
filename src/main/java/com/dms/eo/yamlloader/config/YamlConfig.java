package com.dms.eo.yamlloader.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;

@Configuration
public class YamlConfig {

    @Value("classpath:yaml/data.yaml")
    private Resource yamlResource;

    @Bean
    public Resource yamlResource() {
        return yamlResource;
    }
}
