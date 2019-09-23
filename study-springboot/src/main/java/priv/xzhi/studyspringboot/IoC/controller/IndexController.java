package priv.xzhi.studyspringboot.IoC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Desc:
 * Created by Xzhi on 2019-09-01 23:12.
 */
@Controller
public class IndexController
{
    @GetMapping("/index")
    public String index() {

        return "index";
    }
}
