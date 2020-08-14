package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import vip.bigeye.blog.vo.Message;
import vip.bigeye.blog.vo.News;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:27
 */
public interface NewsDao extends JpaRepository<News, Serializable> {
}
