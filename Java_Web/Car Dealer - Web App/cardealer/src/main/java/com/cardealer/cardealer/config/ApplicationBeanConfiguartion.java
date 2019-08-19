package com.cardealer.cardealer.config;

import com.cardealer.cardealer.entities.SupplierParts;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguartion {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
