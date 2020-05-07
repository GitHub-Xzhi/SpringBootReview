package priv.xzhi.security.action02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import priv.xzhi.security.action02.exception.VerificationCodeException;
import priv.xzhi.security.action02.service.MyUserDetailsService;

/**
 * @author Xzhi
 * @desc: MyDaoAuthenticationProvider
 * @date 2020-05-07 11:15
 */
@Component("myDaoAuthenticationProvider")
public class MyDaoAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    /**
     * 把构造方法注入 MyUserDetailsService 和 PasswordEncoder
     * @param myUserDetailsService
     * @param passwordEncoder
     */
    public MyDaoAuthenticationProvider(MyUserDetailsService myUserDetailsService, PasswordEncoder passwordEncoder) {
        this.setUserDetailsService(myUserDetailsService);
        this.setPasswordEncoder(passwordEncoder);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 实现图形验证码的校验逻辑
        // 获取详细信息
        MyWebAuthenticationDetails myWebAuthenticationDetails = (MyWebAuthenticationDetails) authentication.getDetails();
        // 验证码不正确，就抛出相应的异常信息
        if (!myWebAuthenticationDetails.getImageCodeIsRight()) {
            throw new VerificationCodeException();
        }
        // 调用父类方法完成密码验证
//        super.additionalAuthenticationChecks(userDetails, authentication);
        myAuthenticationProvider.additionalAuthenticationChecks(userDetails, authentication);
    }
}
