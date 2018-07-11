package com.minghui.jdbc.test;

import com.minghui.jdbc.domain.User;
import com.minghui.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author minghui.y
 * @create 2018-07-09 23:29
 **/
public class StatementDemo {

    /**
     * 查询案例
     * 主要方法：executeQuery(String sql)
     */
    @Test
    public void queryDemo() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        String query = "select * from crm_user";
        List<User> userList = new ArrayList<>();
        try {
            //由连接创建Statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                //列索引从1开始
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRoleId(resultSet.getInt(4));
                user.setStatus(resultSet.getString(5));
                user.setGmtCreated(resultSet.getDate(6));
                user.setGmtModified(resultSet.getDate(7));
                //
                userList.add(user);
            }

            //遍历结果
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection);
        }
    }

    /**
     * 执行更新操作
     * 主要方法：executeUpdate(String sql)
     */
    @Test
    public void updateDemo() {

        String sql = "insert into crm_user(id,name,password,role_id,status) values(8,'mike','mike',1,'ENABLE')";
        Connection connection = null;

        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //获取Statement
            Statement statement = connection.createStatement();
            if (statement.executeUpdate(sql) <= 0) {
                System.out.println("执行更新操作失败！");
            }
            System.out.println("执行更新操作成功！");
            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
