package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.*;

import static java.sql.DriverManager.getConnection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestUserInDataBase {
    Connection conn;

    @BeforeEach
    public void cleanUpTables() {
        try {
            conn = getConnection("jdbc:h2:file:./target/db/user_count", "sa", "");
            Statement statement = conn.createStatement();
            statement.addBatch("delete from multiple_user");
//            statement.addBatch("update multiple_user set price = 0  where name = ?");
            statement.executeBatch();

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    //    @Test
//    public void ShouldTestIfMultipalNamesStoredinMap(){
//        final String RETURN_ALL_SQL = "select * from multiple_user";
//        try {
//            PreparedStatement psReturnAll = conn.prepareStatement(RETURN_ALL_SQL);
//            GreetDataBase greet = new GreetDataBase();
//            greet.greets("richard", "english");
//            greet.greets("tabang", "afrikaans");
//            greet.greets("vusi", "xhosa");
//            greet.greets("andre", "english");
//            greet.greets("tido", "afrikaans");
//            greet.greets("nat", "xhosa");
//            assertEquals(greet.counter(), );
//        }catch(Exception e){
//            e.printStackTrace();
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
//            addPreparedStatement.setInt(2, 1);
//            addPreparedStatement.execute();
//
//            System.out.println(findPreparedStatement.executeQuery());
//
//        } catch (Exception e) {
//            fail(e);
//        }
//    }

}
