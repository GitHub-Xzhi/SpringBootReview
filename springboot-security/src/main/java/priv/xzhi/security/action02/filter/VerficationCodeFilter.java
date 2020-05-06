package priv.xzhi.security.action02.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priv.xzhi.security.action02.config.MyAuthenticationFailureHandler;
import priv.xzhi.security.action02.exception.VerificationCodeException;

/**
 * @author Xzhi
 * @desc: 用于校验验证码的过滤器
 * @date 2020-05-06 09:41
 */
public class VerficationCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler = new MyAuthenticationFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 非登录请求不检验验证码
        if (!"/auth/form".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
        } else {
            try {
                verificationCode(request);
                filterChain.doFilter(request, response);
            } catch (VerificationCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        }
    }

    private void verificationCode(HttpServletRequest request) throws VerificationCodeException {
        String captchaStr = "captcha";
        String requestCode = request.getParameter(captchaStr);
        HttpSession session = request.getSession();
        String savedCode = (String) session.getAttribute(captchaStr);
        if (StringUtils.isBlank(savedCode)) {
            // 随手清除验证码，无论是否成功与失败。客户端应在登录失败时刷新验证码
            session.removeAttribute(captchaStr);
        }
        // 校验不通过，抛出异常
        if (StringUtils.isBlank(requestCode) || StringUtils.isBlank(savedCode) || !requestCode.equals(savedCode)) {
            throw new VerificationCodeException();
        }
    }
}
