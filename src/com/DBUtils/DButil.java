package com.DBUtils;

import java.sql.*;

public class DButil {
//    //声明静态代码块
//    static
//    {
//        try {
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    //创建连接
    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf-8", "root", "");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeResource(Connection connection,Statement statement,ResultSet resultSet)
    {
        if (resultSet!=null)
        {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null)
        {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
