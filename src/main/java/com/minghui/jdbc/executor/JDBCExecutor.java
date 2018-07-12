package com.minghui.jdbc.executor;

import com.minghui.jdbc.domain.User;
import com.minghui.jdbc.utils.JDBCUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC执行器
 *
 * @author minghui.y
 * @create 2018-07-12 20:24
 **/
public class JDBCExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCExecutor.class);

    public static List<User> doSelect(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return new ArrayList<>();
        }
        Connection connection = null;
        PreparedStatement statement = null;
        List<User> userList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            //封装结果
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRoleId(resultSet.getInt(4));
                user.setStatus(resultSet.getString(5));
                user.setGmtCreated(resultSet.getDate(6));
                user.setGmtModified(resultSet.getDate(7));
                userList.add(user);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            JDBCUtils.closeConnection(connection);
        }
        return userList;
    }
}
