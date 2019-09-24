package priv.xzhi.studyspringboot.AOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Desc: 定义切面
 * Created by Xzhi on 2019-09-24 14:18.
 */
@Aspect
public class MyAspect {

	/**
	 * 定义切点.<br/>
     * 切点的作用：用正则式向spring描述哪些类的哪些方法需要启用AOP。
	 */
	@Pointcut("execution(* priv.xzhi.studyspringboot.AOP.aspect.service.impl.UserServiceImpl.printUser(..))")
	public void pointCut() {}

	@Before("pointCut()")
	public void before() {
        System.out.println("before ……");
	}

	@After("pointCut()")
	public void after() {
        System.out.println("after ……");
	}

	@AfterReturning("pointCut()")
	public void afterReturning() {
        System.out.println("afterReturning ……");
	}

	@AfterThrowing("pointCut()")
	public void afterThrowing() {
        System.out.println("afterThrowing ……");
	}

    /**
     * 环绕通知
     */
    @Around("pointCut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around before ……");
        // 回调目标对象的原有方法
        joinPoint.proceed();
        System.out.println("around after ……");
	}
}
