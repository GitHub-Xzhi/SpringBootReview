package priv.xzhi.studyspringboot.SpringMVC;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Desc:
 * Created by Xzhi on 2019-10-10 09:54.
 */
@SpringBootApplication(scanBasePackages = "priv.xzhi.studyspringboot.SpringMVC.*")
@MapperScan("priv.xzhi.studyspringboot.SpringMVC.dao")
@PropertySource("classpath:jdbc.properties")
public class SpringMVCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMVCApplication.class, args);
    }
}
