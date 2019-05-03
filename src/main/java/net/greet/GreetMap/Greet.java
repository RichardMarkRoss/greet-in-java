package net.greet.GreetMap;

import net.greet.GreetInterface;
import net.greet.enums.Languages;

import java.util.HashMap;
import java.util.Map;

public class Greet implements GreetInterface {
    Map<String, Integer> hash = new HashMap<String, Integer>();
    public String username = "";
    public int counterForUser;

    @Override
    public void greets(String username, Languages lang) {
        this.username = username;
        if (!hash.containsKey(username)) {
            this.hash.put(username, 0);
        }

        if (hash.containsKey(username)) {
            int counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);
        }

        if (lang.equals(Languages.english)) {
            System.out.println("Hello " + username);
        } else if (lang.equals(Languages.afrikaans)) {
            System.out.println("goeie dag " + username);
        } else if (lang.equals(Languages.xhosa)) {
            System.out.println("Molo" + username);
        }


    }

    public void greet(String name){
        if (!hash.containsKey(name)) {
            this.hash.put(name, 0);
            System.out.println("Hello " + name);
        }
        if (hash.containsKey(name)) {
            int counterForUser = this.hash.get(name);
            counterForUser++;
            this.hash.put(name, counterForUser);
            System.out.println("Hello " + name);
        }

    }

    @Override
    public void greeted(String username) {
        try {
            hash.get(username).equals(username);
            int mapSize = hash.get(username);
            System.out.println(username + " has been greeted: " + mapSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void greetedAll(){
        try {
            for (HashMap.Entry<String, Integer> entry : hash.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                System.out.println(key + " has been greeted " + value + " times");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String help() {
        String help = "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.";
        System.out.println(help);
        return help;
    }

    @Override
    public void counter() {
        System.out.println("amount of user are : " + hash.size());
    }

    @Override
    public void clear(String username) {
        if (username != "") {
            hash.remove(username);
        } else {
            hash.clear();
        }
    }
}
