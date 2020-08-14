package vip.bigeye.blog.vo;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "blog")
public class Blog {
    @Id
    @Column(name = "username",columnDefinition = "varchar(20) comment'用户名'")
    private String username;
    @Column(nullable=false,columnDefinition="varchar(20) comment '密码'")
    private String passwd;
    @Column(nullable=false,columnDefinition="varchar(20) comment '昵称'")
    private String name;
    @Column(nullable=true,columnDefinition="varchar(255) comment '头像'")
    private String logo;
    @Column(nullable=false,columnDefinition="varchar(20) comment '性别'")
    private String sex;
    @Column(nullable=false,columnDefinition="varchar(20) comment 'QQ号'")
    private String qq_Number;
    @Column(nullable=true,columnDefinition="varchar(255) comment '兴趣'")
    private String interest;
    @Column(nullable=true,columnDefinition="varchar(255) comment '签名'")
    private String sign;
    @Column(nullable=true,columnDefinition="varchar(20) comment '活跃值'")
    private Integer active;
    @JoinColumn(name = "state")
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private State state;
    @JoinColumn(name = "message")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Message> message;
    @JoinColumn(name = "news")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<News> news;
    @JoinColumn(name = "classify")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Classify> classify;
    @JoinColumn(name = "label")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Label> label;
    @JoinColumn(name = "text")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Text> text;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQq_Number() {
        return qq_Number;
    }

    public void setQq_Number(String qq_Number) {
        this.qq_Number = qq_Number;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Classify> getClassify() {
        return classify;
    }

    public void setClassify(List<Classify> classify) {
        this.classify = classify;
    }

    public List<Label> getLabel() {
        return label;
    }

    public void setLabel(List<Label> label) {
        this.label = label;
    }

    public List<Text> getText() {
        return text;
    }

    public void setText(List<Text> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", sex='" + sex + '\'' +
                ", qq_Number=" + qq_Number +
                ", interest='" + interest + '\'' +
                ", sign='" + sign + '\'' +
                ", active=" + active +
                ", state=" + state +
                ", message=" + message +
                ", news=" + news +
                ", classify=" + classify +
                ", label=" + label +
                ", text=" + text +
                '}';
    }
}