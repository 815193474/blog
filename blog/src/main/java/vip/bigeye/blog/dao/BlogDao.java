package vip.bigeye.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vip.bigeye.blog.vo.Blog;

import java.io.Serializable;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:22
 */
public interface BlogDao extends JpaRepository<Blog, Serializable> {
}
