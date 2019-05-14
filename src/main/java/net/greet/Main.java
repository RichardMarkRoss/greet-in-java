package net.greet;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);

        System.out.println("type help for more commands");
        String userInput = "";

        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();

            CommandExtractor extractor = new CommandExtractor(userInput);
            CommandExecutor executor = new CommandExecutor(extractor);
            executor.extractor();

        }
        System.out.println("Thank you for your time!");
    }
}
