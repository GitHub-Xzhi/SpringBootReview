package priv.xzhi.security.action01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @desc: Spring Security 实战 第1部分
 * @author Xzhi
 * @date 2020-4-24 15:14
 */
@SpringBootApplication(scanBasePackages = "priv.xzhi.security.action01")
@MapperScan("priv.xzhi.security.common.mapper")
public class Action01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Action01Application.class, args);
		Action01Application application = applicationContext.getBean(Action01Application.class);

		application.execute();
	}

	private void execute() {
	}

}
