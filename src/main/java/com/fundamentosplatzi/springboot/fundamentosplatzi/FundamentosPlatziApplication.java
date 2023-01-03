package com.fundamentosplatzi.springboot.fundamentosplatzi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentosplatzi.repository.UserRepository;

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

	private UserRepository userRepository;

	public FundamentosPlatziApplication(
		@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
		MyBean myBean,
		MyBeanWithDependency myBeanWithDependency,
		MyBeanWithProperties myBeanWithProperties,
		UserPojo userPojo,
		UserRepository userRepository
	) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosPlatziApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
	}

	private void ejemplosAnteriores() {
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

	private void saveUsersInDataBase() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.now());
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		User user10 = new User("Test6", "Test6@domain.com", LocalDate.now());
		User user11 = new User("Test7", "Test7@domain.com", LocalDate.now());
		User user12 = new User("Test8", "Test8@domain.com", LocalDate.now());
		User user13 = new User("Test9", "Test9@domain.com", LocalDate.now());


		List<User> list = Arrays.asList(
			user4, user1, user3, user2, user5, user6, user7, user8, user9, user10, user11, user12, user13
		);
		list.stream().forEach(userRepository::save); // Guardar
		// postRepository.save(new Posts("Mi post test1", user12));
		// postRepository.save(new Posts("Mi post test2", user13));
		// postRepository.save(new Posts("Mi post test3", user13));
	}

}
