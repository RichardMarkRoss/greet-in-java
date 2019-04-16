package net.greet;

import java.util.HashMap;

public class Greeted extends Main{
    @Override
    public void greeted(String username) {
        String Username = username;
        hash.get(Username).equals(Username);
        int mapSize = hash.get(Username);
        System.out.println(Username + " has been greeted: " + mapSize);


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
}
