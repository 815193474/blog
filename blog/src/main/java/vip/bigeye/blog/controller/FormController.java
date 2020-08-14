package vip.bigeye.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.bigeye.blog.service.*;
import vip.bigeye.blog.vo.Blog;
import vip.bigeye.blog.vo.Details;
import vip.bigeye.blog.vo.Text;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-22 16:44
 */
@Controller
@RequestMapping("/upload")
public class FormController {
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private BlogService blog;
    @Autowired
    private TextService text;
    @Autowired
    private StateService stateService;
    @Autowired
    private DetailsService detailsService;
  @RequestMapping("/text")
    public String image(String username,String title, String classify,String label, String copyright, String upfile, HttpServletRequest request) throws IOException {
    System.out.println(upfile);
      String path = request.getSession().getServletContext().getRealPath("/");

       int k=0;
       //匹配到图片名称存到m.group();
       Pattern p=Pattern.compile("(?<=title=\")(.*?)(?=\")");
       Matcher m=p.matcher(upfile);
       //定义缓存图片数组
       String[] str1 = new String[50];
       while(m.find()){
           str1[k]=m.group();
           k++;
       }
       //定义真实大小数组
       String[] str = new String[k];
       for (int i=0;i<str.length;i++){
           str[i]=str1[i];
       }
       //格式化并获取当前时间，生成当天文件夹名称
       SimpleDateFormat date=new SimpleDateFormat("yyyyMMdd");
       String dir=date.format(new Date());
       //指定文件位置并判断是否存在路径，不存在便创建
       File file=new File(path+ "/ueditor/jsp/upload/image/" +dir);
       if(!file.exists()){
           file.mkdir();
           System.out.println("不存在");
       }
       //循环移动文件
       for (int i=0;i<str.length;i++){
           // 创建文件输入流
           FileInputStream fileInputStream=new FileInputStream(path+ "/ueditor/jsp/upload/tmp/" +dir+"/"+str[i]);
           //创建文件输出流

           FileOutputStream fileOutputStream=new FileOutputStream(path+ "/ueditor/jsp/upload/image/" +dir+"/"+str[i]);
           //定义二进制缓存池大小

           byte dates[]=new byte[1024*8];
           int len=0;
           //写入文件
           while((len=fileInputStream.read(dates))!=-1){
               fileOutputStream.write(dates,0,len);
           }
           //释放缓存
           fileInputStream.close();
           fileOutputStream.close();
       }
       File file1=new File(path+ "/ueditor/jsp/upload/tmp/" +dir);
       //删除临时文件夹下面的图片
       if(file1.isDirectory()){
           for (File f:file1.listFiles()){
               f.delete();
           }
           file1.delete();
           System.out.println("已经删除临时文件");
       }

  System.out.println( upfile.replace("tmp","image"));
        Details d=new Details();
        d.setValue(upfile.replace("tmp","image"));
        detailsService.save(d);
      SimpleDateFormat da=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

      Text t=new Text();
      t.setTitle(title);
      t.setClassify(classifyService.findById(classify));
      t.setLabel(labelService.findById(label));
      t.setCopyright(copyright);
      t.setState(stateService.findById("1"));
      t.setDetails(d);
      t.setDate(new Date());
      t.setVisit_times(0);
      text.save(t);
      Blog b=blog.findById(username);
      List<Text> list=b.getText();
      list.add(t);
      b.setText(list);
      blog.save(b);
      request.getSession().setAttribute("mes","Edit success");
      return "redirect:../action/write";
  }
}



