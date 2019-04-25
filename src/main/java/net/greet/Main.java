package net.greet;

import java.util.*;

public class Main implements GreetInterface {


    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);

        Greet method = new Greet();
        System.out.println("type help for more commands");
        String userInput = "";


        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();
            String[] elements = userInput.split("\\s");

            if(elements.length == 3){
                if (elements[0].equals("greet")) {
                    method.greets(elements[1], elements[2]);
                }
            }
            if(elements.length == 2){
                if (elements[0].equals("greeted")){
                        method.greeted(elements[1]);
                }
                if (elements[0].equals("clear")) {
                    method.clear(elements[1]);
                }
                if (elements[0].equals("greet")){
                    method.greet(elements[1]);
                }
            }
            if(elements.length == 1){
                if (elements[0].equals("help")) {
                    method.help();
                }
                if (elements[0].equals("greeted")) {
                    method.greetedAll();
                }
                if (elements[0].equals("count")) {
                    method.counter();
                }
            }
        }
        System.out.println("Thank you for your time!");
    }

    public void greets(String name, String lang) {

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
