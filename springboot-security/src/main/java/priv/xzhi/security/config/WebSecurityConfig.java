package priv.xzhi.security.config;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @desc: WebSecurityConfig
 * @author Xzhi
 * @date 2020-04-30 09:33
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HikariDataSource hikariDataSource;

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 自定义登录页
                .loginPage("/myLogin.html")
                // 指定处理登录请求的路径
                .loginProcessingUrl("/login")
                // 登录成功时的处理逻辑
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write("ok");
                })
                // 登录失败时的处理逻辑
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(401);
					PrintWriter writer = response.getWriter();
					writer.write("failure" + exception.getMessage());
                })
                // 使登录页不设限访问
                .permitAll()
                .and()
                .csrf().disable();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果不想要 ROLE_ 前缀，hasRole方法改为调用hasAuthority方法即可
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    /**
     * 另一种方案
     * 定义认证用于信息获取来源以及密码校验规则
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /*// inMemoryAuthentication 从内存中获取认证信息来源
//        auth.inMemoryAuthentication()
//                .withUser("admin1").password("1").roles("ADMIN")
//                .and()
//                .withUser("user1").password("1").roles("USER")
//                .and()
//                .passwordEncoder(new CustomPasswordEncoder());*/
//
//        // jdbc
//        auth.jdbcAuthentication()
//                .dataSource(hikariDataSource)
//                .withUser("admin").password("123").roles("ADMIN","USER")
//                .and()
//                .withUser("user").password("1").roles("USER")
//                .and()
//                .passwordEncoder(new CustomPasswordEncoder());
//    }

    /*// 另一种方案
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password(new BCryptPasswordEncoder().encode("1"))
                .roles("USER");
    }*/

    /*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(new CustomPasswordEncoder());
    }

    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(hikariDataSource);
        if (!manager.userExists("user")) {
            manager.createUser(User.withUsername("user").password("1").roles("USER").build());
        }
        if (!manager.userExists("admin")) {
            manager.createUser(User.withUsername("admin").password("123").roles("USER","ADMIN").build());
        }
        return manager;
    }*/

}
