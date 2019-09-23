package priv.xzhi.studyspringboot.AOP.service.impl;

import org.apache.commons.lang3.StringUtils;

import priv.xzhi.studyspringboot.AOP.service.HelloService;

/**
 * Desc:
 * Created by Xzhi on 2019-09-23 14:26.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(StringUtils.isBlank(name)) {
            throw new RuntimeException("参数为空");
        }
        System.out.println("hello " + name);
    }
}
