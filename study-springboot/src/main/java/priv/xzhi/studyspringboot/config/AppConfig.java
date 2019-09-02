package priv.xzhi.studyspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import priv.xzhi.studyspringboot.bean.User;
import priv.xzhi.studyspringboot.service.UserService;

/**
 * Desc: java配置文件
 * Created by Xzhi on 2019-09-02 0:07.
 */
@Configuration
//@ComponentScan(basePackageClasses = UserComponent.class)
@ComponentScan(value = "priv.xzhi.studyspringboot.*",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserService.class)})
//@ComponentScan(basePackages = {"priv.xzhi.studyspringboot.bean"})
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
