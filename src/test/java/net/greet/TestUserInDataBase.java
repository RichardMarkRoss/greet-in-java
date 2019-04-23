//package net.greet;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//
//import java.sql.*;
//
//import static java.sql.DriverManager.getConnection;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class TestUserInDataBase {
//    Connection conn;
//
//    @BeforeEach
//    public void cleanUpTables() {
//        try {
//            conn = getConnection("jdbc:h2:file:./target/user_count", "sa", "");
//            Statement statement = conn.createStatement();
//            statement.addBatch("delete from multiple_user");
////            statement.addBatch("update multiple_user set price = 0  where name = ?");
//            statement.executeBatch();
//
//        } catch(Exception ex) {
//            System.out.println(ex);
//        }
//    }
//
//    @Test
//    public void addDataWithPreparedStatement() {
//
//        try {
//
//
//            final String INSERT_NAME_SQL = "insert into multiple_user (username, counter) values (?, ?)";
//            final String FIND_NAME_SQL = "select username, counter from multiple_user where username = ?";
//
//            PreparedStatement addPreparedStatement = conn.prepareStatement(INSERT_NAME_SQL);
//            PreparedStatement findPreparedStatement = conn.prepareStatement(FIND_NAME_SQL);
//
//
//            addPreparedStatement.setString(1, "Richard");
//            addPreparedStatement.setDouble(2, 2);
//            addPreparedStatement.execute();
//
//            System.out.println(findPreparedStatement.executeQuery());
//
//
//        } catch (Exception e) {
//            fail(e);
//        }
//    }
//
//}
