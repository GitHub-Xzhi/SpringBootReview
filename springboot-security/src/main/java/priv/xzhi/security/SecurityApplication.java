package priv.xzhi.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @desc: Spring Security
 * @author Xzhi
 * @date 2020-4-24 15:14
 */
@SpringBootApplication(scanBasePackages = "priv.xzhi.security")
@MapperScan("priv.xzhi.security.mapper")
public class SecurityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SecurityApplication.class, args);
		SecurityApplication application = applicationContext.getBean(SecurityApplication.class);

		application.execute();
	}

	private void execute() {
	}

}
