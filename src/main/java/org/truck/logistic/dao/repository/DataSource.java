package org.truck.logistic.dao.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource implements AutoCloseable {
    static String URL ="jdbc:mysql://localhost:3306/truck?user=root&password=1111";
    static String JDBC_Driver = "com.mysql.jdbc.Driver";

    private Connection connection = null;

    public DataSource (){
        try {
            Class.forName(JDBC_Driver).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection (){
            try {
                if (connection == null) {
                    connection = DriverManager.getConnection(URL);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
    }

    @Override
    public void close() throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
