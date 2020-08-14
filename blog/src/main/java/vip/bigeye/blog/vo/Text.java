package vip.bigeye.blog.vo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "text")
public class Text {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    @Column(name = "id",columnDefinition = "varchar(32) comment '编号'")
    private String id;
    @JoinColumn(name = "classify")
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private Classify classify;
    @Column(nullable=false,columnDefinition="varchar(20) comment '标题'")
    private String title;
    @Column(nullable=false,columnDefinition="datetime comment '时间'")
    private Date date;
    @JoinColumn(name = "details")
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private Details details;
    @Column(nullable=true,columnDefinition="int(20) comment '浏览次数'")
    private Integer visit_times;
    @JoinColumn(name = "likes")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Likes> likes;
    @JoinColumn(name = "comment")
    @OneToMany
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Comment> comment;

    @Column(nullable=false,columnDefinition="varchar(20) comment '版权'")
    private String copyright;
    @JoinColumn(name = "label")
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private Label label;
    @JoinColumn(name = "state")
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private State state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }



    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }


    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }



    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public Integer getVisit_times() {
        return visit_times;
    }

    public void setVisit_times(Integer visit_times) {
        this.visit_times = visit_times;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id='" + id + '\'' +
                ", classify=" + classify +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", details=" + details +
                ", visit_times=" + visit_times +
                ", likes=" + likes +
                ", comment=" + comment +
                ", copyright='" + copyright + '\'' +
                ", label=" + label +
                ", state=" + state +
                '}';
    }
}