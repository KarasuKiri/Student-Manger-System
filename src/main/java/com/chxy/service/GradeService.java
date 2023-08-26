package com.chxy.service;

import com.chxy.dao.GradeDAO;
import com.chxy.daomain.Grade;

import java.util.List;

/**
 * 该类完成对grade表的各种操作（通过调用GradeDAO对象完成）
 *
 * @author chxy
 * @version 1.0
 */
public class GradeService {

    private GradeDAO gradeDAO = new GradeDAO();

    public List<Grade> getScoreAndGpaBySno(String sno) {
        String sql = "select score, gpa from Grade where sno = ?";
        return gradeDAO.queryMulti(sql, Grade.class, sno);
    }

}
