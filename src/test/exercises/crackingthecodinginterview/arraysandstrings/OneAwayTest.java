package exercises.crackingthecodinginterview.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneAwayTest {

    @Test
    public void add_one_character() {
        assertTrue(OneAway.solve("bake", "bakes"));
    }

    @Test
    public void add_two_characters() {
        assertFalse(OneAway.solve("bake", "bakess"));
    }

    @Test
    public void add_one_character_change_one_character() {
        assertFalse(OneAway.solve("bake", "bales"));
    }

    @Test
    public void change_one_character() {
        assertTrue(OneAway.solve("bake", "bale"));
    }

    @Test
    public void change_two_characters() {
        assertFalse(OneAway.solve("bake", "back"));
    }
}
