package net.greet;

import java.sql.*;

public class GreetDataBase implements GreetInterface {
    String username;
    String language;
    int counting;

    final String INSERT_USER_SQL = "insert into multiple_user (username, counter) values(?, ?)";
    final String COUNT_USER_SQL = "select count(*) From multiple_user where username = ?";
    final String UPDATE_USER_SQL = "update multiple_user set counter = ? where username = ?";
    final String SELECT_USER_SQL = "select username From multiple_user where username = ?";
    Connection conn;
    PreparedStatement psCreateNewUser;
    PreparedStatement psCountUsers;
    PreparedStatement psUpdateUser;
    PreparedStatement psSelectUser;


    GreetDataBase() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:./target/user_count", "sa", "");
            psCreateNewUser = conn.prepareStatement(INSERT_USER_SQL);
            psCountUsers = conn.prepareStatement(COUNT_USER_SQL);
            psUpdateUser = conn.prepareStatement(UPDATE_USER_SQL);
            psSelectUser = conn.prepareStatement(SELECT_USER_SQL);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void greets(String name, String language) {
        this.language = language;
        this.username = name;
        System.out.println("Username: " + username + "  " + psSelectUser);
        try {
            psSelectUser.setString(1,username);
            ResultSet rsDataBase = psSelectUser.executeQuery();
            System.out.println(rsDataBase);
            if (!rsDataBase.next()){
                psCreateNewUser.setString(1, username);
                psCreateNewUser.setInt(2, 1);
                psCreateNewUser.execute();
                System.out.println(rsDataBase);
                System.out.println(name + " has been passed in database!");
            } else {
                counting = rsDataBase.getInt("counter");
                psUpdateUser.setString(2, name);
                psUpdateUser.setInt(1, ++counting);
                psUpdateUser.execute();
                System.out.println(name + " name has been updated in database!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (language.equals("english")) {
            System.out.println("Hello " + name);
        } else if (language.equals("afrikaans")) {
            System.out.println("goeie dag " + name);
        } else if (language.equals("xhosa")) {
            System.out.println("Molo" + name);
        }
    }
    public void greet(String name){
        try {
            psSelectUser.setString(1, name);
            ResultSet rsDataBase = psSelectUser.executeQuery();
            System.out.println(rsDataBase);
            if (rsDataBase.next()) {
                psCreateNewUser.setString(1, name);
                psCreateNewUser.setInt(2, 1);
                psCreateNewUser.execute();
//                System.out.println(rsDataBase);
                System.out.println(name + " has been passed in database!");
            } else {
                counting = rsDataBase.getInt("counter");
                psUpdateUser.setString(2, name);
                psUpdateUser.setInt(1, ++counting);
                psUpdateUser.execute();
                System.out.println(name + " name has been updated in database!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Hello " + name);
    }

    @Override
    public void greeted(String username) {
        try {
                psCountUsers.setString(1,username);
                psCountUsers.executeQuery();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }

    @Override
    public void greetedAll() {
        try {
                PreparedStatement psReturnAll = conn.prepareStatement("select count(*) from multiple_user");
                System.out.println("amount of users:" + psReturnAll);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void counter() {
        try {
           psCountUsers.executeQuery();
            System.out.println("amount of users:" + psCountUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear(String user) {
        try {
            if (user != "") {
                PreparedStatement removeUser = null;
                removeUser = conn.prepareStatement("delete username, counter from multiple_user where username = ?");
                removeUser.setString(1, user);

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
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
}
