package com.chxy.service;

import com.chxy.dao.ElectiveDAO;
import com.chxy.daomain.Elective;

/**
 * 该类完成对elective表的各种操作（通过调用ElectiveDAO对象完成）
 *
 * @author chxy
 * @version 1.0
 */
public class ElectiveService {

    private ElectiveDAO electiveDAO = new ElectiveDAO();

    /**
     * 功能：根据 sno 和 cno 查询有无选课记录
     *
     * @param sno 学号
     * @param cno 课程编号
     * @return Elective对象
     */
    public Elective getElectiveBySnoAndCno(String sno, String cno) {
        String sql = "select * from Elective where sno = ? and cno = ?";
        return electiveDAO.querySingle(sql, Elective.class, sno, cno);
    }

    /**
     * 功能：添加选课信息
     *
     * @param sno 学号
     * @param cno 课程编号
     * @return 若大于0则操作成功
     */
    public int add(String sno, String cno) {
        String sql = "insert into Elective values (?, ?)";
        return electiveDAO.update(sql, sno, cno);
    }

}
