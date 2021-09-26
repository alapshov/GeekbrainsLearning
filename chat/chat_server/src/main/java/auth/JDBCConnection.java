package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static Connection connection;

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:chat\\chat_server\\src\\main\\resources\\chat.db");
        } catch (SQLException se) {
            System.out.println("DB connection error");
            se.printStackTrace();
            disconnect();
        }
        return connection;
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
