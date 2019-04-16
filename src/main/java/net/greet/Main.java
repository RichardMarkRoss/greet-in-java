package net.greet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements GreetInterface {
    Map<String, Integer> hash = new HashMap<String, Integer>();

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


    public static void main(String[] args) {

        Scanner insert = new Scanner(System.in);
        Greet method = new DataBaseMig();
        System.out.println("type help for more commands");

        while (!insert.toString().equals("exit")) {

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
