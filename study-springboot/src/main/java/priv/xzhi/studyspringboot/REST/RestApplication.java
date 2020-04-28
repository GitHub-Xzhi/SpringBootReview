package priv.xzhi.studyspringboot.REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Desc:REST启动类
 * Created by Xzhi on 2019-09-25 16:36.
 */
@SpringBootApplication(scanBasePackages = "priv.xzhi.studyspringboot.REST.*")
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
