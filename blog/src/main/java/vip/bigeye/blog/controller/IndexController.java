package vip.bigeye.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wolf  VX:a815193474
 * @Data 2020-02-26 13:43
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/")
    public String Index(){
        return "login";
    }
}
