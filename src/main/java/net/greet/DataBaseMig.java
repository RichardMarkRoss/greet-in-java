package net.greet;

import java.sql.*;

public class DataBaseMig extends Main{
    final String INSERT_USER_SQL = "insert into user_count_data (username, counter) values(?, ?)";
    final String COUNT_USER_SQL = "select count(*) From user_count_data";
    final String UPDATE_USER_SQL = "update user_count_data set counter = ? where username = ?";
    final String SELECT_USER_SQL = "select username From user_count_data where username = ?";
    Connection conn;
    PreparedStatement psCreateNewUser;
    PreparedStatement psCountUsers;
    PreparedStatement psUpdateUser;
    PreparedStatement psSelectUser;
    Greet greet = new Greet();

    public void JdbcGreetUser() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./db/user_count", "sa", "");
            psCreateNewUser = conn.prepareStatement(INSERT_USER_SQL);
            psCountUsers = conn.prepareStatement(COUNT_USER_SQL);
            psUpdateUser = conn.prepareStatement(UPDATE_USER_SQL);
            psSelectUser = conn.prepareStatement(SELECT_USER_SQL);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertIntoTable() {
        try{
                psCreateNewUser.setString(1, greet.username);
                psCreateNewUser.setInt(2, greet.counterForUser);
                psCreateNewUser.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
