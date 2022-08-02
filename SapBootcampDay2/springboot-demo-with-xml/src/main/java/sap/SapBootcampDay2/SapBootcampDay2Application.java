package sap.SapBootcampDay2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SapBootcampDay2Application {

	public static void main(String[] args) {
		SpringApplication.run(SapBootcampDay2Application.class, args);
	}

}
