package priv.xzhi.security.action02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;


/**
 * @desc: WebSecurityConfig
 * @author Xzhi
 * @date 2020-04-30 09:33
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> myWebAuthenticationDetailsSource;

//    @Autowired
//    private AuthenticationProvider myAuthenticationProvider;

    @Autowired
    private AuthenticationProvider myDaoAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果不想要 ROLE_ 前缀，hasRole方法改为调用hasAuthority方法即可
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                // 开放 captcha.jpg 的访问权限
                .antMatchers("/app/api/**", "/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .authenticationDetailsSource(myWebAuthenticationDetailsSource)
                .loginPage("/myLogin.html")
                .loginProcessingUrl("/auth/form").permitAll()
                .failureHandler(new MyAuthenticationFailureHandler())
        ;
        // 将过滤器添加在UsernamePasswordAuthenticationFilter之前
//        http.addFilterBefore(new VerficationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 可配置多个AuthenticationProvider
        auth/*.authenticationProvider(myAuthenticationProvider)*/
                .authenticationProvider(myDaoAuthenticationProvider);
    }
}
