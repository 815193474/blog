package vip.bigeye.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.bigeye.blog.service.*;
import vip.bigeye.blog.util.Sort;
import vip.bigeye.blog.vo.Blog;
import vip.bigeye.blog.vo.Text;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-21 11:31
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private BlogService blog;
    @Autowired
    private StateService state;
    @Autowired
    private LikesService likes;
    @Autowired
    private CommentService comment;
    @Autowired
    private MessageService message;
    @Autowired
    private TextService text;
    @Autowired
    private ClassifyService classify;
    @Autowired
    private AdminService admin;
    @Autowired
    private LabelService labelService;
    @Autowired
    private NewsService news;
    @Autowired
    private Sort sort;

    @RequestMapping("/blog")
    public String login(HttpServletRequest request, ModelMap m, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置头部信息防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String clientCheckcode = request.getParameter("yan").toUpperCase();//接收客户端提交上来的参数，使用toUpperCase()可以实现不区分大小写
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从session中提取验证码

        if (clientCheckcode.equals(serverCheckcode)) {
            //judge account is or not exist
            if (blog.findById(username) != null) {
                if (blog.findById(username).getState().equals(state.findById("1"))) {
                    if (blog.findById(username).getPasswd().equals(password)) {
                        m.put("blog", blog.findById(username));
                        //save session message
                        request.getSession().setAttribute("username", username);
                        request.getSession().setAttribute("password", password);
                      m.put("blog_news",sort.ListSortNews(blog.findById((String)request.getSession().getAttribute("username")).getNews()));
                        return "blog_index";
                    } else {
                        //password error
                        request.getSession().setAttribute("mes", "Password error, please log in again !");
                        return "redirect:../action/login";
                    }
                } else {
                    //judge account state
                    request.getSession().setAttribute("mes", "The account isn't allowed to login !");
                    return "redirect:../action/login";
                }
            } else {
                //account not exist
                request.getSession().setAttribute("mes", "The " + username + " don't exist !");
                return "redirect:../action/login";
            }
        } else {
            request.getSession().setAttribute("mes", "验证码不正确");
            return "redirect:../action/login";
        }


    }


}
