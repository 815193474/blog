package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.bigeye.blog.vo.Admin;

import java.io.Serializable;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:18
 */
public interface AdminDao extends JpaRepository<Admin, Serializable> {
}
