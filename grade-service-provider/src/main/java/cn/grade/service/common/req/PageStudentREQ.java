package cn.grade.service.common.req;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-13 15:58
 **/

public class PageStudentREQ {

    //学生姓名
    private String sname;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    //学生学号
    private String sno;

    //当前页数
    private Integer pageNow;

    //每页长度
    private Integer pageSize;


    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageStudentREQ{" +
                "name='" + sname + '\'' +
                ", sno='" + sno + '\'' +
                ", pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                '}';
    }
}
