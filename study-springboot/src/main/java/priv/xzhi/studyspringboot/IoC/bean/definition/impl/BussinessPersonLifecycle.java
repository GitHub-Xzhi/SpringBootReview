package priv.xzhi.studyspringboot.IoC.bean.definition.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import priv.xzhi.studyspringboot.IoC.bean.definition.Animal;
import priv.xzhi.studyspringboot.IoC.bean.definition.Person;

/**
 * Desc: 生命周期
 * Created by Xzhi on 2019-09-03 12:47.
 */
@Component
public class BussinessPersonLifecycle implements Person, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private Animal animal;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanNameAware的setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用DisposableBean的destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用InitializingBean的afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用ApplicationContextAware的setApplicationContext");
    }

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

    @PostConstruct
    public void init() {
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PostConstruct定义的自定义初始化方法");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PreDestroy定义的自定义销毁方法");
    }
}
