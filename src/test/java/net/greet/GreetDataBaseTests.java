package net.greet;

import net.greet.CommandPack.CommandExtractor;
import net.greet.Database.GreetDataBase;
import net.greet.GreetMap.Greet;
import net.greet.enums.Languages;
import org.h2.command.Command;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetDataBaseTests {
    Connection conn;

    @Test
    public void ShouldTestIfNameisStored() {
        GreetDataBase greet = new GreetDataBase();
        CommandExtractor commandExtractor = new CommandExtractor("greet richard");
        assertEquals(commandExtractor.getName(), "richard");
    }

    @Test
    public void ShouldTestGreetCounter() {
        GreetDataBase greet = new GreetDataBase();
        greet.greets("richard", Languages.english);
        assertEquals(greet.counter(), "2");
    }

    @Test
    public void ShouldTestGreetMethodsGreetedWithoutLangauge() {
        GreetDataBase greet = new GreetDataBase();
        greet.greets("richard", Languages.english);
        assertEquals(greet.greeted("richard"), "richard has been greeted 1 time/s!");
    }

    @Test
    public void ShouldTestGreetMethodsWithLanguage() {
        GreetDataBase greet = new GreetDataBase();
        greet.greets("richard", Languages.english);
        assertEquals(greet.greets("richard", Languages.xhosa), "Molo, richard");
    }

    @Test
    public void ShouldTestGreetMethodsRemoveUsername() {
        GreetDataBase greet = new GreetDataBase();
        greet.greets("richard", Languages.english);
        greet.clear("richard");
        assertEquals(greet.counter(), "1");
    }
    @Test
    public void ShouldTestlangIsStoredinVar(){
        GreetDataBase greet = new GreetDataBase();
        CommandExtractor commandExtractor = new CommandExtractor("greet richard english");
        assertEquals(commandExtractor.getLang(), "english");
    }


    @Test
    public void shouldTestGreetedForNameLength(){
        GreetDataBase greet = new GreetDataBase();

        assertEquals(greet.help(), "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.");
    }
}
