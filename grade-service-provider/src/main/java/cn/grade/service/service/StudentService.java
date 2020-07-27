package cn.grade.service.service;

import cn.grade.service.common.req.PageStudentREQ;
import cn.grade.service.common.resq.PageStudentRESQ;
import cn.grade.service.dao.StudentDao;
import cn.grade.service.entity.R;
import cn.grade.service.entity.Score;
import cn.grade.service.entity.Student;
import cn.grade.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: grade-service-provider
 * @author: Mr.M
 * @create: 2020-07-14
 **/
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentDao studentDao;

    public Student queryById(Long id) {
        return this.studentMapper.selectByPrimaryKey(id);
    }


    /*分页学生成绩以及根据姓名与学号查询*/
    public R findAllBySnameContainingAndSnoContaining(PageStudentREQ req) {

        //获取每页条数
        req.setPageSize(req.getPageSize() < 1 ? 3 : req.getPageSize());
        //获取起始页
        req.setPageNow(req.getPageNow() < 1 ? 0 : (req.getPageNow() - 1));
        //定义分页条件
        System.out.println("service分页："+req.getPageNow());
        PageRequest pageRequest = PageRequest.of(req.getPageNow(), req.getPageSize());
        System.out.println(req.getPageNow()+"----------"+req.getPageSize());

        //获取分页数据
        //在jpa方法调用中，由于传进来的数据不能为null,所以将其设置为""
        if(req.getSname() == null) {
            req.setSname("");
        }
        if(req.getSno()==null) {
            req.setSno("");
        }
        Page<Student> page = studentDao.findAllBySnameContainingAndSnoContaining(req.getSname(), req.getSno(), pageRequest);
        //System.out.println("stuName:"+req.getStuName()+"------------"+"stuNo:"+req.getStuNo());
        //新建一个map集合，用来存放返回的数据
        Map map = new HashMap<>();
        //新建一个科目的集合，用来存放所有的科目
        Set courseNames = new HashSet<>();
        //将分页总条数放入map集合中
        map.put("count",page.getTotalElements());
        //创建一个PageStudentRESQ集合
        List<PageStudentRESQ> resqList = new ArrayList<>();
        //定义一个PageStudentRESQ对象
        PageStudentRESQ resq;
        //定义一个成绩的集合
        Map scoreMap;
        //循环分页数据中的list
        for (Student s:page.getContent()) {
            resq = new PageStudentRESQ();
            scoreMap = new HashMap();
            // 将获取到的学生信息赋值到resq中
            resq.setId(s.getId());
            resq.setSname(s.getSname());
            resq.setSno(s.getSno());

            int score = 0;
            // 将成绩循环放入成绩集合中
            for (Score h:s.getScores()) {
                //通过键值对的方式存入成绩
                scoreMap.put(h.getCname(),h.getFraction());
                //通过set集合的特性存入科目名称并去重
                courseNames.add(h.getCname());
                //计算学生总分
                score += h.getFraction();
            }
            resq.setScore(score);
            //将成绩存入resq中
            resq.setScores(scoreMap);
            //将赋值后的StudentPageRESQ放入resqList中
            resqList.add(resq);
        }
        //将分页数据存入map中
        map.put("list",resqList);
        //将所有科目的名称的集合存入map中
        map.put("courseNames",courseNames);
        //System.out.println("map:"+map);
        return R.ok().data("map",map);
    }


    @Transactional
    /*新增或修改学生成绩*/
    public R add(Student stu){

        /*遍历获取学生相应科目成绩*/
        Set<Score> scores =stu.getScores();
        scores.forEach(h->{
            h.setStudent(stu);
        });

        /*保存新增或者修改后的学生信息*/
        Student save = studentDao.save(stu);
        return R.ok().data("stu",save);

    }

    /**
    * @Author: M
    * @Description: 根据ID查询学生信息
    * @DateTime: 2020/7/14
    * @Params: [id]
    * @Return cn.grade.service.entity.R
    */
    public R findById(Long id) {
        Student one = studentDao.getOne(id);

        return R.ok().data("one",one);
    }

    /**
    * @Author: M
    * @Description: 根据id删除
    * @DateTime: 2020/7/14
    * @Params: [id]
    * @Return void
    */
    public boolean del(Long id){
        studentDao.deleteById(id);
        return true;
    }

    /**
    * @Author: M
    * @Description: 检查学号是否存在
    * @DateTime: 2020/7/14
    * @Params: [sno]
    * @Return boolean
    */
    public boolean stuNoValid(String sno){
        //调用学号的接口
        Student stu = studentDao.findBySno(sno);
        //如果返回值为空，说明不存在该学号，则返回true
        if(stu == null) {
            return true;
        }else {
            //如果返回值不为空，则已经存在该学号，则返回false
            return false;
        }
    }


}
