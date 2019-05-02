package net.greet;

import java.sql.*;

public class GreetDataBase implements GreetInterface {
    String username;
    String language;
//    int counting;

    final String INSERT_USER_SQL = "INSERT INTO multiple_user (username, counter) VALUES(?, ?)";
    final String COUNT_USER_SQL = "SELECT count(*) FROM multiple_user WHERE username = ?";
    final String UPDATE_USER_SQL = "UPDATE multiple_user SET counter = ? WHERE username = ?";
    final String SELECT_USER_SQL = "SELECT username, counter FROM multiple_user WHERE username = ?";
    final String DELETE_USER_SQL = "DELETE FROM multiple_user WHERE username = ?";
    final String COUNT_ALL_SQL = "SELECT count(*) FROM multiple_user";
    Connection conn;
    PreparedStatement psCreateNewUser;
    PreparedStatement psCountUsers;
    PreparedStatement psUpdateUser;
    PreparedStatement psSelectUser;
    PreparedStatement psDeleteUser;
    PreparedStatement psCountAll;

    GreetDataBase() {
        try {
            System.out.println("TRY");
//            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:./target/db/user_count", "sa", "");
            psCreateNewUser = conn.prepareStatement(INSERT_USER_SQL);
            psCountUsers = conn.prepareStatement(COUNT_USER_SQL);
            psUpdateUser = conn.prepareStatement(UPDATE_USER_SQL);
            psSelectUser = conn.prepareStatement(SELECT_USER_SQL);
            psDeleteUser = conn.prepareStatement(DELETE_USER_SQL);
            psCountAll = conn.prepareStatement(COUNT_ALL_SQL);
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("CATCH");
        }
        finally{
            System.out.println("Finally");
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
//            System.out.println(rsDataBase);
            if (!rsDataBase.next()){
                psCreateNewUser.setString(1, username);
                psCreateNewUser.setInt(2, 1);
                psCreateNewUser.execute();
                System.out.println(rsDataBase);
                System.out.println(name + " has been passed in database!");
            } else {
                int counting = rsDataBase.getInt("counter");
                psUpdateUser.setString(2, name);
                psUpdateUser.setInt(1, ++counting);
                psUpdateUser.executeUpdate();
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
                System.out.println(name + " has been passed in database!");
            } else {
                int counting = rsDataBase.getInt("counter");
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
               psCountAll.execute();
                System.out.println("amount of users:" + psCountAll.executeQuery());
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
                psDeleteUser.setString(1, user);
                psDeleteUser.execute();
            } else {
                System.out.println("User does not exist");
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
