package cn.grade.service.common.resq;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-13 16:03
 **/
public class PageStudentRESQ {

    //编号ID
    private Long id;

    //学生姓名
    private String sname;

    //学生学号
    private String sno;


    //总成绩
    private Integer score;

    //
    private Map scores = new HashMap();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Map getScores() {
        return scores;
    }

    public void setScores(Map scores) {
        this.scores = scores;
    }
}
