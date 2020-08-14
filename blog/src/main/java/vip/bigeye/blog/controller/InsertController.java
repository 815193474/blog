package vip.bigeye.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vip.bigeye.blog.service.*;
import vip.bigeye.blog.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-25 21:52
 */
@Controller
@RequestMapping("/insert")
public class InsertController {
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


    @RequestMapping("/blog")
    public String blog( HttpServletRequest request, HttpServletResponse response) throws  IOException {

        //设置头部信息防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String clientCheckcode = request.getParameter("yan").toUpperCase();//接收客户端提交上来的参数，使用toUpperCase()可以实现不区分大小写
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从session中提取验证码

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String name=request.getParameter("name");
        String qq_number=request.getParameter("qq_number");
        if (clientCheckcode.equals(serverCheckcode)) {
            //judge account is or not exist
            if (blog.findById(username) != null) {

                //account is exist ,return login page
                request.getSession().setAttribute("mes", "The " + username + " already exist.Please re-register !");
                return "redirect:../action/register";
            } else {
                //account does not exist ,insert account
                Blog b = new Blog();
                b.setUsername(username);
                b.setPasswd(password);
                b.setSex(sex);
                b.setName(name);
                b.setQq_Number(qq_number);
                b.setActive(0);
                b.setState(state.findById("1"));
                blog.save(b);
                request.getSession().setAttribute("mes", "register success,  redirect login page.");

                return "redirect:../action/login";
            }


        }else{
            request.getSession().setAttribute("mes", "验证码不正确");
            return "redirect:../action/register";
        }

    }


    @RequestMapping("/account")
    public String account(ModelMap m, HttpServletRequest request,  @RequestParam("file") MultipartFile file) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("/");
        System.out.println(path);
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        String sex = request.getParameter("sex");
        String sign = request.getParameter("sign");
        String interest = request.getParameter("interest");
        String name = request.getParameter("name");
        String qq_Number=request.getParameter("qq_number");
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = path + "/ueditor/jsp/upload/logo/image/" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            System.out.println(destFileName);
            //6.相对短路径
            String p = "/blog/ueditor/jsp/upload/logo/image/" + File.separator + fileName;

            Blog b = blog.findById(username);
            String delpath = path + b.getLogo();
            b.setPasswd(passwd);
            b.setQq_Number(qq_Number);
            b.setSex(sex);
            b.setName(name);
            b.setSign(sign);
            b.setInterest(interest);
            if (file.getOriginalFilename()==null||file.getOriginalFilename().equals("")){

            }else{

            b.setLogo(p);
                File f = new File(delpath);
                f.delete();
            }
            blog.save(b);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        request.getSession().setAttribute("mes", "Edit success");
        return "redirect:../action/account";
    }


    @RequestMapping("/classify")
    public String insertClassify(String name, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        Classify c = new Classify();
        c.setName(name);
        classify.save(c);
        Blog b = blog.findById(username);
        List<Classify> list = b.getClassify();
        list.add(c);
        b.setClassify(list);
        blog.save(b);

        request.getSession().setAttribute("mes", "Add Success");
        return "redirect:../action/classInsert";

    }


    @RequestMapping("/label")
    public String insertlabel(String name, String username, HttpServletRequest request) {
        Label l = new Label();
        l.setName(name);
        label.save(l);
        Blog b = blog.findById(username);
        List<Label> list = b.getLabel();
        list.add(l);
        b.setLabel(list);
        blog.save(b);

        request.getSession().setAttribute("mes", "Add Success");
        return "redirect:../action/labelInsert";

    }


    //前端操作，没有有效session
    @RequestMapping("/message")
    public String message(String username, String email, String value, HttpServletRequest request, ModelMap map) {
        Message m = new Message();
        m.setEmail(email);
        m.setValue(value);
        m.setDate(new Date());
        message.save(m);


        News n = new News();
        n.setDate(new Date());
        n.setName(email);
        n.setValue(value);
        n.setType("message");
        n.setNews_id(m.getId());
        newsService.save(n);


        Blog b = blog.findById(username);
        List<Message> list = b.getMessage();
        list.add(m);
        b.setMessage(list);
        List<News> list1 = b.getNews();
        list1.add(n);
        b.setNews(list1);
        blog.save(b);
        request.getSession().setAttribute("mes", "留言成功");
        map.put("blog", blog.findById(username));


        return "redirect:../q_action/guest_message?username=" + username;

    }


    @RequestMapping("/comment")
    public String comment(RedirectAttributes redirectAttributes,ModelMap map,String author, String username, String id, String details, HttpServletRequest request) {
    System.out.println(details);
    System.out.println(author);
     if(details.equals("")){

     }else {
         Comment c = new Comment();
         c.setDetails(details);
         if(author.equals("")){
             c.setName("Guest");
         }else {
             c.setName(author);
         }
         c.setDate(new Date());
         comment.save(c);


         News n = new News();
         n.setDate(new Date());
         n.setName("Guest");
         n.setValue(details);
         n.setType("comment");
         n.setNews_id(id);
         newsService.save(n);


         Text t = text.findById(id);
         List<Comment> list = t.getComment();
         list.add(c);
         t.setComment(list);
         text.save(t);
         Blog b = blog.findById(username);
         List<News> list1 = b.getNews();
         list1.add(n);
         b.setNews(list1);
         blog.save(b);
     }


        map.put("blog",blog.findById(username));
        map.put("text",text.findById(id));
        return "ajax";

    }




    @RequestMapping("/likes")
    public String likes(ModelMap map,RedirectAttributes redirectAttributes,String username,String id,HttpServletRequest request){

        String ip=getIpAddr(request);
        Text t=text.findById(id);
        List<Likes> list=t.getLikes();
        for (int i=0;i<list.size();i++){
            while (ip.equals(list.get(i).getIp())){
                map.put("bg","red");
               map.put("blog",blog.findById(username));
               map.put("text",text.findById(id));
                return "like";
            }
        }
        Likes l=new Likes();
        l.setDate(new Date());
        l.setIp(ip);
        likes.save(l);
        list.add(l);
        t.setLikes(list);
        text.save(t);
        map.put("bg","red");
        map.put("blog",blog.findById(username));
        map.put("text",text.findById(id));
        return "like";

    }


//tool
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}







