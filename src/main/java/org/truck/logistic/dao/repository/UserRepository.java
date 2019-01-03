package org.truck.logistic.dao.repository;

import org.truck.logistic.dao.entities.User;

import java.sql.*;

public class UserRepository {


    public User getUserByEmailAndPassword (String email, String password){
        DataSource dataSource = new DataSource();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID, userName, password, email, role FROM user " +
                    "WHERE user.email = '" + email + "'AND user.password = '" + password + "'");
            ) {
            while (resultSet.next()){
                User user = new User(
                resultSet.getLong("ID"),
                resultSet.getString("userName"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getInt("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void saveUser (User user){
        DataSource dataSource = new DataSource();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (userName, password, email) VALUE (?,?,?)")) {
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
