package net.greet.GreetMap;

import net.greet.CommandPack.GreetInterface;
import net.greet.enums.Languages;

import java.util.HashMap;
import java.util.Map;

/*
* todo: remove all print stmnt
*  fix clear without user
* */
public class Greet implements GreetInterface {
    Map<String, Integer> hash = new HashMap<String, Integer>();
    public String username = "";
    public int counterForUser;

    @Override
    public String greets(String username, Languages lang) {
        this.username = username;
        if (!hash.containsKey(username)) {
            this.hash.put(username, 0);
        }

        if (hash.containsKey(username)) {
            int counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);
        }

        try{
            return Languages.valueOf(lang.toString()).getAction() + username;
        } catch(Exception ex) {
            return Languages.valueOf("english").getAction() + username;
        }
    }


    @Override
    public String greeted(String username) {
        try {
            hash.get(username).equals(username);
            int mapSize = hash.get(username);
            return username + " has been greeted: " + mapSize;
        } catch (Exception e) {
            return "Please insert valid username";
        }
    }
    @Override
    public String greetedAll(){
        String userList = "";
        try {
            if(!hash.isEmpty()) {
                for (HashMap.Entry<String, Integer> entry : hash.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    userList += key + " has been greeted " + value + " times";
                }
            }else{
                return "Please greet a user";
            }
        }catch(Exception e){
            return "";
        }
        return userList;
    }

    @Override
    public String help() {
        String help = "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "count- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.";
        return help;
    }

    @Override
    public String counter() {
        int hashSize = hash.size();
        String counter = Integer.toString(hashSize);
        return counter;

    }

    @Override
    public String clear(String username) {
        if (!username.isEmpty()) {
            hash.remove(username);
            return username + " has been deleted!";
        } else {
            hash.clear();
            return "Map has been cleared!";
        }
    }
}
