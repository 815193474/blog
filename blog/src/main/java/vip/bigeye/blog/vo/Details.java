package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name = "Details")
public class Details {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id",columnDefinition = "varchar(32) comment '编号'")
    private String id;
    @Column(nullable=false,columnDefinition="longtext comment '内容'")
    private String value;
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

    @Override
    public String toString() {
        return "Details{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}