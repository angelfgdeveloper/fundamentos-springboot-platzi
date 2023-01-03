package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.properties.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.properties.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;

@Configuration
@EnableConfigurationProperties(UserPojo.class) // Representar los datos
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

  @Bean
  public DataSource dataSource() {
    // Conexion por medio de Bean
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:test");
    dataSourceBuilder.username("SA");
    dataSourceBuilder.password("");

    return dataSourceBuilder.build();
  }
  
}
