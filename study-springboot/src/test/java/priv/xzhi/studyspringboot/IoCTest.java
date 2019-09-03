package priv.xzhi.studyspringboot;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import priv.xzhi.studyspringboot.bean.User;
import priv.xzhi.studyspringboot.bean.UserComponent;
import priv.xzhi.studyspringboot.bean.definition.impl.BussinessPerson;
import priv.xzhi.studyspringboot.bean.definition.impl.BussinessPersonLazyInit;
import priv.xzhi.studyspringboot.config.AppConfig;
import priv.xzhi.studyspringboot.service.UserService;

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
}
