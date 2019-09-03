package priv.xzhi.studyspringboot.bean.definition.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import priv.xzhi.studyspringboot.bean.definition.Animal;
import priv.xzhi.studyspringboot.bean.definition.Person;

/**
 * Desc:延迟初始化
 * Created by Xzhi on 2019-09-02 11:05.
 */
@Component
public class BussinessPersonLazyInit implements Person {

	private Animal animal;

	@Override
	public void service() {
		this.animal.user();
	}

	@Override
	@Autowired
	@Qualifier("dog")
	public void setAnimal(Animal animal) {
		System.out.println("延迟依赖注入");
		this.animal = animal;
	}
}
