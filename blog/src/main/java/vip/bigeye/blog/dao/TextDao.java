package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vip.bigeye.blog.vo.Text;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:28
 */
public interface TextDao extends JpaRepository<Text, Serializable> {
    List<Text> findAll();
    Text findByCommentId(String id);

}
