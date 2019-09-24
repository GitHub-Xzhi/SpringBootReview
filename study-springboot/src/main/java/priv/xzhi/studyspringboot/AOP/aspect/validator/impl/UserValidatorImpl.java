package priv.xzhi.studyspringboot.AOP.aspect.validator.impl;

import priv.xzhi.studyspringboot.AOP.aspect.validator.UserValidator;
import priv.xzhi.studyspringboot.AOP.bean.User;

/**
 * Desc:
 * Created by Xzhi on 2019-09-24 17:07.
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        if(user == null) {
            System.out.println("user为空");
        }
        return user != null;
    }
}
