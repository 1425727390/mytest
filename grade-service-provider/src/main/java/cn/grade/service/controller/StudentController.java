package cn.grade.service.controller;

import cn.grade.service.common.req.PageStudentREQ;
import cn.grade.service.entity.R;
import cn.grade.service.entity.Student;
import cn.grade.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-11 16:44
 **/
@RestController
@RequestMapping("student/")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
    * @Author: M
    * @Description: 根据id查询，此方法调用mybatis实现
    * @DateTime: 2020/7/14
    * @Params: [id]
    * @Return cn.grade.service.entity.Student
    */
    @GetMapping("getByid/{id}")
    public Student queryById(@PathVariable("id") Long id) {
        return this.studentService.queryById(id);
    }

    /**
    * @Author: M
    * @Description: 根据ID查询，此方法为JPA实现
    * @DateTime: 2020/7/14
    * @Params: [id]
    * @Return cn.grade.service.entity.R
    */
    @GetMapping("findByid/{id}")
    public R findById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }

    /**
    * @Author: M
    * @Description: 带条件分页查询
    * @DateTime: 2020/7/14
    * @Params: [current, limit, req]
    * @Return cn.grade.service.entity.R
    */
    @PostMapping("list/{current}/{limit}")
    public R list(@PathVariable int current, @PathVariable int limit,@RequestBody PageStudentREQ req){
        req.setPageNow(current);
        req.setPageSize(limit);
        System.out.println("开始页："+req.getPageNow());
        return studentService.findAllBySnameContainingAndSnoContaining(req);
    }

    /**
    * @Author: M
    * @Description: 添加或者更新操作
    * @DateTime: 2020/7/14
    * @Params: [stu]
    * @Return cn.grade.service.entity.R
    */
    @PostMapping("addOrUpdate")
    public R addOrUpdate(@RequestBody Student stu){
        return studentService.add(stu);
    }


    /**
    * @Author: M
    * @Description: 根据ID删除学生
    * @DateTime: 2020/7/14
    * @Params: [id]
    * @Return cn.grade.service.entity.R
    */
    @DeleteMapping("delete/{id}")
    public R deleteById(@PathVariable("id") Long id){
        if(studentService.del(id)){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
    * @Author: M
    * @Description: 验证学号是否存在
    * @DateTime: 2020/7/14
    * @Params: [sno]
    * @Return cn.grade.service.entity.R
    */
    @GetMapping("stuNoValid/{sno}")
    public R stuNoValid(@PathVariable String sno){
        //如果不存在，则为真，返回R.ok
        if(studentService.stuNoValid(sno)) {
            return R.ok().data("info","没有该用户");
        }else {
            //否则返回R.error()
            return R.error();
        }
    }


}
