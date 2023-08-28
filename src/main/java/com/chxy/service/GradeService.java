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

    /**
     * 功能：通过学号获取学生所修课程的分数与对应绩点
     *
     * @param sno 学号
     * @return 分数与绩点
     */
    public List<Grade> getScoreAndGPABySno(String sno) {
        String sql = "select score, gpa from Grade where sno = ?";
        return gradeDAO.queryMulti(sql, Grade.class, sno);
    }

    /**
     * 功能：通过学号与课程编号获取对应成绩信息
     *
     * @param sno 学号
     * @param cno 课程编号
     * @return Grade 对象对应的集合
     */
    public List<Grade> getGradeBySnoAndCno(String sno, String cno) {
        String sql = "select * from Grade where sno = ? and cno = ?";
        return gradeDAO.queryMulti(sql, Grade.class, sno, cno);
    }

    /**
     * 功能：根据sno 和 cno 修改学生对应课程的分数
     *
     * @param sno      学号
     * @param cno      课程编号
     * @param newScore 新的分数
     * @return 若大于0则操作成功
     */
    public int changeScore(String sno, String cno, Double newScore) {
        String sql = "update Grade set score = ? where sno = ? and cno = ?";
        return gradeDAO.update(sql, newScore, sno, cno);
    }

    /**
     * 功能：添加学生分数
     *
     * @param sno   学号
     * @param cno   课程编号
     * @param score 分数
     * @return 若大于0则操作成功
     */
    public int add(String sno, String cno, Double score) {
        String sql = "insert into Grade values (?, ?, ?)";
        return gradeDAO.update(sql, sno, cno, score);
    }

}
