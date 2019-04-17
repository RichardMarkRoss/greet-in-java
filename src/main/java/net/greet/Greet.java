package net.greet;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Greet extends DataBaseMig {
    String username;
    String language;
    int counterForUser;
//    ResultSet results;
    @Override
    public void greet(String name) {
        String[] elements = name.split("\\s");
        this.username = elements[1];
        this.language = elements[2];

            try {
                ResultSet rsDataBase = psSelectUser.executeQuery();
                if(rsDataBase.next()) {
                    psCreateNewUser.setString(1, username);
                    psCreateNewUser.setInt(2, 1);
                    psCreateNewUser.execute();
                }else{
                    int Count = rsDataBase.getInt("counter");
                    psUpdateUser.setString(1, username);
                    psUpdateUser.setInt(2, ++Count);
                    psUpdateUser.execute();
                }
            }catch (Exception e){
                System.out.println(e);

            if (language.equals("english")) {
                System.out.println("Hello " + username);
            } else if (language.equals("afrikaans")) {
                System.out.println("goeie dag " + username);
            } else if (language.equals("xhosa")) {
                System.out.println("Molo" + username);
            }
            System.out.println("your name has been successfully greeted!");
        }
    }

    @Override
    public void greeted(String username) {
        String Username = username;
//        hash.get(Username).equals(Username);
//        int mapSize = hash.get(Username);
//        System.out.println(Username + " has been greeted: " + mapSize);
    try{
      if(!Username.equals(null)) {
          psCountUsers.executeQuery();
      }else{

      }
    }catch(SQLException e){
        System.out.println(e);
        }
    }

    @Override
    public void greetedAll() {

        for (HashMap.Entry<String, Integer> entry : hash.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            Integer value = entry.getValue();
            System.out.println(value);
            System.out.println(value + " has been greeted " + key + " times");
        }

    }

    @Override
    public String help() {
        String help = "greet- followed by the name and the language the user is to be greeted in,\n" +
                "greeted- should display a list of all users that has been greeted and how many time each user has been greeted,\n" +
                "greeted- followed by a username returns how many times that username have been greeted,\n" +
                "counter- returns a count of how many unique users has been greeted,\n" +
                "clear- deletes of all users greeted and the reset the greet counter to 0,\n" +
                "clear- followed by a username delete the greet counter for the specified user and decrement the greet counter by 1,\n" +
                "exit- exits the application,\n" +
                "help- shows a user an overview of all possible commands.";
        return help;
    }

    @Override
    public void counter() {
        System.out.println("amount of user are : " + hash.size());
    }

    @Override
    public void clear(String username) {
        if (username != "") {
            hash.remove(username);
        } else {
            hash.clear();
        }
    }

}
