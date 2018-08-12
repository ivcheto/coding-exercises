package exercises.crackingthecodinginterview.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationsTest {


    @Test
    public void can_identify_different_lengths_as_non_permutations(){
        String s1 = "I'm string 1";
        String s2 = "I am string 2";

        assertFalse(Permutations.isPermutationBasic(s1, s2));
    }

    @Test
    public void can_identify_alphabet_permutations(){
        String s1 = "ILikepizzA";
        String s2 = "ziIAipkezL";

        assertTrue(Permutations.isPermutationBasic(s1, s2));
    }

    @Test
    public void can_identify_alphabet_non_permutations(){
        String s1 = "aabcdeft";
        String s2 = "aabcdefg";

        assertFalse(Permutations.isPermutationBasic(s1, s2));
    }

    @Test
    public void can_identify_alphanumeric_chars_permutations(){
        String s1 = "a1b2c3d4e5";
        String s2 = "abcde12345";

        assertTrue(Permutations.isPermutationBasic(s1, s2));
    }

    @Test
    public void can_identify_alphanumeric_chars_non_permutations(){
        String s1 = "a1b2c3d4e5";
        String s2 = "acbde12346";

        assertFalse(Permutations.isPermutationBasic(s1, s2));
    }

    @Test
    public void can_identify_speial_chars_non_permutations(){
        String s1 = "Hello World!";
        String s2 = "!WorldHello ";

        assertTrue(Permutations.isPermutationBasic(s1, s2));
    }

    @Test
    public void can_identify_special_chars_non_permutations(){
        String s1 = "Hello World!";
        String s2 = "Hello_World@";

        assertFalse(Permutations.isPermutationBasic(s1, s2));
    }
}
