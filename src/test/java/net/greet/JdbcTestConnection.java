package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static java.sql.DriverManager.getConnection;
import static org.junit.jupiter.api.Assertions.fail;

public class JdbcTestConnection {

    Connection conn;

    @BeforeEach
    public void cleanUpData() {
        try {
            Statement statement = conn.createStatement();
            statement.addBatch("delete from multiple_user");
            statement.executeBatch();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void loadJdbcDriver() { // Done

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            fail(e);
        }
    }

    @Test
    public void connectToDatabase() { //connect url / Connection
        try {
            Class.forName("org.h2.Driver");
            conn = getConnection("jdbc:h2:./db/user_count", "sa", "");
            System.out.println(conn);
        } catch (Exception e) {
            fail(e);
        }
    }

}
