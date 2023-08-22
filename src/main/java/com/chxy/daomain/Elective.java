package com.chxy.daomain;

/**
 * Elective 对象和 elective表的记录对应
 * @author chxy
 * @version 1.0
 */
public class Elective {

    /*
     * sno：学号
     * cno：课程编号
     */
    private String sno;
    private String cno;

    public Elective() {
    }

    public Elective(String sno, String cno) {
        this.sno = sno;
        this.cno = cno;
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

    @Override
    public String toString() {
        return "Elective{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                '}';
    }
}
