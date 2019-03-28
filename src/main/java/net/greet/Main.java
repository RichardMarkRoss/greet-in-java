package net.greet;
import net.greet.Greet;
import net.greet.*;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner userIn = new Scanner(System.in);
        while (true) {
            if (args[0] == "greet") {
                Greet Class = new Greet(userIn.nextLine());
            }else if(args[0] == "greeted"){
                Greeted nameList = new Greeted();
            }else if(args[0] == "counter"){
                Counter nameList = new Counter(userIn.nextLine());
            }else if(args[0] == "clear"){
                Clear removeName = new Clear();
            }else if(args[0] == "help"){
                Help returnList = new Help();
            }else if(args[0] == "exit"){
                Exit exit = new Exit();
            }
        }
    }
}
