package auth;

import error.UserNotFoundException;

import java.sql.*;

public class JDBCAuthService implements AuthService {
    private static Connection connection;
    private static Statement stmt;


    public JDBCAuthService() {
        connection = JDBCConnection.connect();
    }

    public String getNicknameByLoginAndPassword(String login, String password) {
        String nickname = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE login = '" + login + "' and password = '" + password + "';");
            nickname = rs.getString("nick");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (nickname != null) {
            return nickname;
        } else throw new UserNotFoundException("User not found");
    }

    @Override
    public void start() {
        System.out.println("Auth service started!");
    }

    @Override
    public void stop() {
        System.out.println("Auth service stopped");
    }

    @Override
    public String changeNickname(String oldNick, String newNick) {
        return null;
    }

    @Override
    public void changePassword(String nickname, String oldPassword, String newPassword) {

    }

    @Override
    public void createNewUser(String login, String password, String nickname) {

    }

    @Override
    public void deleteUser(String nickname) {

    }
}
