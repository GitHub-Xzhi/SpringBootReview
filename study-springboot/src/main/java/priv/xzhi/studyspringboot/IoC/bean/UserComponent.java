package priv.xzhi.studyspringboot.IoC.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Desc:
 * Created by Xzhi on 2019-09-02 0:07.
 */
@Data
@Component("userComponent")
public class UserComponent
{
    @Value("使用component")
    private String name;
    @Value("note1")
    private String note;
}
