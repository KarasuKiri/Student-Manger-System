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

    public List<Course> getCnameBySno(String sno) {
        String sql = "select cname from Course where cno in (select cno from Elective where sno = ?)";
        return courseDAO.queryMulti(sql, Course.class, sno);
    }

}
