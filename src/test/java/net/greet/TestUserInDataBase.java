package net.greet;

import net.greet.Database.GreetDataBase;
import net.greet.enums.Languages;
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
            statement.addBatch("truncate table multiple_user");
            statement.executeBatch();

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

        @Test
        public void ShouldTestIfMultipalNamesStoredinTable(){
        try {
            GreetDataBase greet = new GreetDataBase();
            greet.greets("richard", Languages.english);
            greet.greets("tabang", Languages.afrikaans);
            greet.greets("vusi", Languages.xhosa);
            greet.greets("andre", Languages.english);
            greet.greets("tido", Languages.afrikaans);
            greet.greets("nat", Languages.xhosa);
            assertEquals(greet.counter(), 6);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void ShouldTestRemoveSingleMultipalNamesStoredinTable(){
        try {
            GreetDataBase greet = new GreetDataBase();
            greet.greets("richard", Languages.english);
            greet.greets("tabang", Languages.afrikaans);
            greet.greets("tabang", Languages.xhosa);
            greet.greets("andre", Languages.english);
            greet.greets("richard", Languages.afrikaans);
            greet.clear("andre");
            assertEquals(greet.counter(), 2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
