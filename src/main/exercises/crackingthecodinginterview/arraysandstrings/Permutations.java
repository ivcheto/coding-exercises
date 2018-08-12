package exercises.crackingthecodinginterview.arraysandstrings;

/**
 * Given two strings, write a method to decide if one
 * is a permutation of the other.
 */
public class Permutations {
    public static boolean isPermutationBasic(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int[] chars = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            int index = (int)s1.charAt(i);
            chars[index]++;
        }
        for(int j = 0; j < s2.length(); j++) {
            int index = (int)s2.charAt(j);
            chars[index]--;
            if(chars[index] < 0) {
                return false;
            }
        }
        return true;
    }

    // TODO implement using sorting
    public boolean isPermutationsSorting(String s1, String s2) {
        return false;
    }

    // TODO implement using unicode
    public boolean isPermutationsUnicode(String s1, String s2) {
        return false;
    }
}
