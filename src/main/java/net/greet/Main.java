package net.greet;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        CommandExecutor executor = new CommandExecutor();
        System.out.println("type help for more commands");
        String userInput = "";

        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();

            CommandExtractor extractor = new CommandExtractor(userInput);
            executor.execute(extractor);
        }
        System.out.println("Thank you for your time!");
    }
}
