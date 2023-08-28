package com.chxy.service;

import com.chxy.dao.StudentDAO;

/**
 * 该类完成对student表的各种操作（通过调用StudentDAO对象完成）
 *
 * @author chxy
 * @version 1.0
 */
public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    /**
     * 功能：根据 sno 获取学生姓名
     *
     * @param sno 学号
     * @return 学生姓名
     */
    public String getSnameBySno(String sno) {
        String sql = "select sname from Student where sno = ?";
        return (String) studentDAO.queryScalar(sql, sno);
    }

    /**
     * 功能：添加学生信息
     *
     * @param sno   学号
     * @param sname 学生姓名
     * @return 若大于0则操作成功
     */
    public int add(String sno, String sname) {
        String sql = "insert into Student values (?, ?)";
        return studentDAO.update(sql, sno, sname);
    }

}
