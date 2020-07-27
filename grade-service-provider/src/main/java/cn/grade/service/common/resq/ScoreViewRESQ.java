package cn.grade.service.common.resq;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-13 13:29
 **/

public class ScoreViewRESQ implements Serializable {

    private static final long serialVersionUID = -8553732962471374476L;

    // 学生姓名
    @Column(name = "sname")
    private String sname;

    // 学生学号
    @Column(name = "sno")
    private String sno;

    @Column(name = "cname")
    private String cname;       //课程名称

    @Column(name = "fraction")
    private String fraction;    //课程分数

    @Column(name = "sid")
    private Long sid;           //学生ID

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}
