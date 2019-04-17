//package net.greet;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class GreetTest {
//
//    @Test
//    public void ShouldTestIfNameisStoredinVar() {
//        Greet greet = new Greet();
//        greet.greet("greet richard english");
//        assertEquals(greet.username, "richard");
//    }
//
//    @Test
//    public void ShouldTestlangIsStoredinVar(){
//        Greet greet = new Greet();
//        greet.greet("greet tabang afrikaans");
//        assertEquals(greet.language, "afrikaans");
//    }
//
//
//
//    @Test
//    public void ShouldTestIfNameStoredinMap() {
//        Greet greet = new Greet();
//        greet.greet("greet richard english");
//        assertEquals(greet.hash.toString(), "{richard=1}");
//
//    }
//
//    @Test
//    public void ShouldTestIfMultipalNamesStoredinMap() {
//        Greet greet = new Greet();
//        greet.greet("greet richard english");
//        greet.greet("greet tabang afrikaans");
//        greet.greet("greet vusi xhosa");
//        greet.greet("greet andre english");
//        greet.greet("greet tido afrikaans");
//        greet.greet("greet nat xhosa");
//        assertEquals(greet.hash.toString(), "{richard=1, andre=1, nat=1, tabang=1, vusi=1, tido=1}");
//    }
//    @Test
//    public void shouldTestGreetedForNameLength(){
//        Greet greet = new Greet();
//        greet.help();
//    }
//}
