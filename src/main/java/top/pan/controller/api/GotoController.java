package top.pan.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author coffee0bean
 * @Description
 * @Date 0:35 2020/5/27
 */
@Controller
public class GotoController {

    @RequestMapping("/")
    public String goToIndex(){
        return "index";
    }


    @RequestMapping("login")
    public String goToLogin(){
        return "login";
    }
}
