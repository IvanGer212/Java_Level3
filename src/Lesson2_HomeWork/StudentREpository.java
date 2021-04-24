package Lesson2_HomeWork;

import java.sql.*;
import java.util.*;

public class StudentREpository {
    public Set<Student> findAll(){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat_users");
            Set <Student> students = new HashSet<>();
            while (resultSet.next()){
            students.add(new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("Login"),
                    resultSet.getString("Password"),
                    resultSet.getString("Name")));

            }
            return students;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        finally {
            close(connection);
        }
    }
    public Optional<Student> findById (String name) {
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat_users WHERE Name ="+name);

            if (resultSet.next()){
                return Optional.of(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Name")));

            }
            else return Optional.empty();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            close(connection);
        }

    }

    public boolean update (Student student) {
        Connection connection = DBConnection.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("UPDATE chat_users SET Name = ? WHERE Login = ?");
           statement.setString(1, student.getName());
           statement.setString(2, student.getLogin());
           //statement.setInt(3,student.getId());

            boolean result = statement.execute();
            connection.commit();
            return result;

        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(throwables);
        }
        finally {
            close(connection);
        }
    }

    public boolean save (Student student) {
        Connection connection = DBConnection.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO chat_users (id, login, password, name) VALUES (?, ?, ?, ?)");
            statement.setInt(1,student.getId());
            statement.setString(2, student.getLogin());
            statement.setString(3, student.getPassword());
            statement.setString(4, student.getName());

            boolean result = statement.execute();
            connection.commit();
            return result;

        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(throwables);
        }
        finally {
            close(connection);
        }
    }

    private void close (Connection connection){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
