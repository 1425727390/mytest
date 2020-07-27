package cn.grade.service.dao;

import cn.grade.service.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-13 11:25
 **/
@Repository
public interface StudentDao extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {

    //带条件分页查询
    Page<Student> findAllBySnameContainingAndSnoContaining(String name, String sno, Pageable pageable);

    //根据学号查询学生是否存在
    Student findBySno(String sno);

}