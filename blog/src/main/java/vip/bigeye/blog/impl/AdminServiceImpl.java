package vip.bigeye.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.bigeye.blog.dao.AdminDao;
import vip.bigeye.blog.service.AdminService;
import vip.bigeye.blog.vo.Admin;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:42
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao admin;

    @Override
    public boolean deleteById(String id) {
        try{
            admin.delete(id);
        }catch(Exception e){
            System.out.println("delete fail");
            return false;
        }
        return true;
    }

    @Override
    public void save(Admin o) {
        admin.save(o);
    }

    @Override
    public Admin findById(String id) {
        return admin.findOne(id);
    }

    @Override
    public List<Admin> findAll() {
        return admin.findAll();
    }


}
