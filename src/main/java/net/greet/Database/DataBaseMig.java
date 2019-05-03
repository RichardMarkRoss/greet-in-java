package net.greet.Database;

import net.greet.Main;

import java.sql.*;

public abstract class DataBaseMig extends Main {
    final String INSERT_USER_SQL = "insert into multiple_user (username, counter) values(?, ?)";
    final String COUNT_USER_SQL = "select count(*) From user_count_data";
    final String UPDATE_USER_SQL = "update multiple_user set counter = ? where username = ?";
    final String SELECT_USER_SQL = "select username From multiple_user where username = ?";
    Connection conn;
    PreparedStatement psCreateNewUser;
    PreparedStatement psCountUsers;
    PreparedStatement psUpdateUser;
    PreparedStatement psSelectUser;

    public void JdbcGreetUser() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./db/user_count", "sa", "");
            psCreateNewUser = conn.prepareStatement(INSERT_USER_SQL);
            psCountUsers = conn.prepareStatement(COUNT_USER_SQL);
            psUpdateUser = conn.prepareStatement(UPDATE_USER_SQL);
            psSelectUser = conn.prepareStatement(SELECT_USER_SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}