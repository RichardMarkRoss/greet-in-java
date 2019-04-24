package net.greet;

import java.util.*;

public class Main implements GreetInterface {


    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);

        GreetDataBase method = new GreetDataBase();
        System.out.println("type help for more commands");
        String userInput = "";


        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();
            String[] elements = userInput.split("\\s");



            if (elements[0].equals("greet")) {
                method.greet(userInput);
            }
            if (elements[0].equals("help")) {
                method.help();
            }
            if (elements[0].equals("greeted")){
                if (elements[1].length() == 0){
                    method.greetedAll();
                } else {
                    String userIn = elements[1];
                    method.greeted(userIn);
                }
            }
            if (elements[0].equals("clear")) {
                System.out.println("Clear user :");
                method.clear(elements[1]);
            }
            if (elements[0].equals("count")) {
                System.out.println("Count user :");
                method.counter();
            }
        }
        System.out.println("Thank you for your time!");
    }


    public void greet(String name) {

    }

    public void greeted(String name) {

    }

    public void greetedAll() {

    }

    public void counter() {

    }

    public void clear(String name) {

    }
    public String help() {
        return null;
    }

}
