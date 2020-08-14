package vip.bigeye.blog.controller;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.rmi.transport.proxy.HttpReceiveSocket;
import vip.bigeye.blog.service.*;
import vip.bigeye.blog.util.Sort;
import vip.bigeye.blog.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Data 2019-08-20 20:19
 */
@Controller
@RequestMapping("/action")
public class ActionController {

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
    private LabelService label;
    @Autowired
    private InsertController insertController;
    @Autowired
    private NewsService newsService;
    @Autowired
    private Sort sort;



    //后端页面action
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }




    @RequestMapping("/write")
    public String write(ModelMap m,HttpServletRequest request){

    m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
    m.put("classify",blog.findById((String)request.getSession().getAttribute("username")).getClassify());
    m.put("label",blog.findById((String)request.getSession().getAttribute("username")).getLabel());

    System.out.println(m);
        return "writing";
    }


    @RequestMapping("/overwrite")
    public String overwrite(ModelMap m,HttpServletRequest request){
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        return "overwrite";
    }


    @RequestMapping("classInsert")
    public String indexInsert(ModelMap m,HttpServletRequest request){
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        return "blog_class_insert";
    }


    @RequestMapping("class")
    public String classlist(HttpServletRequest request,ModelMap m){
        String username=(String) request.getSession().getAttribute("username");
    m.put("classify",blog.findById(username).getClassify());
        return "blog_class";
    }


    @RequestMapping("account")
    public String account(HttpServletRequest request,ModelMap m){
        String username=(String) request.getSession().getAttribute("username");
        m.put("blog",blog.findById(username));
        return "account";
    }


    @RequestMapping("blog_list")
    public String blog_list(ModelMap m, HttpServletRequest request){
       m.put("blog_text", sort.ListSort(blog.findById((String)request.getSession().getAttribute("username")).getText()));
       m.put("blog_news", sort.ListSortNews(blog.findById((String)request.getSession().getAttribute("username")).getNews()));
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        return "blog_list";
    }

    @RequestMapping("blog_label")
    public String blog_label(ModelMap m, HttpServletRequest request){
        String username=(String) request.getSession().getAttribute("username");
        m.put("label",blog.findById(username).getLabel());
        return "blog_label";
    }


    @RequestMapping("labelInsert")
    public String blog_label_insert(ModelMap m,HttpServletRequest request){
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        return "blog_label_insert";
    }


    @RequestMapping("blog_message")
    public String blog_message(ModelMap m, HttpServletRequest request){

        m.put("blog_message",sort.ListSortMessage(blog.findById((String)request.getSession().getAttribute("username")).getMessage()));

        return "blog_message";
    }


    @RequestMapping("blog_comment")
    public String blog_comment(String id,ModelMap map){
        map.put("text",text.findById(id));
        map.put("text_comment", sort.ListSortComment(text.findById(id).getComment()));

        return "blog_comment";
    }

    @RequestMapping("reindex")
    public String reindex(HttpServletRequest request,ModelMap map){
        map.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        map.put("blog_news",sort.ListSortNews(blog.findById((String)request.getSession().getAttribute("username")).getNews()));
        return "blog_index";
    }


    @RequestMapping("/news")
    public String news(String id, ModelMap map, HttpServletRequest request) {
        News n = newsService.findById(id);
        String type = n.getType();
        if (type.equals("comment")) {
            map.put("text",text.findById(n.getNews_id()));
            System.out.println(text.findByComment(n.getNews_id()));
            System.out.println("success");
            map.put("text_comment", sort.ListSortComment(text.findById(n.getNews_id()).getComment()));
            newsService.deleteById(id);

            return "blog_comment";

        } else if (type.equals("message")) {
            map.put("blog_message", sort.ListSortMessage(blog.findById((String) request.getSession().getAttribute("username")).getMessage()));
            newsService.deleteById(id);

            return "blog_message";

        }else {
            map.put("blog", blog.findById((String) request.getSession().getAttribute("username")));
            map.put("blog_new", sort.ListSortNews(blog.findById((String) request.getSession().getAttribute("username")).getNews()));

            return "blog_index";
        }


    }


}
