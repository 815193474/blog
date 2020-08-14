package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.bigeye.blog.vo.Details;

import java.io.Serializable;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:25
 */
public interface DetailsDao extends JpaRepository<Details, Serializable> {
}
