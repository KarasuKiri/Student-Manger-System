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

    public String getSnameBySno(String sno) {
        String sql = "select sname from Student where sno = ?";
        return (String) studentDAO.queryScalar(sql, sno);
    }

}
