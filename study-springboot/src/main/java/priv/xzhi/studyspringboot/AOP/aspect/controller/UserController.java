package priv.xzhi.studyspringboot.AOP.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import priv.xzhi.studyspringboot.AOP.aspect.service.UserService;
import priv.xzhi.studyspringboot.AOP.aspect.validator.UserValidator;
import priv.xzhi.studyspringboot.AOP.bean.User;

/**
 * Desc: 用户控制器
 * Created by Xzhi on 2019-09-24 16:11.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/print")
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @GetMapping("/vp")
    public User validateAndPrint(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        // 强制转换
        UserValidator userValidator = (UserValidator) userService;
        // 验证用户是否为空
//        User user = null;
        if(userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }
}
