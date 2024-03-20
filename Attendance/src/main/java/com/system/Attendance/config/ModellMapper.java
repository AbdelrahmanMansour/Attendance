package com.system.Attendance.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModellMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
