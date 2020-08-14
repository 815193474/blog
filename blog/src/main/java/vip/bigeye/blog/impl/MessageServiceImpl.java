package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.MessageDao;
import vip.bigeye.blog.service.MessageService;
import vip.bigeye.blog.vo.Message;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 10:39
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao message;


    @Override
    public boolean deleteById(String id) {
        try{
            message.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Message o) {
message.save(o);
    }

    @Override
    public Message findById(String id) {
        return message.findOne(id);
    }

    @Override
    public List<Message> findAll() {
        return message.findAll();
    }


}
