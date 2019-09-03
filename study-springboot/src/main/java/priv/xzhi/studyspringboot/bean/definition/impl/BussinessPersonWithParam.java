package priv.xzhi.studyspringboot.bean.definition.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import priv.xzhi.studyspringboot.bean.definition.Animal;
import priv.xzhi.studyspringboot.bean.definition.Person;

/**
 * Desc:带有参数的构造方法类的装配
 * Created by Xzhi on 2019-09-02 11:05.
 */
@Component
public class BussinessPersonWithParam implements Person {

	private Animal animal;

	public BussinessPersonWithParam(@Autowired @Qualifier("dog") Animal animal) {
		this.animal = animal;
	}

	@Override
	public void service() {
		this.animal.user();
	}

	@Override
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
