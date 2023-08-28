package com.chxy.view;

import com.chxy.daomain.Course;
import com.chxy.daomain.Grade;
import com.chxy.daomain.User;
import com.chxy.service.*;
import com.chxy.utils.Utility;

import java.util.List;

/**
 * 主界面
 *
 * @author chxy
 * @version 1.0
 */
public class SMSView {

    /*
     * loop：控制是否退出菜单
     * key：接收用户的选择
     * id：账号
     * password：密码
     * choice：确认选项
     * userService：UserService 对象
     * gradeService：GradeService 对象
     * studentService：StudentService 对象
     * courseService：CourseService 对象
     * electiveService：ElectiveService对象
     */
    private boolean loop = true;
    private String key = "";
    private String id = "";
    private String password = "";
    private char choice;
    private UserService userService = new UserService();
    private GradeService gradeService = new GradeService();
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private ElectiveService electiveService = new ElectiveService();

    /**
     * 功能：显示主菜单
     */
    public void mainMenu() {
        while (loop) {
            System.out.println("===============学生成绩学分制管理系统===============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 2 退出系统");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);
            switch (key) {
                case "1" -> {
                    System.out.print("请输入账号：");
                    id = Utility.readString(20);

                    System.out.print("请输入密码：");
                    password = Utility.readString(32);

                    User user = userService.getUserByIdAndPassword(id, password);
                    if (user != null) { //说明该用户存在
                        System.out.println("===============登录成功[" + user.getId() + "]===============\n");
                        subMenu();
                    } else {
                        System.out.println("===============登录失败===============\n");
                    }
                }
                case "2" -> {
                    choice = Utility.readConfirmSelection();
                    if (choice == 'Y') {
                        loop = false; //退出系统
                    }
                }
                default -> System.out.println("输入有误，请重新输入！");
            }
        }

        System.out.println("已成功退出系统");
    }

    /**
     * 功能：显示二级菜单
     */
    public void subMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("===============学生成绩学分制管理系统（二级菜单）===============");
            System.out.println("\t\t 1 查询学生成绩");
            System.out.println("\t\t 2 修改学生分数");
            System.out.println("\t\t 3 添加学生信息");
            System.out.println("\t\t 4 添加课程信息");
            System.out.println("\t\t 5 添加选课信息");
            System.out.println("\t\t 6 添加学生分数");
            System.out.println("\t\t 7 修改密码");
            System.out.println("\t\t 8 退出登录");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);
            switch (key) {
                case "1" -> {
                    System.out.print("请输入学号：");
                    String sno = Utility.readString(20);

                    List<Grade> grades = gradeService.getScoreAndGPABySno(sno);
                    if (grades.isEmpty()) {
                        System.out.println("记录不存在！");
                    } else {
                        String sname = studentService.getSnameBySno(sno);
                        List<Course> courses = courseService.getCnoAndCnameBySno(sno);
                        for (int i = 0; i < grades.size(); ++i) {
                            System.out.println("sname='" + sname + '\'' + courses.get(i) + grades.get(i));
                        }
                        System.out.println("===============显示完毕===============\n");
                    }
                }
                case "2" -> {
                    System.out.print("请输入学号：");
                    String sno = Utility.readString(20);

                    System.out.print("请输入课程编号：");
                    String cno = Utility.readString(20);

                    if (gradeService.getGradeBySnoAndCno(sno, cno).isEmpty()) {
                        System.out.println("记录不存在！");
                    } else {
                        System.out.print("请输入新的分数：");
                        Double newScore = Utility.readDouble();

                        if (gradeService.changeScore(sno, cno, newScore) > 0) {
                            System.out.println("学生分数修改成功！");
                        } else {
                            System.out.println("学生分数修改失败！");
                        }
                    }
                }
                case "3" -> {
                    System.out.print("请输入学号：");
                    String sno = Utility.readString(20);

                    System.out.print("请输入姓名：");
                    String sname = Utility.readString(50);

                    if (studentService.add(sno, sname) > 0) {
                        System.out.println("学生信息添加成功！");
                    } else {
                        System.out.println("学生信息添加失败！");
                    }
                }
                case "4" -> {
                    System.out.print("请输入课程编号：");
                    String cno = Utility.readString(20);

                    System.out.print("请输入课程名：");
                    String cname = Utility.readString(100);

                    System.out.print("请输入课程学分：");
                    Double credit = Utility.readDouble();

                    if (courseService.add(cno, cname, credit) > 0) {
                        System.out.println("课程信息添加成功！");
                    } else {
                        System.out.println("课程信息添加失败！");
                    }
                }
                case "5" -> {
                    System.out.print("请输入学号：");
                    String sno = Utility.readString(20);

                    System.out.print("请输入课程编号：");
                    String cno = Utility.readString(20);

                    if (studentService.getSnameBySno(sno) == null) {
                        System.out.println("该学生不存在！");
                    } else if (courseService.getCourseByCno(cno) == null) {
                        System.out.println("该课程不存在！");
                    } else {
                        if (electiveService.add(sno, cno) > 0) {
                            System.out.println("选课信息添加成功！");
                        } else {
                            System.out.println("选课信息添加失败！");
                        }
                    }
                }
                case "6" -> {
                    System.out.print("请输入学号：");
                    String sno = Utility.readString(20);

                    System.out.print("请输入课程编号：");
                    String cno = Utility.readString(20);

                    if (electiveService.getElectiveBySnoAndCno(sno, cno) != null) {
                        Double score = Utility.readDouble();
                        if (gradeService.add(sno, cno, score) > 0) {
                            System.out.println("学生分数添加成功！");
                        } else {
                            System.out.println("学生分数添加失败！");
                        }
                    } else {
                        System.out.println("无该选课信息");
                    }
                }
                case "7" -> {
                    System.out.print("请输入新密码：");
                    String newPassword = Utility.readString(32);

                    choice = Utility.readConfirmSelection();
                    if (choice == 'Y') {
                        if (newPassword.equals(password)) {
                            System.out.println("不能与旧密码相同！");
                        } else if (userService.changePassword(id, newPassword) != 0) {
                            System.out.println("密码修改成功！");
                        } else {
                            System.out.println("密码修改失败！");
                        }
                    } else {
                        System.out.println("密码未修改！");
                    }
                }
                case "8" -> {
                    choice = Utility.readConfirmSelection();
                    if (choice == 'Y') {
                        loop = false; //退出登录
                    }
                }
                default -> System.out.println("输入有误，请重新输入！");
            }
        }

        System.out.println();
    }

}
