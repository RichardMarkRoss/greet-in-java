package net.greet.CommandPack;

import net.greet.Database.GreetDataBase;
import net.greet.GreetMap.Greet;
import net.greet.enums.Languages;

import static net.greet.enums.Languages.*;

public class CommandExecutor {
    GreetDataBase method = new GreetDataBase();
//  Greet method = new GreetDataBase();

    public String execute(CommandExtractor extractor) {

        if (extractor.getCommandEx().equals("greet")) {
            if (!extractor.getLang().isEmpty()){
               return method.greets(extractor.getName(), Languages.valueOf(extractor.getLang()));
            }else{
                return method.greets(extractor.getName(), afrikaans);
            }
        }
        if (extractor.getCommandEx().equals("greeted")){
            if(!extractor.getName().isEmpty()){
               return method.greeted(extractor.getName());
            }else{
               return method.greetedAll();
            }
        }
        if (extractor.getCommandEx().equals("clear")) {
           return method.clear(extractor.getName());
        }
        if (extractor.getCommandEx().equals("help")) {
           return method.help();
        }
        if (extractor.getCommandEx().equals("count")) {
            return method.counter();
        }
        return null;
    }
}