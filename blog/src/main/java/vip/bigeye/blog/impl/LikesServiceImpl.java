package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.LikesDao;
import vip.bigeye.blog.service.LikesService;
import vip.bigeye.blog.vo.Likes;


import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 10:33
 */
@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesDao likes;


    @Override
    public boolean deleteById(String id) {
        try{
            likes.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Likes o) {
likes.save(o);
    }

    @Override
    public Likes findById(String id) {
        return likes.findOne(id);
    }

    @Override
    public List<Likes> findAll() {
        return likes.findAll();
    }
}
