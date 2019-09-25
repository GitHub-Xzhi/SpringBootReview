package priv.xzhi.studyspringboot.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * Desc: MyAspect3
 * Created by Xzhi on 2019-09-25 10:00.
 */
@Aspect
// 指定多个切面的顺序，值越小优先级越高
@Order(2)
public class MyAspect3 {

	@Pointcut("execution(* priv.xzhi.studyspringboot.AOP.aspect.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("MyAspect3 before ……");
	}

	@After("manyAspects()")
	public void after() {
		System.out.println("MyAspect3 after ……");
	}

	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("MyAspect3 afterReturning ……");
	}
}
