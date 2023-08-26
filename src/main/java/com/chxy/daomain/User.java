package com.chxy.daomain;

/**
 * User 对象和 use表的记录对应
 *
 * @author chxy
 * @version 1.0
 */
public class User {

    /*
     * id：账号
     * password：密码
     */
    private String id;
    private String password;

    public User() {
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
