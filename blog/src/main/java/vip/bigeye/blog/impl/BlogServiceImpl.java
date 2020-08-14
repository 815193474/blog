package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.BlogDao;
import vip.bigeye.blog.service.BlogService;
import vip.bigeye.blog.vo.Blog;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-21 11:37
 */
@Service
public class BlogServiceImpl  implements BlogService {
    @Autowired
    private BlogDao blog;


    @Override
    public boolean deleteById(String id) {
        try{
            blog.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Blog o) {
blog.save(o);
    }

    @Override
    public Blog findById(String id) {
        return blog.findOne(id);
    }

    @Override
    public List<Blog> findAll() {
        return blog.findAll();
    }
}
