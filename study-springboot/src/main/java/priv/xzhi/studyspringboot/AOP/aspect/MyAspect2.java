package priv.xzhi.studyspringboot.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

/**
 * Desc: MyAspect2
 * Created by Xzhi on 2019-09-25 10:00.
 */
@Aspect
public class MyAspect2 implements Ordered {

	@Pointcut("execution(* priv.xzhi.studyspringboot.AOP.aspect.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("MyAspect2 before ……");
	}

	@After("manyAspects()")
	public void after() {
		System.out.println("MyAspect2 after ……");
	}

	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("MyAspect2 afterReturning ……");
	}

	/**
	 * 也可以使用Ordered接口来定义切面顺序，不过推荐使用@Order注解方式
	 */
	@Override
	public int getOrder() {
		return 3;
	}
}
