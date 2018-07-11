package com.minghui.jdbc.test;

import com.minghui.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * PrepareStatement测试案例
 * @author minghui.y
 * @create 2018-07-11 17:42
 **/
public class PrepareStatementDemo {

    /**
     * 执行查询操作
     */
    @Test
    public void executeDemo() {
        //参数使用?表示
        String sql = "select * from crm_user where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //获取PrepareStatement
            preparedStatement = connection.prepareStatement(sql);
            //设定参数值
            preparedStatement.setInt(1, 2);
            //执行查询操作
            ResultSet resultSet = preparedStatement.executeQuery();
            //获取结果
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getInt(4));
                System.out.println(resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行更新操作
     */
    @Test
    public void updateDemo() {
        String sql = "insert into crm_user(id,name,password,role_id,status) values(?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //设定参数
            preparedStatement.setInt(1, 9);
            preparedStatement.setString(2, "Sara");
            preparedStatement.setString(3, "Sara");
            preparedStatement.setInt(4, 2);
            preparedStatement.setString(5, "DISABLED");
            //执行更新操作
            if (preparedStatement.executeUpdate() <= 0) {
                System.out.println("更新操作失败！");
            }
            System.out.println("更新操作成功！");
            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
