package priv.xzhi.studyspringboot.AOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("priv.xzhi.studyspringboot.AOP.*")
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
