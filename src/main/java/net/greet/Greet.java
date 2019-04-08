package net.greet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Greet {
    //private int counter = 0;
    Map<String, Integer> hash = new HashMap<String, Integer>();
    private String username;
    private String language;
    private String commands;

    public void greet(String name){
        String[] elements = name.split("\\s");
        this.commands = elements[0];
        this.username = elements[1];
        this.language = elements[2];

        if (!hash.containsKey(username)){
            this.hash.put(username, 0);
            System.out.println("Hello " + username);
        }
        if (language != "") {
            int counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);

            if(language.equals("english")){
                System.out.println("Hello " + username);
            }else if(language.equals("afrikaans")){
                System.out.println("goeie dag " + username);
            }else if(language.equals("xhosa")){
                System.out.println("Molo" + username);
            }

            System.out.println("your name has been successfully greeted!");
        }
    }

    public void greeted(String username) {
        this.username = username;
        if (hash.containsKey(username)) {
           hash.get(username).equals(username);
            int mapSize = hash.get(username.length());
            System.out.println(username + " has been greeted: " + mapSize);
        }
        if (!hash.containsKey(username)){
            for (Map.Entry<String, Integer> entry : hash.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(value + " has been greeted " + key + " times");
            }
        }
    }

    public void counter(String username) {
        this.username = username;
        if(hash.containsKey(username)){
            hash.containsKey(username.length());
        }
        if(!hash.containsKey(username));
        hash.size();
    }

    public void clear(String username) {
        this.username = username;
        if(username != ""){
            hash.remove(hash.containsKey(username));
        }
        else{
            hash.clear();
        }
    }

    public String help() {

        return "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.";

    }
    public static void main(String[] args) {

        Scanner insert = new Scanner(System.in);
        Greet method = new Greet();
        System.out.println("type help for more commands");

        while(!("exit".equals(insert))){

            String userInput = insert.nextLine();
            String[] elements = userInput.split("\\s");
            System.out.println("Please insert a username and/or language.");

            if  (elements[0].equals("greet")){

                method.greet(userInput);
            }else if(elements[0].equals("help")){

                method.help();
            }else if(elements[0].equals("greeted")){
                System.out.println("Greeted user :");
            method.greeted(elements[1]);
            }
            else if(elements[0].equals("clear")){
                System.out.println("Clear user :");
                method.clear(elements[1]);
            }else if(elements[0].equals("count")){
                System.out.println("Count user :");
                method.counter(elements[1]);
            }else{
                System.out.println("please type help to view valid commands");
            }
        }

        System.out.println("Thank you for your time!");
    }
}
