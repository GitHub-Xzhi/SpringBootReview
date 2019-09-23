package priv.xzhi.studyspringboot.IoC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("priv.xzhi.studyspringboot.IoC.*")
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);
	}

}
