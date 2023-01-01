package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.properties.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.properties.MyBeanWithPropertiesImplement;

@Configuration
public class GeneralConfiguration {

  @Value("${value.name}")
  private String name;

  @Value("${value.lastname}")
  private String lastname;

  @Value("${value.random}")
  private String random;

  @Bean
  public MyBeanWithProperties function() {
    return new MyBeanWithPropertiesImplement(name, lastname);
  }
  
}
