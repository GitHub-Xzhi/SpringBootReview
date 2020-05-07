package priv.xzhi.security.action02.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Xzhi
 * @desc: MyWebAuthenticationDetails
 * @date 2020-05-07 14:57
 */
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private String imageCode;

    private String savedImageCode;

    private boolean imageCodeIsRight;

    public boolean getImageCodeIsRight() {
        return imageCodeIsRight;
    }

    public String getImageCode() {
        return imageCode;
    }

    public String getSavedImageCode() {
        return savedImageCode;
    }

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public MyWebAuthenticationDetails(HttpServletRequest request) {
        // 补充用户提交的验证码和 session 保存的验证码
        super(request);

        String captchaStr = "captcha";
        this.imageCode = request.getParameter(captchaStr);
        HttpSession session = request.getSession();
        this.savedImageCode = (String) session.getAttribute(captchaStr);
        if (StringUtils.isBlank(savedImageCode)) {
            // 随手清除验证码，无论是否成功与失败。客户端应在登录失败时刷新验证码
            session.removeAttribute(captchaStr);
        }
        if (StringUtils.isNotBlank(imageCode) && imageCode.equals(savedImageCode)) {
            imageCodeIsRight = true;
        }
    }
}
