package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.TextDao;
import vip.bigeye.blog.service.TextService;
import vip.bigeye.blog.vo.Text;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 10:44
 */
@Service
public class TextServiceImpl implements TextService {
    @Autowired
    private TextDao text;


    @Override
    public boolean deleteById(String id) {
        try{
            text.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Text o) {
    text.save(o);
    }

    @Override
    public Text findById(String id) {
        return text.findOne(id);
    }

    @Override
    public List<Text> findAll() {
        return text.findAll();
    }


    @Override
    public Text findByComment(String id) {
        return text.findByCommentId(id);
    }
}
