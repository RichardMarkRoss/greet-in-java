package net.greet.commands;

public class Greet implements GreetInterface {
private String username;
private String language;
private int counter;

    public void Greet(String name, String language) {
        this.language = language;
        this.username = name;
        if(this.username != null) {
            this.counter++;
            System.out.println("Hello my name is " + username);
            System.out.println("Name has been greeted " + counter);
        }else{
            System.out.println("please insert name");
        }
    }
    public int Greeted(String name){
        return 0;
    }
    public int Counter() {
        return 0;
    }

    public void Clear(String name) {

    }
    public String Help(){
        return "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.";
    }

    public void Exit() {
    }
}