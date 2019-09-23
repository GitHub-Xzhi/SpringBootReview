package priv.xzhi.studyspringboot.AOP.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import priv.xzhi.studyspringboot.AOP.intercept.Interceptor;
import priv.xzhi.studyspringboot.AOP.invoke.Invocation;

/**
 * Desc:
 * Created by Xzhi on 2019-09-23 16:57.
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor;

	public static Object getProxyBean(Object target, Interceptor interceptor) {
		ProxyBean proxyBean = new ProxyBean();
		// 保存被代理对象
		proxyBean.target = target;
		// 保存拦截器
		proxyBean.interceptor = interceptor;
		// 生成代理对象
		/*
		 * ClassLoader loader ——类加载器；
		 * Class<?>[] interfaces ——绑定的接口，也就是把代理对象绑定到哪个接口下,可以是多个；
		 * InvocationHandler invocationHandler ——绑定代理对象逻辑实现。
		 */
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				proxyBean);
		// 返回代理对象
		return proxy;
	}

    /**
     * 处理代理对象方法逻辑
     * @param proxy 代理对象
     * @param method 当前方法
     * @param args 运行参数
     * @return 方法调用结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args, method, target);
        Object retObj = null;
        try {
            if(this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception e) {
            // 产生异常
            exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
