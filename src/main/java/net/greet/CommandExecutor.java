package net.greet;

import net.greet.Database.GreetDataBase;
import net.greet.enums.Languages;

public class CommandExecutor {
    GreetDataBase method = new GreetDataBase();


    public void execute(CommandExtractor extractor) {

        if (extractor.getCommandEx().equals("greet")) {
            if (!extractor.getLang().isEmpty()){
                method.greets(extractor.getName(), Languages.valueOf(extractor.getLang()));
            }else{
                method.greet(extractor.getName());
            }
        }
        if (extractor.getCommandEx().equals("greeted")){
            if(!extractor.getName().isEmpty()){
                method.greeted(extractor.getName());
            }else{
                method.greetedAll();
            }
        }
        if (extractor.getCommandEx().equals("clear")) {
            method.clear(extractor.getName());
        }
        if (extractor.getCommandEx().equals("help")) {
            method.help();
        }
        if (extractor.getCommandEx().equals("count")) {
            method.counter();
        }
    }
}