package priv.xzhi.studyspringboot.bean.definition.impl;

import org.springframework.stereotype.Component;

import priv.xzhi.studyspringboot.bean.definition.Animal;

/**
 * Desc:
 * Created by 陈冠志 on 2019-09-02 11:10.
 */
@Component
public class Dog implements Animal {
    @Override
    public void user() {
        System.out.println("狗看门");
    }
}
