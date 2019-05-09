package net.greet;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
     CommandExtractor extractor = new CommandExtractor();

        System.out.println("type help for more commands");
        String userInput = "";

        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();
            extractor.extractor(userInput);
        }
        System.out.println("Thank you for your time!");
    }
}
