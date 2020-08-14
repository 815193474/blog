package vip.bigeye.blog.util;

import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Controller;
import vip.bigeye.blog.vo.Comment;
import vip.bigeye.blog.vo.Message;
import vip.bigeye.blog.vo.News;
import vip.bigeye.blog.vo.Text;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-09-01 17:36
 */
@Controller
public class Sort  {

    public  List<Text> ListSort(List<Text> list) {
        Collections.sort(list, new Comparator<Text>() {
            public int compare(Text dt1, Text dt2) {

                try {
                    if (dt1.getDate().before(dt2.getDate())) {
                        return 1;
                    } else if (dt1.getDate().after(dt2.getDate())) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e+"时间排序查询异常");
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return list;
    }

//留言的日期排序
    public  List<Message> ListSortMessage(List<Message> list) {
        Collections.sort(list, new Comparator<Message>() {
            public int compare(Message dt1, Message dt2) {

                try {
                    if (dt1.getDate().before(dt2.getDate())) {
                        return 1;
                    } else if (dt1.getDate().after(dt2.getDate())) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e+"时间排序查询异常");
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return list;
    }



    //评论的日期排序
    public  List<Comment> ListSortComment(List<Comment> list) {
        Collections.sort(list, new Comparator<Comment>() {
            public int compare(Comment dt1, Comment dt2) {

                try {
                    if (dt1.getDate().before(dt2.getDate())) {
                        return 1;
                    } else if (dt1.getDate().after(dt2.getDate())) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e+"时间排序查询异常");
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return list;
    }


    //消息的日期排序
    public  List<News> ListSortNews(List<News> list) {
        Collections.sort(list, new Comparator<News>() {
            public int compare(News dt1, News dt2) {

                try {
                    if (dt1.getDate().before(dt2.getDate())) {
                        return 1;
                    } else if (dt1.getDate().after(dt2.getDate())) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e+"时间排序查询异常");
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return list;
    }
}
