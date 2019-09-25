package priv.xzhi.studyspringboot.AOP.aspect.service.impl;

import org.springframework.stereotype.Service;

import priv.xzhi.studyspringboot.AOP.aspect.service.UserService;
import priv.xzhi.studyspringboot.AOP.bean.User;

/**
 * Desc:
 * Created by Xzhi on 2019-09-24 14:12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null) {
            throw new RuntimeException("检查用户参数是否为空……");
        }
        System.out.print("id = " + user.getId());
        System.out.print("\tusername = " + user.getUserName());
        System.out.print("\tnote = " + user.getNote() +"\n");
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }
}
