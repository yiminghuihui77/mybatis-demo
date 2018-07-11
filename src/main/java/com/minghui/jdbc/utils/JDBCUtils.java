package com.minghui.jdbc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * JDBC数据库连接工具类
 *
 * @author minghui.y
 * @create 2018-07-09 23:06
 **/
public class JDBCUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCUtils.class);

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Properties properties = null;
        InputStream in = null;
        Connection connection = null;
        try {
            properties = new Properties();
            in = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(in);
            //读取数据
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            String jdbcUrl = properties.getProperty("jdbcUrl");
            String driver = properties.getProperty("driver");

            //获取连接
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            return connection;
        } catch (Exception e) {
            LOGGER.error("连接数据库失败：" + e.getMessage());
            return null;
        }
    }

    /**
     * 关闭数据库连接，释放资源
     */
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            LOGGER.error("释放连接异常：" + e.getMessage());
        }
    }
}
