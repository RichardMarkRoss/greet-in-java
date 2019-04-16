package net.greet;

import java.sql.*;

public class DataBaseMig extends Greet{
    final String INSERT_USER_SQL = "insert into user_count_data (pet_type, pet_count) values(?, ?)";
    Connection conn;
    PreparedStatement psCreateNewUser;
    Greet greet = new Greet();

    public void JdbcGreetUser() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./db/pet_spotter", "sa", "");
            psCreateNewUser = conn.prepareStatement(INSERT_USER_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertIntoTaable() {
        try{
                psCreateNewUser.setString(1, greet.username);
                psCreateNewUser.setInt(2, greet.counterForUser);
                psCreateNewUser.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
