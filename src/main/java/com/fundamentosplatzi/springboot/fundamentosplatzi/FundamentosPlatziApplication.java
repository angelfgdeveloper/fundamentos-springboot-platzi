package com.fundamentosplatzi.springboot.fundamentosplatzi;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.components.ComponentDependency;

@SpringBootApplication
public class FundamentosPlatziApplication implements CommandLineRunner {

	// Inyeccion de dependencias
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosPlatziApplication(
		@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
		MyBean myBean,
		MyBeanWithDependency myBeanWithDependency
	) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
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
	}

}
