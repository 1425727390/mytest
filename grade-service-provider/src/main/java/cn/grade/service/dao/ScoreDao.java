package cn.grade.service.dao;

import cn.grade.service.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @program: grade-service-provider
 * @author: Mr.Mo
 * @create: 2020-07-13 11:25
 **/
@Repository
public interface ScoreDao extends JpaRepository<Score,Long>, JpaSpecificationExecutor<Score> {



}
