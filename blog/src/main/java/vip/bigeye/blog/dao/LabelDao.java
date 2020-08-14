package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.bigeye.blog.vo.Label;
import vip.bigeye.blog.vo.Message;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:25
 */
public interface LabelDao extends JpaRepository<Label, Serializable> {
}
