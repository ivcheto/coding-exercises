package exercises.crackingthecodinginterview.arraysandstrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IsUniqueTest {

    @Test
    public void unique_alphabet_example() {
        String word = "abcdefGhIjKLmnopqrsTUvwxyZ";

        assertTrue(IsUnique.isUniqueBasic(word), "isUniqueBasic failed on unique alphabet word");
        assertTrue(IsUnique.isUniqueBitmap(word), "isUniqueBitmap failed on unique alphabet word");
    }

    @Test
    public void non_unique_alphabet_example() {
        String word = "HelloWorld";
        assertFalse(IsUnique.isUniqueBasic(word), "isUniqueBasic failed on non-unique alphabet word");
        assertFalse(IsUnique.isUniqueBitmap(word), "isUniqueBitmap failed on non-unique alphabet word");
    }

    @Test
    public void unique_alphanumeric_example() {
        String word = "abc1234567890";
        assertTrue(IsUnique.isUniqueBasic(word), "isUniqueBasic failed on unique alphanumeric word");
        assertTrue(IsUnique.isUniqueBitmap(word), "isUniqueBitmap failed on unique alphanumeric word");

    }

    @Test
    public void non_unique_alphanumeric_example() {
        String word = "Number1223";
        assertFalse(IsUnique.isUniqueBasic(word), "isUniqueBasic failed on non-unique alphanumeric word");
        assertFalse(IsUnique.isUniqueBitmap(word), "isUniqueBitmap failed on non-unique alphanumeric word");

    }

    @Test
    public void unique_special_chars_example() {
        String word = "!@#$%^& *()_";

        assertTrue(IsUnique.isUniqueBasic(word), "isUniqueBasic failed on unique special chars word");
        assertTrue(IsUnique.isUniqueBitmap(word), "isUniqueBitmap failed on unique special chars word");
    }

    @Test
    public void non_unique_special_chars_example() {
        String word = "Hi World!!@#^";
        assertFalse(IsUnique.isUniqueBasic(word), "isUniqueBasic failed on non-unique special chars word");
        assertFalse(IsUnique.isUniqueBitmap(word), "isUniqueBitmap failed on non-unique special chars word");
    }
}
