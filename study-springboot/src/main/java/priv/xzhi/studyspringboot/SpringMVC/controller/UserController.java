package priv.xzhi.studyspringboot.SpringMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

import priv.xzhi.studyspringboot.SpringMVC.bean.User;
import priv.xzhi.studyspringboot.SpringMVC.service.UserService;

/**
 * Desc:
 * Created by Xzhi on 2019-10-10 10:12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

    /**
     * 展示用户详情
     */
    @GetMapping("/details")
	public ModelAndView details(Long id) {

        // 访问模型层得到数据
        User user = userService.getUser(id);
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // 定义模型视图
        mv.setViewName("user/details");
        // 加入数据模型
        mv.addObject("user", user);
        // 返回模型
        return mv;
    }

    @GetMapping("/detailsForJson")
	public ModelAndView detailsForJson(Long id) {
        // 访问模型层得到数据
        User user = userService.getUser(id);
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // 生成json视图
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);
        // 加入数据模型
        mv.addObject(user);
        // 返回模型
        return mv;
    }

    @GetMapping("/table")
	public ModelAndView table() {
        // 访问模型层得到数据
        List<User> userList = userService.findUsers(null, null);
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // 定义模型视图
        mv.setViewName("user/table");
        // 加入数据模型
        mv.addObject("userList", userList);
        // 返回模型
        return mv;
    }

    @GetMapping("/list")
    @ResponseBody
	public List<User> list(
	        @RequestParam(value = "userName",required = false)String userName,
	        @RequestParam(value = "note",required = false)String note
    ) {
        // 访问模型层得到数据
        return userService.findUsers(userName, note);
    }


}
