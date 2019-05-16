package net.greet;

import net.greet.CommandPack.CommandExecutor;
import net.greet.CommandPack.CommandExtractor;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        CommandExecutor executor = new CommandExecutor();
        System.out.println("type in a command (type help for valid commands)-->");
        String userInput = "";

        while (!userInput.equals("exit")) {
            userInput = insert.nextLine();
            CommandExtractor extractor = new CommandExtractor(userInput);
            System.out.println(executor.execute(extractor));
        }
        System.out.println("Thank you for your time!");
    }
}
