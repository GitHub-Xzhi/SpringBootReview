package priv.xzhi.studyspringboot.AOP.intercept;

import java.lang.reflect.InvocationTargetException;

import priv.xzhi.studyspringboot.AOP.invoke.Invocation;

/**
 * Desc: 拦截器接口
 * Created by Xzhi on 2019-09-23 15:08.
 */
public interface Interceptor {

    /**
     * 事前方法
     */
    boolean before();

    /**
     * 事后方法
     */
    void after();

    /**
     * 取代原有事件方法
     * @param invocation 回调参数，可以通过它的proceed方法，回调原有事件
     * @return 原有事件返回对象
     */
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    /**
     * 是否返回方法。事件没有发生异常执行
     */
    void afterReturning();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    void afterThrowing();

    /**
     * 是否使用around方法取代原有方法
     */
    boolean useAround();
}
