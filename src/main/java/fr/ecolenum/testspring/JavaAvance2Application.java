package fr.ecolenum.testspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JavaAvance2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaAvance2Application.class, args);
	}

}
