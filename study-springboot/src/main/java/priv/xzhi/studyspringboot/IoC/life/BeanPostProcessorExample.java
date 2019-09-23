package priv.xzhi.studyspringboot.IoC.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Desc: 测试bean的后置处理器
 * Created by Xzhi on 2019-09-03 13:49.
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用postProcessBeforeInitialization方法，参数【" +
                bean.getClass().getSimpleName()+"】【"+beanName+"】");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用postProcessAfterInitialization方法，参数【" +
                bean.getClass().getSimpleName()+"】【"+beanName+"】");
        return bean;
    }
}
