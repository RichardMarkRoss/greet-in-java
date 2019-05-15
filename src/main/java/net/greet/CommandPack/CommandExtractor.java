package net.greet.CommandPack;

import net.greet.enums.Languages;

import java.util.Scanner;

public class CommandExtractor {

    private String name = "";
    private String lang = "";
    private String commandEx = "";

    public CommandExtractor(String userInput) {
        String[] elements = userInput.toLowerCase().split("\\s");

            if(elements.length == 3) {
                this.commandEx = elements[0];
                this.name = elements[1];
                this.lang = elements[2];
            }
            if(elements.length == 2) {
                this.commandEx = elements[0];
                this.name = elements[1];
            }
            if(elements.length == 1){
                this.commandEx = elements[0];
            }
    }

    public String getCommandEx() {return this.commandEx;}
    public String getName() {return this.name;}
    public String getLang() {return this.lang;}
}
