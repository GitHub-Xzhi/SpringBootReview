package priv.xzhi.studyspringboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import priv.xzhi.studyspringboot.bean.User;
import priv.xzhi.studyspringboot.bean.UserComponent;
import priv.xzhi.studyspringboot.bean.definition.impl.BussinessPerson;
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
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user.toString());
        UserComponent userComponent = context.getBean(UserComponent.class);
        System.out.println(userComponent.toString());
        try {
            UserService userService = context.getBean(UserService.class);
            userService.testComponentFilte();
        } catch (Exception e) {
            e.printStackTrace();
        }
		BussinessPerson bussinessPerson = context.getBean(BussinessPerson.class);
		bussinessPerson.service();
    }
}
