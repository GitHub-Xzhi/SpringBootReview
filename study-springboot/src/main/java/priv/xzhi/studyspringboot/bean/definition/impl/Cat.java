package priv.xzhi.studyspringboot.bean.definition.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import priv.xzhi.studyspringboot.bean.definition.Animal;

/**
 * Desc:
 * Created by 陈冠志 on 2019-09-02 11:31.
 */
@Component
/*
 * 修改优先权。如果有多个相同类型的bean，
 * 优先注入带有@primary注解的类或方法，
 * 如果其他相同类型的bean也带有该注解，那么IOC容器无法区分，会报错，
 * 有多个相同类型的bean，@Qualifier注解指定
 */
@Primary
public class Cat implements Animal {
	@Override
	public void user() {
		System.out.println("猫抓老鼠");
	}
}
