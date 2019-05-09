package net.greet;

import net.greet.enums.Languages;

public class CommandExtractor {
    CommandExecutor extractor = new CommandExecutor();

    String name = "";
    String lang = "";
    String commandEx = "";


    public void extractor(String userInput) {
        String[] elements = userInput.split("\\s");


            if(elements.length == 3) {
                this.commandEx = elements[0];
                this.name = elements[1];
                this.lang = elements[2];

                for (Languages language : Languages.values()) {
                    if (language.toString().equals(elements[2])) {
                        extractor.greeting(commandEx, name, language);
                    }
                }
            }
            if(elements.length == 2) {
                this.commandEx = elements[0];
                this.name = elements[1];
                extractor.execute(commandEx, name);
            }
            if(elements.length == 1) {
                this.commandEx = elements[0];
                extractor.singleCommands(commandEx);
            }
        }
    }

