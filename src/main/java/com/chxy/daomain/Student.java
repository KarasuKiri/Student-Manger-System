package com.chxy.daomain;

/**
 * Student 对象和 student表的记录对应
 * @author chxy
 * @version 1.0
 */
public class Student {

    /*
     * sno：学号
     * sname：学生姓名
     */
    private String sno;
    private String sname;

    public Student() { //反射需要
    }

    public Student(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
