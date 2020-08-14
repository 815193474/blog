package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.DetailsDao;
import vip.bigeye.blog.service.DetailsService;
import vip.bigeye.blog.vo.Details;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 10:24
 */
@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private DetailsDao details;


    @Override
    public boolean deleteById(String id) {
        try{
            details.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Details o) {
details.save(o);
    }

    @Override
    public Details findById(String id) {
        return details.findOne(id);
    }

    @Override
    public List<Details> findAll() {
        return details.findAll();
    }
}
