package priv.xzhi.studyspringboot.AOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import priv.xzhi.studyspringboot.AOP.aspect.validator.UserValidator;
import priv.xzhi.studyspringboot.AOP.aspect.validator.impl.UserValidatorImpl;
import priv.xzhi.studyspringboot.AOP.bean.User;

/**
 * Desc: 定义切面
 * Created by Xzhi on 2019-09-24 14:18.
 */
@Aspect
public class MyAspect {

	/**
	 * @ DeclareParents 作用：引入新的类来增强服务 <br/>
	 * value：指向你要增强功能的目标对象，这里要增强UserServiceImpl对象 <br/>
	 * defaultImpl：引入增强功能的类
	 */
	@DeclareParents(value = "priv.xzhi.studyspringboot.AOP.aspect.service.impl.UserServiceImpl",
			defaultImpl = UserValidatorImpl.class)
	public UserValidator userValidator;

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

	/**
	 * 通知获取参数：<br/>
	 * 非环绕通知：可以使用一个连接点（JoinPoint）类型的参数，通过它也可以获取参数。<br/>
	 * 环绕通知：可以使用ProceedingJoinPoint类型的参数。
	 */
	@Before("pointCut() && args(user)")
	public void beforeParam(JoinPoint point, User user) {
		Object[] args = point.getArgs();
		User arg = (User) args[0];
		System.out.println("beforeParam …… " + arg.getNote());
	}
}
