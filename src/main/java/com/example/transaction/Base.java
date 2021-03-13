package com.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/13 17:32
 * @Description: 基础手写事务例子
 */
public class Base {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {

    }

    private void beginTransaction() throws SQLException {
        Connection conn = dataSource.getConnection();
        if (conn != null) {
            conn.setAutoCommit(false);
        }
    }

    private void commitTransaction() throws SQLException {
        Connection conn = dataSource.getConnection();
        if (conn != null) {
            conn.commit();
            conn.close();
        }
    }

    private void rollbackTransaction() throws SQLException {
        Connection conn = dataSource.getConnection();
        if (conn != null) {
            conn.rollback();
            conn.close();
        }
    }
}
