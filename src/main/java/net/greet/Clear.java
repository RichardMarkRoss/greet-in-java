package net.greet;

public class Clear extends Main {
    @Override
    public void clear(String username) {
        if (username != "") {
            hash.remove(username);
        } else {
            hash.clear();
        }
    }

}
