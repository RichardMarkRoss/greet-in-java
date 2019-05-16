package net.greet.CommandPack;

import net.greet.Database.GreetDataBase;
import net.greet.GreetMap.Greet;
import net.greet.enums.Languages;

import static net.greet.enums.Languages.*;

public class CommandExecutor {
    GreetDataBase method = new GreetDataBase();
//  Greet method = new Greet();

    public String execute(CommandExtractor extractor) {

        if (extractor.getCommandEx().equals("greet")) {
            if (extractor.getName().isEmpty()) {
                return "Invalid cmd";
            }
            try {
                if (!extractor.getLang().isEmpty()) {
                    return method.greets(extractor.getName(), Languages.valueOf(extractor.getLang()));
                } else {
                    return method.greets(extractor.getName(), english);
                }
            } catch (IllegalArgumentException ex) {
                return method.greets(extractor.getName(), english);
            }
        }
        if (extractor.getCommandEx().equals("greeted")){
            if(extractor.hasName()){
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
        return "type help for valid commands";
    }
}