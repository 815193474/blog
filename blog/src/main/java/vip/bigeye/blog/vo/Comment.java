package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id",columnDefinition = "varchar(32) comment '编号'")
    private String id;
    @Column(nullable=false,columnDefinition="varchar(20) comment '评论人'")
    private String name;
    @Column(nullable=false,columnDefinition="varchar(255) comment '内容'")
    private String details;
    @Column(nullable=false,columnDefinition="datetime comment '时间'")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", date=" + date +
                '}';
    }
}