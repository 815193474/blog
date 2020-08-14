package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-08-28 22:00
 */

@Entity
@Table(name= "label")
public class Label {

        @Id
        @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
        @GeneratedValue(generator = "hibernate-uuid")
        @Column(name = "id",columnDefinition = "varchar(32) comment '编号'")
        private String id;
        @Column(nullable=false,columnDefinition="varchar(20) comment '名称'")
        private String name;

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

    @Override
    public String toString() {
        return "Label{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
