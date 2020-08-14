package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.CommentDao;
import vip.bigeye.blog.service.CommentService;
import vip.bigeye.blog.vo.Comment;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 10:00
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao comment;


    @Override
    public boolean deleteById(String id) {
        try{
            comment.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Comment o) {
    comment.save(o);
    }

    @Override
    public Comment findById(String id) {
        return comment.findOne(id);
    }

    @Override
    public List<Comment> findAll() {
        return comment.findAll();
    }


}
