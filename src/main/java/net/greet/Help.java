package net.greet;

public class Help {

    public Help() {
        System.out.println("greet- followed by the name and the language the user is to be greeted in\n");
        System.out.println("greeted- should display a list of all users that has been greeted and how many time each user has been greeted\n");
        System.out.println("greeted- followed by a username returns how many times that username have been greeted\n");
        System.out.println("counter- returns a count of how many unique users has been greeted\n");
        System.out.println("clear- deletes of all users greeted and the reset the greet counter to 0\n");
        System.out.println("clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1\n");
        System.out.println("exit- exits the application\n");
        System.out.println("help- shows a user an overview of all possible commands\n");
    }
}
