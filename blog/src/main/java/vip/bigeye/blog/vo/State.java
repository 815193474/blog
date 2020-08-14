package vip.bigeye.blog.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name="id",columnDefinition="varchar(10) comment 'id'")
    private String id;
    @Column(nullable=false,columnDefinition="int(10) comment '值'")
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", state=" + state +
                '}';
    }
}