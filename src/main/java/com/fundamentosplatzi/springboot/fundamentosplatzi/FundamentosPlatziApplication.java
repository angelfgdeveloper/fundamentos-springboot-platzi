package com.fundamentosplatzi.springboot.fundamentosplatzi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.properties.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.components.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;

@SpringBootApplication
public class FundamentosPlatziApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosPlatziApplication.class);

	// Inyeccion de dependencias
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	// Properties
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public FundamentosPlatziApplication(
		@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
		MyBean myBean,
		MyBeanWithDependency myBeanWithDependency,
		MyBeanWithProperties myBeanWithProperties,
		UserPojo userPojo
	) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosPlatziApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Ejecuta en la aplicacion lo que requeramos
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());

		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword());

		try {
			int value = 10 / 0;
			LOGGER.debug("Mi valor: " + value);
		} catch (Exception e) {
			LOGGER.error("Esto es un error al dividir por cero " + e.getMessage());
		}

	}

}
