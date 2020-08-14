package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import vip.bigeye.blog.dao.NewsDao;
import vip.bigeye.blog.service.NewsService;
import vip.bigeye.blog.vo.News;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 10:41
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;


    @Override
    public boolean deleteById(String id) {
        try{
            newsDao.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(News o) {
newsDao.save(o);
    }

    @Override
    public News findById(String id) {
        return newsDao.findOne(id);
    }

    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }


}
