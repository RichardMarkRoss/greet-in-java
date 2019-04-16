package net.greet;


public class Greet extends Main {
    String username;
    String language;
    int counterForUser;

    @Override
    public void greet(String name) {
        String[] elements = name.split("\\s");
        this.username = elements[1];
        this.language = elements[2];

        if (!hash.containsKey(username)) {
            this.hash.put(username, 0);
//            System.out.println("Hello " + username);
        }
        if (language != "" && hash.containsKey(username)) {
            counterForUser = this.hash.get(username);
            counterForUser++;
            this.hash.put(username, counterForUser);

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
}
