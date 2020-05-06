package priv.xzhi.security.action02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @desc: Spring Security 实战 第2部分
 * @author Xzhi
 * @date 2020-4-24 15:14
 */
@SpringBootApplication(scanBasePackages = "priv.xzhi.security.action02")
@MapperScan("priv.xzhi.security.common.mapper")
public class Action02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Action02Application.class, args);
		Action02Application application = applicationContext.getBean(Action02Application.class);
	}

}
