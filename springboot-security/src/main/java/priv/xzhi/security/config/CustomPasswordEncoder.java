package priv.xzhi.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Xzhi
 * @desc: CustomPasswordEncoder
 * @date 2020-04-30 17:30
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
