package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vip.bigeye.blog.vo.Likes;

import java.io.Serializable;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:26
 */
public interface LikesDao extends JpaRepository<Likes, Serializable> {
}
