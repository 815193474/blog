package vip.bigeye.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.bigeye.blog.service.*;
import vip.bigeye.blog.util.Sort;
import vip.bigeye.blog.vo.Blog;
import vip.bigeye.blog.vo.Likes;
import vip.bigeye.blog.vo.News;
import vip.bigeye.blog.vo.Text;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Data 2019-11-18 09:23
 */
@Controller
@RequestMapping("/q_action")
public class FrontAction {

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



    //前端页面action


    @RequestMapping("/index")
    public String guestIndex(String id, ModelMap m){
        Blog b=blog.findById(id);


        List<Text> list=b.getText();
        sort.ListSort(list);
        List<Text> list1=new ArrayList<Text>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list1.add(list.get(i));
        }

        m.put("blog",b);
        m.put("new_text",list1);
        return "guest_index";
    }



    @RequestMapping("guest_message")
    public String message(String username,ModelMap m){
        Blog b=blog.findById(username);

        List<Text> list=b.getText();
        sort.ListSort(list);
        List<Text> list1=new ArrayList<Text>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list1.add(list.get(i));
        }

        m.put("new_text",list1);
        m.put("blog",blog.findById(username));
        return "guest_message";
    }


    @RequestMapping("guest_classify")
    public String classify(String username,ModelMap m)
    {
        Blog b=blog.findById(username);
        List<Text> list=b.getText();
        sort.ListSort(list);

        List<Text> list1=new ArrayList<>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list1.add(list.get(i));
        }
        m.put("new_text",list1);
        m.put("blog",blog.findById(username));
        return "guest_class";
    }


    @RequestMapping("guest_text")
    public String text(String id, String username, ModelMap m, HttpServletRequest request){
        Text t=text.findById(id);
        t.setVisit_times(t.getVisit_times()+1);
        text.save(t);
        Blog b=blog.findById(username);
        List<Text> list=b.getText();
        sort.ListSort(list);

        List<Text> list1=new ArrayList<Text>();
        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list1.add(list.get(i));
        }

        String ip=insertController.getIpAddr(request);
        List<Likes> l=t.getLikes();


        m.put("new_text",list1);
        m.put("text",t);
        m.put("blog",blog.findById(username));


        for (int i=0;i<l.size();i++){
            while (ip.equals(l.get(i).getIp())){
                m.put("bg","red");
                return "guest_text";
            }
        }
        m.put("bg","#ccc");
        return "guest_text";



    }

    @RequestMapping("guest_label")
    public String label(String username,ModelMap m){
        Blog b=blog.findById(username);
        List<Text> list=b.getText();
        sort.ListSort(list);

        List<Text> list1=new ArrayList<Text>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list1.add(list.get(i));
        }
        m.put("new_text",list1);
        m.put("blog",blog.findById(username));

        return "guest_label";
    }



    @RequestMapping("guest_texts")
    public String texts(String username,ModelMap m){
        Blog b=blog.findById(username);

        List<Text> list=b.getText();
        sort.ListSort(list);
        List<Text> list1=new ArrayList<Text>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list1.add(list.get(i));
        }
        sort.ListSort(list1);

        m.put("new_text",list1);
        m.put("blog",b);
        m.put("texts",list);

        return "guest_texts";
    }



    @RequestMapping("/select_classify")
    public String select(String username,String id,ModelMap m){
        List<Text> list=blog.findById(username).getText();
        sort.ListSort(list);
        List<Text> list1=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getClassify().equals(classify.findById(id))){
                list1.add(list.get(i));
            }
        }

        List<Text> list2=new ArrayList<>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list2.add(list.get(i));
        }

        m.put("new_text",list2);
        m.put("texts",list1);
        m.put("blog",blog.findById(username));
        return "guest_texts";
    }



    @RequestMapping("/select_label")
    public String select_label(String username,String id,ModelMap m){
        List<Text> list=blog.findById(username).getText();
        sort.ListSort(list);
        List<Text> list1=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getLabel().equals(label.findById(id))){
                list1.add(list.get(i));
            }
        }
        List<Text> list2=new ArrayList<>();

        for (int i=0;i<list.size();i++){

            if(i==4||i==list.size()){
                break;
            }
            list2.add(list.get(i));
        }
        m.put("new_text",list2);
        m.put("texts",list1);
        m.put("blog",blog.findById(username));
        return "guest_texts";
    }




}
