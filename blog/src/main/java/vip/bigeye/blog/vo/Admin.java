package vip.bigeye.blog.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "admin")
public class Admin {
    @Id
    @Column(name="id",columnDefinition="varchar(50) comment '账号'")
    private String id;
    @Column(nullable=false,columnDefinition="varchar(20) comment '密码'")
    private String passwd;
    @Column(nullable=false,columnDefinition="varchar(20) comment '邮件'")
    private String email;
    @Column(nullable=true,columnDefinition="varchar(20) comment '头像'")
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", passwd='" + passwd + '\'' +
                ", email='" + email + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}