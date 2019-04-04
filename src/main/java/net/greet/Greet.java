package net.greet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Greet {
    //private int counter = 0;
    Map<String, Integer> hash = new HashMap<String, Integer>();
    private String username;
    private String language;
    private String greet;

    public void stringToArgs(String name){
        String[] elements = name.split("\\s");

        this.greet = elements[0];
        this.username = elements[1];
        this.language = elements[2];

        System.out.println(this.greet);
        System.out.println(this.username);
        System.out.println(this.language);
    }

    public void greet(){

        if (!hash.containsKey(username)) {
            this.hash.put(username, 0);
        }

        if (language != "") {
            // counter++;
            int counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);

            System.out.println("your name has been successfully greeted!");
        }
    }

    public void Greeted(String name) {
        this.username = username;
        if (hash.containsKey(username)) {
            System.out.println(username);
        }
    }

    public void Counter() {

    }

    public void Clear() {
        if(username != ""){
            hash.remove(hash.containsKey(username));
        }
        else{
            hash.clear();
        }
    }

    public String Help() {
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

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        Greet meth = new Greet();

        // while not typed exit
        while(!insert.equals("exit")){
            System.out.println("Please insert a username and/or language.");
            String name = insert.nextLine();

            meth.stringToArgs(name);
            meth.greet();
            System.out.println(meth.greet.toString());
//            System.out.println(meth.hash);
        }
    }

}