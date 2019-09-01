package priv.xzhi.studyspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import priv.xzhi.studyspringboot.bean.User;

/**
 * Desc: java配置文件
 * Created by Xzhi on 2019-09-02 0:07.
 */
@Configuration
public class AppConfig
{
    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setName("测试");
        user.setNote("啦啦");
        return user;
    }
}
