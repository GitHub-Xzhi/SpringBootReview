package priv.xzhi.studyspringboot.bean.definition.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import priv.xzhi.studyspringboot.bean.definition.Animal;
import priv.xzhi.studyspringboot.bean.definition.Person;

/**
 * Desc:
 * Created by 陈冠志 on 2019-09-02 11:05.
 */
@Component
public class BussinessPerson implements Person {

	@Autowired
    @Qualifier("dog")
	private Animal animal = null;

	@Override
	public void service() {
		this.animal.user();
	}

	@Override
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}