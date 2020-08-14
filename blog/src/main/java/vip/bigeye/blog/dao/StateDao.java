package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.bigeye.blog.vo.State;

import java.io.Serializable;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:28
 */
public interface StateDao extends JpaRepository<State, Serializable> {
}
