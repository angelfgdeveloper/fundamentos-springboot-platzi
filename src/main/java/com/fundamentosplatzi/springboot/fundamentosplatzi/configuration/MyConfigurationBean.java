package com.fundamentosplatzi.springboot.fundamentosplatzi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean2Implements;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithDependencyImplement;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyOperation;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyOperationImplement;

@Configuration
public class MyConfigurationBean {

  @Bean
  public MyBean beanOperation() {
    // return new MyBeanImplements();
    return new MyBean2Implements();
  }

  @Bean
  public MyOperation beanOperationOperation() {
    // return new MyBeanImplements();
    return new MyOperationImplement();
  }

  @Bean
  public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation) {
    return new MyBeanWithDependencyImplement(myOperation);
  }
  
}
