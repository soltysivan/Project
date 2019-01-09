package org.truck.logistic.dao.repository;

import org.truck.logistic.dao.entities.Order;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public List<Order> getAllOrders (){
        DataSource dataSource = new DataSource();
        List<Order> orders = new ArrayList<>();


        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id, user_id, departure,arrival,distance,timeDelivary FROM orders");){
            while(resultSet.next()){
                orders.add(new Order(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("departure"),
                        resultSet.getString("arrival"),
                        resultSet.getString("distance"),
                        resultSet.getString("timeDelivary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order getOrderByID(long ID){
            DataSource dataSource = new DataSource();
            Order order = null;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id, user_id, departure, arrival, distance, timeDelivary FROM orders " +
                             "WHERE orders.id='" + ID + "'")){
            while (resultSet.next()){
                order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getString("departure"),
                        resultSet.getString("arrival"),
                        resultSet.getString("distance"),
                        resultSet.getString("timeDelivary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void changOrder (Order order,Long ID){
            DataSource dataSource = new DataSource();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE orders SET user_id=?, departure=?, distance=?, arrival=?, timeDelivary=? WHERE id="+ ID +"")) {
            preparedStatement.setLong(1,order.getUSER_ID());
            preparedStatement.setString(2,order.getDeparture());
            preparedStatement.setString(3,order.getDistance());
            preparedStatement.setString(4,order.getArrival());
            preparedStatement.setString(5,order.getTimeDelivary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder (long id){
            DataSource dataSource = new DataSource();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE orders.id='"+ id +"'");){
preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOrder (Order order){
        DataSource dataSource = new DataSource();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                     "orders (user_id, departure, distance, arrival, timeDelivary) VALUE (?,?,?,?,?)");){
            preparedStatement.setLong(1,order.getUSER_ID());
            preparedStatement.setString(2,order.getDeparture());
            preparedStatement.setString(3,order.getDistance());
            preparedStatement.setString(4,order.getArrival());
            preparedStatement.setString(5,order.getTimeDelivary());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
