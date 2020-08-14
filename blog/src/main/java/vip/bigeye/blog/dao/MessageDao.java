package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.bigeye.blog.vo.Message;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:26
 */
public interface MessageDao extends JpaRepository<Message, Serializable> {

}
