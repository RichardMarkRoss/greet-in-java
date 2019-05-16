package net.greet;

import net.greet.CommandPack.CommandExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommandExtractor {

    @Test
    public void ShouldTestIfNameIsStored() {
        try {
            CommandExtractor commandExtractor = new CommandExtractor("greet richard english");
            assertEquals(commandExtractor.getName(), "richard");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    public void ShouldTestElements() {
        try {
            CommandExtractor commandExtractor = new CommandExtractor("greet richard english");

            assertEquals(commandExtractor.getName(), "richard");
            assertEquals(commandExtractor.getLang(), "english");
            assertEquals(commandExtractor.getCommandEx(), "greet");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    public void ShouldTestIfLanguageIsStored(){
        try {
            CommandExtractor commandExtractor = new CommandExtractor("greet tanbang afrikaans");
            assertEquals(commandExtractor.getLang(), "afrikaans");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void ShouldTestIfCommandIsStored(){
        try {
            CommandExtractor commandExtractor = new CommandExtractor("greet tanbang");
            assertEquals(commandExtractor.getCommandEx(), "greet");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
