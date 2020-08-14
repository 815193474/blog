package vip.bigeye.blog.service;

import org.springframework.data.jpa.repository.Query;
import vip.bigeye.blog.vo.Text;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-26 09:55
 */
public interface TextService extends ParentService<Text,Serializable> {
    Text findByComment(String id);

}
