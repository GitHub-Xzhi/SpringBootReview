package priv.xzhi.studyspringboot.IoC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import priv.xzhi.studyspringboot.IoC.bean.DataBaseProperties;
import priv.xzhi.studyspringboot.IoC.bean.ScopeBean;
import priv.xzhi.studyspringboot.IoC.bean.User;
import priv.xzhi.studyspringboot.IoC.bean.UserComponent;
import priv.xzhi.studyspringboot.IoC.bean.definition.impl.BussinessPerson;
import priv.xzhi.studyspringboot.IoC.bean.definition.impl.BussinessPersonLazyInit;
import priv.xzhi.studyspringboot.IoC.config.AppConfig;
import priv.xzhi.studyspringboot.IoC.service.UserService;

/**
 * Desc:
 * Created by Xzhi on 2019-09-02 0:13.
 */
public class IoCTest
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        System.out.println(user.toString());
        UserComponent userComponent = ctx.getBean(UserComponent.class);
        System.out.println(userComponent.toString());
        try {
            UserService userService = ctx.getBean(UserService.class);
            userService.testComponentFilte();
        } catch (Exception e) {
            e.printStackTrace();
        }
		BussinessPerson bussinessPerson = ctx.getBean(BussinessPerson.class);
		bussinessPerson.service();
        BussinessPersonLazyInit bussinessPersonLazyInit = ctx.getBean(BussinessPersonLazyInit.class);
        bussinessPersonLazyInit.service();

        DataBaseProperties dataBaseProperties = ctx.getBean(DataBaseProperties.class);
        System.out.println(dataBaseProperties.getDriverName());
    }

    /**
     * 测试Bean的生命周期
     */
    @Test
    public void testBeanPostProcessor() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        System.out.println(user.toString());
        UserComponent userComponent = ctx.getBean(UserComponent.class);
        System.out.println(userComponent.toString());
        try {
            UserService userService = ctx.getBean(UserService.class);
            userService.testComponentFilte();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BussinessPerson bussinessPerson = ctx.getBean(BussinessPerson.class);
        bussinessPerson.service();
        BussinessPersonLazyInit bussinessPersonLazyInit = ctx.getBean(BussinessPersonLazyInit.class);
        bussinessPersonLazyInit.service();
        ctx.close();
    }

    /**
     * 测试作用域
     */
    @Test
    public void testScope() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean bean1 = ctx.getBean(ScopeBean.class);
        ScopeBean bean2 = ctx.getBean(ScopeBean.class);
        System.out.println(bean1 == bean2);
    }
}
