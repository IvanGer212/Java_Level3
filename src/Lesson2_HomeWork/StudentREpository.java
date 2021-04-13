package Lesson2_HomeWork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentREpository {
    public List<Student> findAll(){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user1");
            List <Student> students = new ArrayList<>();
            while (resultSet.next()){
            students.add(new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname")));

            }
            return students;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
