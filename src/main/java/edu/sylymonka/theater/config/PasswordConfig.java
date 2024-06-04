package edu.sylymonka.theater.config;/*
  @author   silim
  @project   theater
  @class  PasswordConfig
  @version  1.0.0 
  @since 03.06.2024 - 18.34
*/

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
