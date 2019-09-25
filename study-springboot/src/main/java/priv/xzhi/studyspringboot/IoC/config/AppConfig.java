package priv.xzhi.studyspringboot.IoC.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import priv.xzhi.studyspringboot.IoC.bean.User;
import priv.xzhi.studyspringboot.IoC.condition.DatabaseConditional;

/**
 * Desc: java配置文件
 * Created by Xzhi on 2019-09-02 0:07.
 */
@Configuration
@ComponentScan(basePackages = "priv.xzhi.studyspringboot.IoC.*")
//@ComponentScan(basePackages = "priv.xzhi.studyspringboot.*", lazyInit = true)
//@ComponentScan(basePackageClasses = UserComponent.class)
//@ComponentScan(value = "priv.xzhi.studyspringboot.*",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserService.class)})
//@ComponentScan(basePackages = {"priv.xzhi.studyspringboot.IoC.bean"})
public class AppConfig
{
    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setName("测试");
        user.setNote("啦啦");
        return user;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource(
            @Value("${database.driverName}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password
    ) {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
