package com.chxy.daomain;

/**
 * Grade 对象和 grade表的记录对应
 * @author chxy
 * @version 1.0
 */
public class Grade {

    /*
     * sno：学号
     * cno：课程编号
     * score：分数
     * gpa：绩点
     */
    private String sno;
    private String cno;
    private Double score;
    private Double gpa;

    public Grade() {
    }

    public Grade(String sno, String cno, Double score, Double gpa) {
        this.sno = sno;
        this.cno = cno;
        this.score = score;
        this.gpa = gpa;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", score=" + score +
                ", gpa=" + gpa +
                '}';
    }
}
