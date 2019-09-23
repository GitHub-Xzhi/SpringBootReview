package priv.xzhi.studyspringboot.AOP;

import org.junit.Test;

import priv.xzhi.studyspringboot.AOP.intercept.impl.MyInterceptor;
import priv.xzhi.studyspringboot.AOP.proxy.ProxyBean;
import priv.xzhi.studyspringboot.AOP.service.HelloService;
import priv.xzhi.studyspringboot.AOP.service.impl.HelloServiceImpl;

/**
 * Desc: AOP测试
 * Created by Xzhi on 2019-09-23 17:31.
 */
public class AopTest {

    @Test
    public void testHelloProxy () {
        HelloService helloService = new HelloServiceImpl();
        // 按约定获取proxy
        HelloService proxyBean = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxyBean.sayHello("Xzhi");
        System.out.println("\n############### name is null！！###############\n");
        proxyBean.sayHello(null);
    }
}
