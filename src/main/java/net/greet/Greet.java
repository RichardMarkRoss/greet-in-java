package net.greet;

import java.util.Scanner;

public class Greet {
private String username;
private int counter;
    public Greet(String name) {

        this.username = name;
        if(this.username != null) {
            this.counter++;
            System.out.println("Hello my name is " + username);
            System.out.println("Name has been greeted " + counter);
        }else{
            System.out.println("please insert name");
        }
    }
}