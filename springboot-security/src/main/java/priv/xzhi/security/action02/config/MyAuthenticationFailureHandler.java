package priv.xzhi.security.action02.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xzhi
 * @desc: MyAuthenticationFailureHandler
 * @date 2020-05-06 10:01
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(401);
        PrintWriter writer = response.getWriter();
        writer.write("{\"error_code\":\"401\", \"name\":\"" + exception.getClass() + "\", \"message\":\"" + exception.getMessage() + "\"}");
    }
}
