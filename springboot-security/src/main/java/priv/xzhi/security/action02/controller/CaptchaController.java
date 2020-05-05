package priv.xzhi.security.action02.controller;

import com.google.code.kaptcha.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xzhi
 * @desc: CaptchaController
 * @date 2020-05-06 01:25
 */
@RestController
public class CaptchaController {
    @Autowired
    private Producer producer;

    @GetMapping("/captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置内容类型
        response.setContentType("image/jpeg");
        // 创建验证码文本
        String capText = producer.createText();
        // 将验证码文本设置到session
        request.getSession().setAttribute("captcha", capText);
        // 创建验证码图片
        BufferedImage bi = producer.createImage(capText);
        // 获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 将图片验证码数据写到响应输出流
        ImageIO.write(bi, "jpg", outputStream);
        // 推送并关闭响应输出流
        try {
            outputStream.flush();
        } finally {
            outputStream.close();
        }
    }
}
