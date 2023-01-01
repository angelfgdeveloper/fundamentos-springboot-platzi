package com.fundamentosplatzi.springboot.fundamentosplatzi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentosplatzi.components.ComponentDependency;

@SpringBootApplication
public class FundamentosPlatziApplication implements CommandLineRunner {

	// Inyeccion de dependencias
	private ComponentDependency componentDependency;

	public FundamentosPlatziApplication(ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosPlatziApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Ejecuta en la aplicacion lo que requeramos
		componentDependency.saludar();
	}

}
