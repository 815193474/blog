package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.StateDao;
import vip.bigeye.blog.service.StateService;
import vip.bigeye.blog.vo.State;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-21 12:04
 */
@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateDao state;


    @Override
    public boolean deleteById(String id) {
        try{
            state.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(State o) {
state.save(o);
    }

    @Override
    public State findById(String id) {
        return state.findOne(id);
    }

    @Override
    public List<State> findAll() {
        return state.findAll();
    }
}
