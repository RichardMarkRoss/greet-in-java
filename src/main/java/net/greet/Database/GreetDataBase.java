package net.greet.Database;

import net.greet.CommandPack.GreetInterface;
import net.greet.enums.Languages;

import java.sql.*;

public class GreetDataBase implements GreetInterface {
    String username;
    String language;
    String holdString;

    final String INSERT_USER_SQL = "INSERT INTO multiple_user (username, counter) VALUES(?, ?)";
    final String UPDATE_USER_SQL = "UPDATE multiple_user SET counter = ? WHERE username = ?";
    final String SELECT_USER_SQL = "SELECT username, counter FROM multiple_user WHERE username = ?";
    final String SELECT_ALL_SQL = "SELECT username, counter FROM multiple_user";
    final String DELETE_USER_SQL = "DELETE FROM multiple_user WHERE username = ?";
    final String DELETE_ALL_SQL = "DELETE FROM multiple_user";
    final String COUNT_ALL_SQL = "SELECT count(*) FROM multiple_user";

    Connection conn;

    PreparedStatement psCreateNewUser;
    PreparedStatement psSelectAll;
    PreparedStatement psUpdateUser;
    PreparedStatement psSelectUser;
    PreparedStatement psDeleteUser;
    PreparedStatement psDeleteAll;
    PreparedStatement psCountAll;

    public GreetDataBase() {

        try {
            conn = DriverManager.getConnection("jdbc:h2:./target/db/user_count", "sa", "");
            psCreateNewUser = conn.prepareStatement(INSERT_USER_SQL);
            psSelectAll = conn.prepareStatement(SELECT_ALL_SQL);
            psUpdateUser = conn.prepareStatement(UPDATE_USER_SQL);
            psSelectUser = conn.prepareStatement(SELECT_USER_SQL);
            psDeleteUser = conn.prepareStatement(DELETE_USER_SQL);
            psDeleteAll = conn.prepareStatement(DELETE_ALL_SQL);
            psCountAll = conn.prepareStatement(COUNT_ALL_SQL);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public String greets(String name, Languages lang) {

        try {
            psSelectUser.setString(1,name);
            ResultSet rsDataBase = psSelectUser.executeQuery();
            if (!rsDataBase.next()){
                psCreateNewUser.setString(1, name);
                psCreateNewUser.setInt(2, 1);
                psCreateNewUser.execute();
            } else {
                int counting = rsDataBase.getInt("counter");
                psUpdateUser.setString(2, name);
                psUpdateUser.setInt(1, ++counting);
                psUpdateUser.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try{
            return holdString = Languages.valueOf(lang.toString()).getAction() + name;
        } catch(Exception er){
            return Languages.valueOf("english").getAction() + name;
        }
    }

    @Override
    public String greeted(String username) {
        try {
            psSelectUser.setString(1, username);
            ResultSet counts = psSelectUser.executeQuery();
            if (counts.next()){
                return username + " has been greeted " + counts.getInt("counter") + " time/s!";
                }
            else{
                return username + " has not been greeted.";
            }
        } catch (SQLException ex) {
                return "Please greet valid user";
        }
    }

    @Override
    public String greetedAll() {
        String userList = "Please greet a users";
        try {
            ResultSet rs = psCountAll.executeQuery();
            rs.next();
            int counter = rs.getInt(1);
            if(counter != 0){
                userList = "";
            }
            ResultSet counts = psSelectAll.executeQuery();
            while(counts.next()) {
                userList += "User " + counts.getString("username") + " has been greeted " + counts.getInt("counter") + " time/s.\n";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public String counter() {
        String result;
        try {

            ResultSet rs = psCountAll.executeQuery();

            rs.next();
                int counter = rs.getInt(1);
                result = Integer.toString(counter);

        } catch (SQLException ex) {
            return "please greet a user";
        }
        return result;
    }

    @Override
    public String clear(String user) {
        try {
            psSelectUser.setString(1, user);
            ResultSet counts = psSelectUser.executeQuery();
            if(!user.isEmpty()) {
                if (counts.next()) {
                    psDeleteUser.setString(1, user);
                    psDeleteUser.execute();
                    return user + " has been deleted";
                }
            }else{
                psDeleteAll.execute();
                return "Map has been cleared!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
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
}
