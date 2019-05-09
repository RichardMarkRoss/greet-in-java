package net.greet;

import net.greet.Database.GreetDataBase;
import net.greet.enums.Languages;

public class CommandExecutor {
    GreetDataBase method = new GreetDataBase();
    //        Greet method = new Greet();

    public void greeting(String command, String name, Languages lang){
        method.greets(name, lang);
    }

    public void execute(String command, String name){
        if (command.equals("greeted")){
            method.greeted(name);
        }
        if (command.equals("clear")) {
            method.clear(name);
        }
        if (command.equals("greet")){
            method.greet(name);
        }
    }

    public void singleCommands(String commands){
        if (commands.equals("help")) {
            method.help();
        }
        if (commands.equals("greeted")) {
            method.greetedAll();
        }
        if (commands.equals("count")) {
            method.counter();
        }
    }
}