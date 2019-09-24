package priv.xzhi.studyspringboot.AOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import priv.xzhi.studyspringboot.AOP.aspect.MyAspect;

@SpringBootApplication
@ComponentScan("priv.xzhi.studyspringboot.AOP.*")
public class AopApplication {

	/**
	 * 定义切面
	 */
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
