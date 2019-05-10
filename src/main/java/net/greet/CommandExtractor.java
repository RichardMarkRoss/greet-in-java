package net.greet;

import net.greet.enums.Languages;

public class CommandExtractor {
    CommandExecutor executor = new CommandExecutor();

    String name = "";
    String lang = "";
    private String commandEx = "";


    public String getCommandEx(){
        return this.commandEx;
    }
    public String getName(){
        return this.name;
    }
    public String getLang(){
        return this.lang;
    }

    public void extractor(String userInput) {
        String[] elements = userInput.split("\\s");

            if(elements.length == 3) {
                this.commandEx = elements[0];
                this.name = elements[1];
                this.lang = elements[2];

                for (Languages language : Languages.values()) {
                    if (language.toString().equals(elements[2])) {
                        executor.greeting(commandEx, name, language);
                    }
                }
            }
            if(elements.length == 2) {
                this.commandEx = elements[0];
                this.name = elements[1];
                executor.execute(commandEx, name);
            }
            if(elements.length == 1) {
                this.commandEx = elements[0];
                executor.singleCommands(commandEx);
            }
        }
    }
