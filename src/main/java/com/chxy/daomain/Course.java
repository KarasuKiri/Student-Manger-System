package com.chxy.daomain;

/**
 * Course 对象和 course表的记录对应
 *
 * @author chxy
 * @version 1.0
 */
public class Course {

    /*
     * cno：课程编号
     * cname：课程名
     * credit：学分
     */
    private String cno;
    private String cname;
    private Double credit;

    public Course() {
    }

    public Course(String cno, String cname, Double credit) {
        this.cno = cno;
        this.cname = cname;
        this.credit = credit;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return ", cname='" + cname + '\'';
    }

}
