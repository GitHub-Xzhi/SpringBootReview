package priv.xzhi.studyspringboot.AOP.aspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import priv.xzhi.studyspringboot.AOP.aspect.MyAspect;
import priv.xzhi.studyspringboot.AOP.aspect.MyAspect1;
import priv.xzhi.studyspringboot.AOP.aspect.MyAspect2;
import priv.xzhi.studyspringboot.AOP.aspect.MyAspect3;

/**
 * Desc: App配置
 * Created by Xzhi on 2019-09-25 10:09.
 */
@Configuration
public class AppConfig {

	/**
	 * 定义切面
	 */
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}

	@Bean(name = "myAspect2")
	public MyAspect2 initMyAspect2() {
		return new MyAspect2();
	}

	@Bean(name = "myAspect1")
	public MyAspect1 initMyAspect1() {
		return new MyAspect1();
	}

	@Bean(name = "myAspect3")
	public MyAspect3 initMyAspect3() {
		return new MyAspect3();
	}

}
