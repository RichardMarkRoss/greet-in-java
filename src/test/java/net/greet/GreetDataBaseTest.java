package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetDataBaseTest {
    Connection conn;

    @Test
    public void ShouldTestIfNameisStoredinVar() {
        GreetDataBase greetDataBase = new GreetDataBase();
        greetDataBase.greets("richard", "english");
        assertEquals(greetDataBase.username, "richard");
    }

    @Test
    public void ShouldTestlangIsStoredinVar(){
        GreetDataBase greetDataBase = new GreetDataBase();
        greetDataBase.greets("tabang", "afrikaans");
        assertEquals(greetDataBase.language, "afrikaans");
    }
    @Test
    public void shouldTestGreetedForNameLength(){
        GreetDataBase greetDataBase = new GreetDataBase();

        assertEquals( greetDataBase.help(), "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.");
    }
//    @Test
//    public void ShouldTestIfNameStoredinMap() {
//        GreetDataBase greet = new GreetDataBase();
//        greet.greet("greet richard english");
//        assertEquals(greet.toString(), "{richard=1}");
//    }

//    @Test
//    public void ShouldTestIfMultipalNamesStoredinMap() throws SQLException {
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

}
