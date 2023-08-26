package com.chxy.view;

import com.chxy.daomain.Course;
import com.chxy.daomain.Grade;
import com.chxy.daomain.User;
import com.chxy.service.CourseService;
import com.chxy.service.GradeService;
import com.chxy.service.StudentService;
import com.chxy.service.UserService;
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
            System.out.println("\t\t 3 修改学生信息");
            System.out.println("\t\t 4 修改选课信息");
            System.out.println("\t\t 5 修改课程信息");
            System.out.println("\t\t 6 修改密码");
            System.out.println("\t\t 7 退出登录");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);
            switch (key) {
                case "1" -> {
                    System.out.print("请输入学号：");
                    String sno = Utility.readString(20);

                    List<Grade> grade = gradeService.getScoreAndGpaBySno(sno);
                    if (grade.isEmpty()) {
                        System.out.println("记录不存在！");
                    } else {
                        String sname = studentService.getSnameBySno(sno);
                        List<Course> cname = courseService.getCnameBySno(sno);
                        for (int i = 0; i < grade.size(); ++i) {
                            System.out.println("sname='" + sname + '\'' + cname.get(i) + grade.get(i));
                        }
                        System.out.println("===============显示完毕===============\n");
                    }
                }
                case "2" -> {
                    // TODO: 2023/8/21 修改学生分数的逻辑

                }
                case "3" -> {
                    // TODO: 2023/8/21 修改学生信息的逻辑

                }
                case "4" -> {
                    // TODO: 2023/8/21 修改选课信息的逻辑

                }
                case "5" -> {
                    // TODO: 2023/8/21 修改课程信息的逻辑

                }
                case "6" -> {
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
                case "7" -> {
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
