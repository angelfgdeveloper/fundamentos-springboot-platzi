package com.fundamentosplatzi.springboot.fundamentosplatzi.bean;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

	private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

  private MyOperation myOperation;

  public MyBeanWithDependencyImplement(MyOperation myOperation) {
    this.myOperation = myOperation;
  }

  @Override
  public void printWithDependency() {
    LOGGER.info("Hemos ingresado al metodo printWithDependency()");

    int number = 1;

    LOGGER.debug("El numero enviado como parametro a la dependencia es: " + number);

    System.out.println(myOperation.sum(number));
    System.out.println("Hola desde la implementacion de un bean con dependencia");
  }
  
}
