package Lesson2_HomeWork;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
    public void loadDriver(){
        try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        DriverManager.registerDriver(new Driver());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_test",
                    "root",
                    "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
