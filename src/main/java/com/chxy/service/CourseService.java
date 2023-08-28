package com.chxy.service;

import com.chxy.dao.CourseDAO;
import com.chxy.daomain.Course;

import java.util.List;

/**
 * 该类完成对course表的各种操作（通过调用CourseDAO对象完成）
 *
 * @author chxy
 * @version 1.0
 */
public class CourseService {

    private CourseDAO courseDAO = new CourseDAO();

    /**
     * 功能：通过学号查询学生所修课程的课程编号和课程名
     *
     * @param sno 学号
     * @return Course 对象对应的集合
     */
    public List<Course> getCnoAndCnameBySno(String sno) {
        String sql = "select cno, cname from Course where cno in (select cno from Elective where sno = ?)";
        return courseDAO.queryMulti(sql, Course.class, sno);
    }

    /**
     * 功能：根据 cno 获取 Course对象
     *
     * @param cno 课程编号
     * @return Course对象
     */
    public Course getCourseByCno(String cno) {
        String sql = "select * from Course where cno = ?";
        return courseDAO.querySingle(sql, Course.class, cno);
    }

    /**
     * 功能：添加课程信息
     *
     * @param cno    课程编号
     * @param cname  课程名
     * @param credit 学分
     * @return 若大于0则操作成功
     */
    public int add(String cno, String cname, Double credit) {
        String sql = "insert into Course values (?, ?, ?)";
        return courseDAO.update(sql, cno, cname, credit);
    }

}
