package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final ConnectionDB instance = new ConnectionDB();
    private Connection connection;

    private final String URL = "jdbc:mysql://127.0.0.1/coffeemachine?useSSL=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWORD = "123456";

    ConnectionDB() {
    }

    public static ConnectionDB getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        return connection;
    }
}
