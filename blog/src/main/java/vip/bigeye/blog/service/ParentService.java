package vip.bigeye.blog.service;

import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-21 12:06
 */
public interface ParentService<Object,Serializable> {
  public boolean deleteById(String id);
  public void save(Object o);
  public Object findById(String id);
  public List<Object> findAll();
}
