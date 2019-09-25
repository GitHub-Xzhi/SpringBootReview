package priv.xzhi.studyspringboot.AOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * Desc: MyAspect1
 * Created by Xzhi on 2019-09-25 10:00.
 */
@Aspect
@Order(0)
public class MyAspect1 {

	@Pointcut("execution(* priv.xzhi.studyspringboot.AOP.aspect.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("MyAspect1 before ……");
	}

	@After("manyAspects()")
	public void after() {
		System.out.println("MyAspect1 after ……");
	}

	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("MyAspect1 afterReturning ……");
	}
}
