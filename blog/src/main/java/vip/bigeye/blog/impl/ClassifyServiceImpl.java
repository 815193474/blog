package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.ClassifyDao;
import vip.bigeye.blog.service.ClassifyService;
import vip.bigeye.blog.vo.Classify;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 17:33
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyDao classifyDao;

    @Override
    public boolean deleteById(String id) {
        try{
            classifyDao.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Classify o) {
classifyDao.save(o);
    }

    @Override
    public Classify findById(String id) {
        return classifyDao.findOne(id);
    }

    @Override
    public List<Classify> findAll() {
        return classifyDao.findAll();
    }


}
