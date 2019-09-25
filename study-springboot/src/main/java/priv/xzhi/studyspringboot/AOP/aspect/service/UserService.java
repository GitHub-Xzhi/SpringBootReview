package priv.xzhi.studyspringboot.AOP.aspect.service;

import priv.xzhi.studyspringboot.AOP.bean.User;

/**
 * Desc: 用户服务接口
 * Created by Xzhi on 2019-09-24 14:11.
 */
public interface UserService {
    void printUser(User user);

    void manyAspects();
}
