package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id", columnDefinition = "varchar(32) comment '编号'")
    private String id;
    @Column(nullable = false, columnDefinition = "varchar(64) comment '留言者邮箱'")
    private String email;
    @Column(nullable = false, columnDefinition = "text comment '内容'")
    private String value;
    @Column(nullable = false, columnDefinition = "datetime comment '时间'")
    private Date date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", value='" + value + '\'' +
                ", date=" + date +
                '}';
    }
}