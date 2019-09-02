package priv.xzhi.studyspringboot.service;

import org.springframework.stereotype.Service;

/**
 * Desc:
 * Created by 陈冠志 on 2019-09-02 9:40.
 */
@Service
public class UserService {
    public void testComponentFilte() {
        System.out.println("测试该类是否从IOC容器中排除，打印出来说明没有被排除");
    }
}
