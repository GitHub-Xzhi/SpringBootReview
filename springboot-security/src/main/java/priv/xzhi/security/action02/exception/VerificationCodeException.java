package priv.xzhi.security.action02.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Xzhi
 * @desc: 验证码校验失败异常
 * @date 2020-05-06 09:38
 */
public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException() {
        super("图形验证码校验失败");
    }
}
