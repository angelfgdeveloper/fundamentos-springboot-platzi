package com.fundamentosplatzi.springboot.fundamentosplatzi.bean;

public class MyBeanImplements implements MyBean {

  @Override
  public void print() {
    System.out.println("Hola desde mi implementacion del bean");    
  }
  
}
