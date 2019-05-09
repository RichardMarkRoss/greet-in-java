package net.greet;

import net.greet.enums.Languages;

public interface GreetInterface {
    void greets(String name, Languages lang);

    void greet(String name);

    void greeted(String name);

    void greetedAll();

    int counter();

    void clear(String name);

    String help();
}
