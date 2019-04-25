package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetDataBaseTest {

//    @Test
//    public void ShouldTestIfNameisStoredinVar() {
//        Greet greetDataBase = new Greet();
//        greetDataBase.greet("greet richard english");
//        assertEquals(greetDataBase.username, "richard");
//    }
//
//    @Test
//    public void ShouldTestlangIsStoredinVar(){
//        Greet greetDataBase = new Greet();
//        greetDataBase.greet("greet tabang afrikaans");
//        assertEquals(greetDataBase.language, "afrikaans");
//    }
    @Test
    public void shouldTestGreetedForNameLength(){
        GreetDataBase greetDataBase = new GreetDataBase();
        greetDataBase.help();
    }
//    @Test
//    public void ShouldTestIfNameStoredinMap() {
//        DataBaseMig greet = new DataBaseMig();
//        greet.greet("greet richard english");
//        assertEquals(greet.toString(), "{richard=1}");
//
//    }
//
//    @Test
//    public void ShouldTestIfMultipalNamesStoredinMap() {
//        GreetDataBase greet = new GreetDataBase();
//        greet.greet("greet richard english");
//        greet.greet("greet tabang afrikaans");
//        greet.greet("greet vusi xhosa");
//        greet.greet("greet andre english");
//        greet.greet("greet tido afrikaans");
//        greet.greet("greet nat xhosa");
//        assertEquals(greet.hash.toString(), "{richard=1, andre=1, nat=1, tabang=1, vusi=1, tido=1}");
//    }

}
