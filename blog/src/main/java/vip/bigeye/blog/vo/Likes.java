package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "likes")
public class Likes {


    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id",columnDefinition = "varchar(32) comment '编号'")
    private String id;
    @Column(nullable=false,columnDefinition="varchar(64) comment '点赞者'")
    private String ip;
    @Column(nullable=false,columnDefinition="datetime comment '时间'")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Like{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", date=" + date +
                '}';
    }
}