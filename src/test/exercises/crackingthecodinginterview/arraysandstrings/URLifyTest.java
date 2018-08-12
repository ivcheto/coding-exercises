package exercises.crackingthecodinginterview.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class URLifyTest {

    @Test
    public void no_spaces() {
        String s = "ThereAreNospacesHERE";
        char[] arr1 = s.toCharArray();
        char[] arr2 = s.toCharArray();

        URLify.urlifyQ(arr1, s.length());

        for(int i = 0; i < arr1.length; i++) {
            assertEquals(s.charAt(i), arr1[i], "urlifyNoQ failed for no spaces");
        }
        for(int i = 0; i < arr1.length; i++) {
            assertEquals(s.charAt(i), arr2[i], "urlifyNoQ failed for no spaces");
        }
    }

    @Test
    public void starts_with_spaces() {
        String s = " the first char is a space";
        String expected = "%20the%20first%20char%20is%20a%20space";
        char[] arr1 = prepareCharArray(s, 6);
        char[] arr2 = prepareCharArray(s, 6);

        URLify.urlifyQ(arr1, s.length());
        URLify.urlifyNoQ(arr2, s.length());

        assertEquals(expected, new String(arr1), "urlifyQ failed for space at the beginning");
        assertEquals(expected, new String(arr2), "urlifyNoQ failed for space at the beginning");
    }

    @Test
    public void ends_with_spaces() {
        String s = "There is a space right here: ";
        String expected = "There%20is%20a%20space%20right%20here:%20";
        char[] arr1 = prepareCharArray(s, 6);
        char[] arr2 = prepareCharArray(s, 6);

        URLify.urlifyQ(arr1, s.length());
        URLify.urlifyNoQ(arr2, s.length());

        assertEquals(expected, new String(arr1), "urlifyQ failed for space at the end");
        assertEquals(expected, new String(arr2), "urlifyNoQ failed for space at the end");
    }

    @Test
    public void equal_number_of_spaces() {
        String s = "a b c d e f g ";
        String expected = "a%20b%20c%20d%20e%20f%20g%20";
        char[] arr1 = prepareCharArray(s, 7);
        char[] arr2 = prepareCharArray(s, 7);

        URLify.urlifyQ(arr1, s.length());
        URLify.urlifyNoQ(arr2, s.length());

        assertEquals(expected, new String(arr1), "urlifyQ failed for equal number of spaces");
        assertEquals(expected, new String(arr2), "urlifyNoQ failed for equal number of spaces");
    }

    private char[] prepareCharArray(String s, int numSpace) {
        char[] arr = new char[s.length() + numSpace * 2];
        copyStringIntoArray(s, arr, arr.length);
        return arr;
    }

    private void copyStringIntoArray(String s, char[] arr, int maxLength) {
        int i = 0;
        while(i < maxLength && i < s.length()) {
            arr[i] = s.charAt(i);
            i++;
        }
    }
}

