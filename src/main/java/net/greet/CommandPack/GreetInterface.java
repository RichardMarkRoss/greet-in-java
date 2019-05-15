package net.greet.CommandPack;

import net.greet.enums.Languages;

public interface GreetInterface {
    String greets(String name, Languages lang);

    String greeted(String name);

    String greetedAll();

    String counter();

    String clear(String name);

    String help();
}
