package vip.bigeye.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.bigeye.blog.service.*;
import vip.bigeye.blog.util.Sort;
import vip.bigeye.blog.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-09-01 22:25
 */
@Controller
@RequestMapping("/delete")
public class DeleteController {
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
    private DetailsService detailsService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private Sort sort;



    @RequestMapping("/text")
    public String text(String id, ModelMap m, HttpServletRequest request){

        String upfile=detailsService.findById(text.findById(id).getDetails().getId()).getValue();
        String path = request.getSession().getServletContext().getRealPath("/");
        //匹配到图片名称存到m.group();
        Pattern p=Pattern.compile("(?<=src=\")(.*?)(?=\")");
        Matcher m1=p.matcher(upfile);
        //定义缓存图片数组
        List<String> list=new ArrayList<>();
        while(m1.find()){
            list.add(m1.group());
        }
        //定义真实大小数组
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            File f=new File(path+list.get(i));
            f.delete();

        }
        List<Likes> likeId=text.findById(id).getLikes();
        for (int i=0;i<likeId.size();i++){
            likes.deleteById(likeId.get(i).getId());
        }
        List<Comment> commentid=text.findById(id).getComment();
        for (int i=0;i<likeId.size();i++){
            comment.deleteById(commentid.get(i).getId());
        }
        String detailsId=text.findById(id).getDetails().getId();
        text.deleteById(id);
        detailsService.deleteById(detailsId);
        m.put("blog_text",sort.ListSort(blog.findById((String) request.getSession().getAttribute("username")).getText()));
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));

        return "blog_list";


    }


    @RequestMapping("/classify")
    public String classify(String id, ModelMap m, HttpServletRequest request){

        try{

            classify.deleteById(id);
        }catch (Exception e){
            request.getSession().setAttribute("mes","该分类下有文章，禁止删除");
        }
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        return "blog_classify";

    }

    @RequestMapping("/label")
    public String labels(String id, ModelMap m, HttpServletRequest request){

        try{

            label.deleteById(id);
        }catch (Exception e){
            request.getSession().setAttribute("mes","该标签下有文章，禁止删除");
        }
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));
        return "blog_label";

    }


    @RequestMapping("/message")
    public String messages(String id, ModelMap m, HttpServletRequest request){

            message.deleteById(id);

        m.put("blog_message",sort.ListSortMessage(blog.findById((String)request.getSession().getAttribute("username")).getMessage()));


        return "blog_message";

    }
    @RequestMapping("/comment")
    public String comment(String id, ModelMap m, HttpServletRequest request,String text_id){

            comment.deleteById(id);
        m.put("text_comment",sort.ListSortComment(text.findById(text_id).getComment()));
        m.put("text",text.findById(text_id));
        return "blog_comment";

    }
    @RequestMapping("/news")
    public String newss(String id, ModelMap m, HttpServletRequest request){

        newsService.deleteById(id);

        m.put("blog_news",sort.ListSortNews(blog.findById((String)request.getSession().getAttribute("username")).getNews()));
        m.put("blog",blog.findById((String)request.getSession().getAttribute("username")));

        return "blog_index";

    }

    @RequestMapping("/newsAll")
    public String newsAll(ModelMap m, HttpServletRequest request){
       Blog b= blog.findById((String)request.getSession().getAttribute("username"));
       for (int i=0;i<b.getNews().size();i++){
           newsService.deleteById(b.getNews().get(i).getId());
       }
       blog.save(b);


        return "redirect:../action/reindex";

    }





















}
