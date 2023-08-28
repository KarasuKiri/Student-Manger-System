package com.chxy.service;

import com.chxy.dao.UserDAO;
import com.chxy.daomain.User;

/**
 * 该类完成对use表的各种操作（通过调用UseDAO对象完成）
 *
 * @author chxy
 * @version 1.0
 */
public class UserService {

    private UserDAO userDAO = new UserDAO();

    /**
     * 功能：根据id 和 password 返回一个Use对象
     * <p>如果查询不到，就返回null</p>
     *
     * @param id       用户输入的账号
     * @param password 用户输入的密码
     * @return Use对象
     */
    public User getUserByIdAndPassword(String id, String password) {
        String sql = "select * from `User` where id = ? and password = md5(?)";
        return userDAO.querySingle(sql, User.class, id, password);
    }

    /**
     * 功能：修改密码
     *
     * @param id          当前登录的账号
     * @param newPassword 用户输入的新密码
     * @return 若大于0则操作成功
     */
    public int changePassword(String id, String newPassword) {
        String sql = "update `User` set password = md5(?) where id = ?";
        return userDAO.update(sql, newPassword, id);
    }

}
