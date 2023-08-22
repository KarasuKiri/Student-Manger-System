package com.chxy.view;

import com.chxy.utils.Utility;

/**
 * 主界面
 * @author chxy
 * @version 1.0
 */
public class SMSView {

    /*
     * loop：控制是否退出菜单
     * key：接收用户的选择
     */
    private boolean loop = true;
    private String key = "";

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
                    String id = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String password = Utility.readString(50);
                    // TODO: 2023/8/21 到数据库去判断

                    if ("123456".equals(password)) {
                        System.out.println("===============登录成功===============\n");
                        subMenu();
                    } else {
                        System.out.println("===============登录失败===============\n");
                    }
                }
                case "2" -> {
                    char choice = Utility.readConfirmSelection();
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
     * 功能：二级菜单
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
                    // TODO: 2023/8/21 查询学生成绩的逻辑

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
                    String newPassword = Utility.readString(50);

                    char choice = Utility.readConfirmSelection();
                    if (choice == 'Y') {
                        // TODO: 2023/8/21 将新密码更新到数据库中

                        System.out.println("密码修改成功！");
                    } else {
                        System.out.println("密码未修改！");
                    }
                }
                case "7" -> {
                    char choice = Utility.readConfirmSelection();
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
