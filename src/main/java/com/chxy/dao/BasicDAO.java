package com.chxy.dao;

import com.chxy.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 开发BasicDAO ，是其他DAO的父类
 * @author chxy
 * @version 1.0
 */
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr = new QueryRunner();

    /**
     * 功能：操作数据库数据
     * @param sql SQL 语言，？ 作占位符
     * @param parameters 传入 ？的具体的值，可以是多个
     * @return 影响的行数
     */
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 功能：查询多行数据
     * @param sql SQL 语句，？ 作占位符
     * @param clazz 传入要查询表所对应类的 Class对象
     * @param parameters 传入 ？的具体的值，可以是多个
     * @return 根据传入的 Class对象返回对应的 ArrayList集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 功能：查询单行数据
     * @param sql SQL 语句，？ 作占位符
     * @param clazz 传入要查询表所对应类的 Class对象
     * @param parameters 传入 ？的具体的值，可以是多个
     * @return 根据传入的 Class对象返回对应类型的对象
     */
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 功能：查询单行单列数据
     * @param sql SQL 语句，？ 作占位符
     * @param parameters 传入 ？的具体的值，可以是多个
     * @return 所查询字段对应的对象
     */
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler<T>(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

}
