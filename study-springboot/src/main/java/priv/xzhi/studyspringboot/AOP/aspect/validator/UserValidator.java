package priv.xzhi.studyspringboot.AOP.aspect.validator;

import priv.xzhi.studyspringboot.AOP.bean.User;

/**
 * Desc: 用户检测接口
 * Created by Xzhi on 2019-09-24 17:05.
 */
public interface UserValidator {
    /**
     * 检测用户对象是否为空
     */
    boolean validate(User user);
}
