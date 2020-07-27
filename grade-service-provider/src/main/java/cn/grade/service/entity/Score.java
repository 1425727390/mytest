package cn.grade.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-12 14:37
 **/
@Entity
@Table(name = "score")
@ApiModel(value="成绩表",description = "这是成绩表")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Score implements Serializable {

    private static final long SerialVersionUID = 1L;



//    @JsonFormat可以帮我们完成格式转换。例如对于Date类型字段，如果不适用JsonFormat默认在rest返回的是long
//    ，如果我们使用@JsonFormat(timezone = “GMT+8”, pattern = “yyyy-MM-dd HH:mm:ss”)
//    ，就返回"2018-11-16 22:58:15"




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;            //用户ID

    @Column(name = "cname")
    private String cname;       //用户姓名

    @Column(name = "fraction")
    private Integer fraction;    //课程分数


    //mappedBy = "Studeent" 用来级联
    @JsonIgnoreProperties(value={"scores"})
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name="sid",referencedColumnName = "id") //设置外键
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

}
