package net.greet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Greet {
    //private int counter = 0;
    Map<String, Integer> hash = new HashMap<String, Integer>();
    public String username = "";
    public String language = "";
//    public String commands;

    public void greet(String name) {
        String[] elements = name.split("\\s");
        this.username = elements[1];
        this.language = elements[2];

        if (!hash.containsKey(username)) {
            this.hash.put(username, 0);
//            System.out.println("Hello " + username);
        }
        if (language != "" && hash.containsKey(username)) {
            int counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);

            if (language.equals("english")) {
                System.out.println("Hello " + username);
            } else if (language.equals("afrikaans")) {
                System.out.println("goeie dag " + username);
            } else if (language.equals("xhosa")) {
                System.out.println("Molo" + username);
            }

            System.out.println("your name has been successfully greeted!");
        }
    }

    public void greeted(String username) {
        String Username = username;
        hash.get(Username).equals(Username);
        int mapSize = hash.get(Username);
        System.out.println(Username + " has been greeted: " + mapSize);


    }

    public void greetedAll() {

        for (HashMap.Entry<String, Integer> entry : hash.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            Integer value = entry.getValue();
            System.out.println(value);
            System.out.println(value + " has been greeted " + key + " times");
        }

    }

    public void counter() {

        System.out.println("amount of user are : " + hash.size());
    }

    public void clear(String username) {
        if (username != "") {
            hash.remove(username);
        } else {
            hash.clear();
        }
    }

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

    public static void main(String[] args) {

        Scanner insert = new Scanner(System.in);
        Greet method = new Greet();
        System.out.println("type help for more commands");

        while (!insert.equals("exit")) {

            String userInput = insert.nextLine();
            String[] elements = userInput.split("\\s");

            if (elements[0].equals("greet")) {

                method.greet(userInput);

            } else if (elements[0].equals("help")) {
                method.help();

            } else if (elements[0].equals("greeted")) {
                String userIn = elements[1];
                if (userIn.equals(null)){
                    method.greetedAll();
                } else {
                    method.greeted(userIn);
                }
            } else if (elements[0].equals("clear")) {
                System.out.println("Clear user :");
                method.clear(elements[1]);

            } else if (elements[0].equals("count")) {
                System.out.println("Count user :");
                method.counter();

            } else {
                System.out.println("please type help to view valid commands");
            }
        }

        System.out.println("Thank you for your time!");
    }
}
