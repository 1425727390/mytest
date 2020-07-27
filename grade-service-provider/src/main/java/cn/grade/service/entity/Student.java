package cn.grade.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-11 16:45
 **/
@Entity
@Table(name = "student")
@ApiModel(value="学生表",description = "这是学生表")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 学生姓名
    @Column(name = "sname")
    private String sname;

    // 学生学号
    @Column(name = "sno")
    private String sno;

    //targetEntity属性表示默认关联的实体类型，默认为当前标注的实体类；
    //cascade属性表示与此实体一对一关联的实体的联级样式类型。联级样式上当对实体进行操作时的策略。
    //·CascadeType.PERSIST （级联新建）
    //·CascadeType.REMOVE （级联删除）
    //·CascadeType.REFRESH （级联刷新）
    //·CascadeType.MERGE （级联更新）中选择一个或多个。
    //·还有一个选择是使用CascadeType.ALL ，表示选择全部四项

    //fetch属性是该实体的加载方式，有两种：LAZY和EAGER。

    //optional属性表示关联的实体是否能够存在null值。默认为true，表示可以存在null值。如果为false，则要同时配合使用@JoinColumn标记。

    //mappedBy属性用于双向关联实体时，标注在不保存关系的实体中。

    @OneToMany(targetEntity = Score.class,mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Score> scores = new HashSet<>();

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

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}
