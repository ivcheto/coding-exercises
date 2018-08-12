package exercises.crackingthecodinginterview.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPalindromePermutationTest {

    @Test
    public void basic_palindrome() {
        assertTrue(IsPalindromePermutation.isPalindromePermutation("rracace"),
                "regular method failed for basic palindrome");
        assertTrue(IsPalindromePermutation.isPalindromePermutationSort("rracace"),
                "sort method failed for basic palindrome");
    }

    @Test
    public void basic_non_palindrome() {
        assertFalse(IsPalindromePermutation
                .isPalindromePermutation("rracacce"), "regular method failed for basic non palindrome");
        assertFalse(IsPalindromePermutation
                .isPalindromePermutationSort("rracacce"), "sort method failed for basic non palindrome");
    }

    @Test
    public void palindrome_with_lower_and_upper() {
        assertTrue(IsPalindromePermutation.isPalindromePermutation(" Ctoatac"),
                "regular method failed for palindrome with upper and lower");
        assertTrue(IsPalindromePermutation.isPalindromePermutationSort(" Ctoatac"),
                "sort method failed for palindrome with upper and lower");
    }

    @Test
    public void non_palindrome_wit_lower_and_upper() {
        assertFalse(IsPalindromePermutation.isPalindromePermutation(" cAoa"),
                "regular method failed for non palindrome with upper and lower");
        assertFalse(IsPalindromePermutation.isPalindromePermutationSort(" cAoa"),
                "sort method failed for non palindrome with upper and lower");
    }

    @Test
    public void long_palindrome() {
        String s = "abaabaabaabaabaabaabaabaabaabaabaabaabaabaabaabaabaabaabaabac";
        assertTrue(IsPalindromePermutation.isPalindromePermutation(s),
                "regular method failed for long palindrome");
        assertTrue(IsPalindromePermutation.isPalindromePermutationSort(s),
                "sort method failed for long palindrome");
    }

    @Test
    public void long_non_palindrome() {
        String s = "anaanaanaanaanaanaanaanaanaanaanaanaanaanaanaanakl";
        assertFalse(IsPalindromePermutation.isPalindromePermutation(s),
                "regular method failed for long non palindrome");
        assertFalse(IsPalindromePermutation.isPalindromePermutationSort(s),
                "sort method failed for long non palindrome");
    }
}
