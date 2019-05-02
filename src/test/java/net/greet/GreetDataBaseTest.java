package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetDataBaseTest {
    Connection conn;

    @Test
    public void ShouldTestIfNameisStoredinVar() {
        Greet greetDataBase = new Greet();
        greetDataBase.greets("richard", "english");
        assertEquals(greetDataBase.username, "richard");
    }

    @Test
    public void ShouldTestlangIsStoredinVar(){
        Greet greetDataBase = new Greet();
        greetDataBase.greets("tabang", "afrikaans");
        assertEquals(greetDataBase.language, "afrikaans");
    }
    @Test
    public void shouldTestGreetedForNameLength(){
        Greet greetDataBase = new Greet();

        assertEquals( greetDataBase.help(), "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.");
    }

    @Test
    public void ShouldTestIfNameStoredinMap() {
        Greet greet = new Greet();
        greet.greet("greet richard english");
        assertEquals(greet.counterForUser, 0);
    }



}
