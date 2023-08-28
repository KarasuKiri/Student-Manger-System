package com.chxy.utils;

import java.io.Console;
import java.util.Scanner;

/**
 * @author chxy
 * @version 1.0
 */
public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 功能：读取键盘输入的一个菜单选项，值：1——5的范围
     *
     * @return 1——5
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false); //包含一个字符
            c = str.charAt(0); //将字符串转换成字符char类型
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }

        return c;
    }

    /**
     * 功能：读取键盘输入的一个字符
     *
     * @return 一个字符
     */
    public static char readChar() {
        String str = readKeyBoard(1, false); //一个字符
        return str.charAt(0);
    }

    /**
     * 功能：读取键盘输入的一个字符，如果直接回车，则返回指定的默认值
     *
     * @param defaultValue 指定的默认值
     * @return 默认值或输入的字符
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true); //要么是空字符串，要么是一个字符
        return (str.isEmpty()) ? defaultValue : str.charAt(0);
    }

    /**
     * 功能：读取键盘输入的浮点数，长度小于4位
     *
     * @return 浮点数
     */
    public static double readDouble() {
        double n;
        for (; ; ) {
            String str = readKeyBoard(4, false); //一个浮点数，长度小于4位
            try {
                n = Double.parseDouble(str); //将字符串转换成浮点数
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }

        return n;
    }

    /**
     * 功能：读取键盘输入的浮点数或默认值，如果直接回车，则返回默认值，否则返回输入的浮点数
     *
     * @param defaultValue 指定的默认值
     * @return 浮点数或默认值
     */
    public static double readDouble(Double defaultValue) {
        double n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.isEmpty()) {
                return defaultValue;
            }

            try {
                n = Double.parseDouble(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }

        return n;
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串
     *
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串或默认值，如果直接回车，则返回默认值
     *
     * @param limit        限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串或默认值
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.isEmpty() ? defaultValue : str;
    }

    /**
     * 功能：读取键盘输入的确认选项，Y或N
     *
     * @return Y或N
     */
    public static char readConfirmSelection() {
        System.out.print("确认执行？(Y/N)：");
        char choice;
        for (; ; ) {
            String input = readKeyBoard(1, false).toUpperCase(); //y => Y, n => N
            choice = input.charAt(0);
            if (choice == 'Y' || choice == 'N') {
                break;
            } else {
                System.out.print("无效的输入，请重新输入：");
            }
        }
        return choice;
    }

    /**
     * 功能：读取一个字符串
     *
     * @param limit       读取的长度
     * @param blankReturn 如果为true，表示可以读空字符串；
     *                    <p>如果为false，表示不能读空字符串。</p>
     *                    <p>如果输入为空，或者输入大于 limit的长度，就会提示重新输入。</p>
     * @return 字符串
     */
    public static String readKeyBoard(int limit, boolean blankReturn) {
        String line = ""; //初始化字符串为空

        while (scanner.hasNextLine()) { //scanner.hasNextLine() 判断有没有下一行
            line = scanner.nextLine(); //读取当前行

            //如果line为空，即用户没有输入任何内容，直接回车
            if (line.isEmpty()) {
                if (blankReturn) {
                    return line; //如果blankReturn为true，可以返回空串
                } else {
                    System.out.print("输入不能为空，请重新输入：");
                    continue; //如果blankReturn为false，不接受空串，必须输入内容
                }
            }

            //如果用户输入的内容为空或者长度大于 limit，则提示重新输入
            //如果用户输入的内容非空且长度 <= limit，就接受
            if (line.length() > limit) {
                System.out.print("输入长度（不能大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }

    /**
     * 功能：隐式的读入密码再返回给变量存储
     *
     * @param limit 限制的长度
     * @return 字符串
     */
    public static String readPasswordFromConsole(int limit) {
        Console console = System.console();
        if (console == null) {
            System.out.println("\n无法获取控制台对象，无法隐藏密码输入。");
            return null;
        }

        String password = "";
        for (; ; ) {
            char[] passwordChars = console.readPassword();
            password = new String(passwordChars);

            if (password.isEmpty()) {
                System.out.print("密码不能为空，请重新输入：");
                continue;
            }

            if (password.length() > limit) {
                System.out.print("密码长度不能大于 " + limit + "，请重新输入：");
                continue;
            }

            break;
        }

        return password;
    }

}
