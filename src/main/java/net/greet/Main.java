package net.greet;

import net.greet.Database.GreetDataBase;
import net.greet.GreetMap.Greet;
import net.greet.enums.Languages;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        GreetDataBase method = new GreetDataBase();
//        Greet method = new Greet();
        System.out.println("type help    for more commands");
        String userInput = "";

        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();
            String[] elements = userInput.split("\\s");

            if(elements.length == 3){
                if (elements[0].equals("greet")) {
                    for (Languages lang : Languages.values()) {
                        if(lang.toString().equals(elements[2])) {
                            method.greets(elements[1], lang);
                        }
                    }
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
}
