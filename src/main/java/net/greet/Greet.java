package net.greet;

import java.util.HashMap;
import java.util.Map;

public class Greet implements GreetInterface {
    Map<String, Integer> hash = new HashMap<String, Integer>();
    String username = "";
    private String language = "";
    int counterForUser;

    @Override
    public void greet(String name) {
        String[] elements = name.split("\\s");
        this.username = elements[1];
        this.language = elements[2];

        if (!hash.containsKey(username)) {
            this.hash.put(username, 0);
        }

        if (!language.equals("") && hash.containsKey(username)) {
            int counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);
        }

            if (language.equals("english")) {
                System.out.println("Hello " + username);
            } else if (language.equals("afrikaans")) {
                System.out.println("goeie dag " + username);
            } else if (language.equals("xhosa")) {
                System.out.println("Molo" + username);
            }

            System.out.println("your name has been successfully greeted!");

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
                System.out.println(value + " has been greeted " + key + " times");
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
