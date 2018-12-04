package com.pack;

import com.DBUtils.DButil;
import com.pojos.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements UsersDao
{


    public boolean addOneUser(User user) {
        Connection connection = DButil.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("insert  into user (username,password,phone,email,postCard) values (?,?,?,?,?)");
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassWord());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.geteMail());
            preparedStatement.setString(5,user.getPostCard());
            int result = preparedStatement.executeUpdate();
            if (result!=0)
            {
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,null);
        }
        return  false;
    }

    @Override
    public boolean isExists(User user) {
        System.out.println("dao接受："+user.getUserName()+user.getPassWord());
        Connection connection = DButil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select  * from USER where username= ? and password = ?");
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassWord());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,resultSet);
         }
        return false;
    }
}
