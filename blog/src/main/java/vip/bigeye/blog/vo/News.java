package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id",columnDefinition = "varchar(32) comment '编号'")
    private String id;
    @Column(nullable=false,columnDefinition="text comment '内容'")
    private String value;
    @Column(nullable=false,columnDefinition="varchar(32) comment '来自谁'")
    private String name;
    @Column(nullable=false,columnDefinition="varchar(32) comment '关联消息'")
    private String news_id;


    @Column(nullable=false,columnDefinition="datetime comment '时间'")
    private Date date;
    @Column(nullable=false,columnDefinition="varchar(20) comment '类型'")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", news_id='" + news_id + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}