package priv.xzhi.studyspringboot.SpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import priv.xzhi.studyspringboot.SpringMVC.bean.User;
import priv.xzhi.studyspringboot.SpringMVC.dao.UserMapper;

/**
 * Desc:
 * Created by Xzhi on 2019-10-10 10:13.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(Long id) {

        return userMapper.selectById(id);
    }

    public List<User> findUsers(String userName, String note) {
        return userMapper.selectList(null);
    }
}
