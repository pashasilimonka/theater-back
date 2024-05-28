package edu.sylymonka.theater.utils;/*
  @author   silim
  @project   theater
  @class  MapperConfig
  @version  1.0.0 
  @since 24.05.2024 - 18.24
*/

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
