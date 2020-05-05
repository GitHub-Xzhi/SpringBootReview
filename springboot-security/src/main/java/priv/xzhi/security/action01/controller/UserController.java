package priv.xzhi.security.action01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xzhi
 * @desc: UserController
 * @date 2020-04-30 15:27
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

    @GetMapping("hello")
    public String hello() {
        return "User";
    }
}
