package net.greet.commands;

public interface GreetInterface {
    void Greet(String name, String language);
    int Greeted(String name);
    int Counter();
    void Clear(String name);
    String Help();
    void Exit();
}
