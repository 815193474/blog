package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.LabelDao;
import vip.bigeye.blog.service.LabelService;
import vip.bigeye.blog.vo.Label;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-29 12:03
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDao label;
    @Override
    public boolean deleteById(String id) {
        try{
            label.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Label o) {
label.save(o);
    }

    @Override
    public Label findById(String id) {
        return label.findOne(id);
    }

    @Override
    public List<Label> findAll() {
        return label.findAll();
    }

}
