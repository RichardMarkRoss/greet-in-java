package net.greet;

import java.sql.*;

public class GreetDataBase implements GreetInterface {
    String username;
    String language;
    int counting;

    final String INSERT_USER_SQL = "insert into user_count_data (username, counter) values(?, ?)";
    final String COUNT_USER_SQL = "select count(*) From user_count_data";
    final String UPDATE_USER_SQL = "update user_count_data set counter = ? where username = ?";
    final String SELECT_USER_SQL = "select username From user_count_data where username = ?";
    Connection conn;
    PreparedStatement psCreateNewUser;
    PreparedStatement psCountUsers;
    PreparedStatement psUpdateUser;
    PreparedStatement psSelectUser;
    Greet greet = new Greet();

    public void jdbcGreetUser() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./db/user_count", "sa", "");
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
        try {
//            psSelectUser.setString(1,username);
//            ResultSet rsDataBase = psSelectUser.executeQuery();
//            System.out.println(rsDataBase);
//            if (rsDataBase.next()) {
                psCreateNewUser.setString(1, name);
                psCreateNewUser.setInt(2, 1);
                psCreateNewUser.execute();
//                ResultSet rsDataBase = psSelectUser.executeQuery();
//                System.out.println(rsDataBase);
                System.out.println(name + " has been passed in database!");
//            } else {
//                counting = rsDataBase.getInt("counter");
//                psUpdateUser.setString(1, username);
//                psUpdateUser.setInt(2, ++counting);
//                psUpdateUser.execute();
//                System.out.println(username + " name has been updated in database!");
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (language.equals("english")) {
            System.out.println("Hello " + username);
        } else if (language.equals("afrikaans")) {
            System.out.println("goeie dag " + username);
        } else if (language.equals("xhosa")) {
            System.out.println("Molo" + username);
        }
    }
    public void greet(String username){

    }

    @Override
    public void greeted(String username) {
        try {
            if (!username.equals("")) {
                psCountUsers.executeQuery();
            } else {
                PreparedStatement psReturnAll = conn.prepareStatement("select count(*) from multiple_user");
                System.out.println("amount of users:" + psReturnAll);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void greetedAll() {

    }

    @Override
    public void counter() {
        PreparedStatement psReturnAll = null;
        try {
            psReturnAll = conn.prepareStatement("select count(*) from multiple_user");
            System.out.println("amount of users:" + psReturnAll);
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
