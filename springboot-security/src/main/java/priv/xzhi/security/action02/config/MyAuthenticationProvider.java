package priv.xzhi.security.action02.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import priv.xzhi.security.action02.service.MyUserDetailsService;

/**
 * @author Xzhi
 * @desc: MyAuthenticationProvider
 * @date 2020-05-06 14:37
 */
@Component("myAuthenticationProvider")
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 编写更多校验逻辑

        // 校验密码 
        String presentedPassword = authentication.getCredentials().toString();
        if (StringUtils.isBlank(presentedPassword)) {
            throw new BadCredentialsException(this.messages.getMessage("BadCredentialsException", "密码不能为空"));
        } else {
            if (!presentedPassword.equals(userDetails.getPassword())) {
                throw new BadCredentialsException(this.messages.getMessage("BadCredentialsException", "密码错误"));
            }
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return myUserDetailsService.loadUserByUsername(username);
    }
}
