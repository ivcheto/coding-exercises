package exercises.crackingthecodinginterview.arraysandstrings;

import java.util.Arrays;

public class IsPalindromePermutation {

    public static boolean isPalindromePermutationSort(String s) {
        char[] chars = s.toCharArray();
        toLowerCase(chars);
        Arrays.sort(chars);
        boolean foundOdd = false;
        int i = 0;
        while(i < chars.length) {
            if(isValidChar(chars[i])) {
                if(i + 1 == chars.length) {
                    return foundOdd == false;
                } else {
                    if(chars[i] != chars[i + 1]) {
                        if(foundOdd) {
                            return false;
                        } else {
                            foundOdd = true;
                            i ++;
                        }
                    } else {
                        i += 2;
                    }
                }
            } else {
                i++;
            }
        }
        return true;
    }

    private static boolean isValidChar(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static void toLowerCase(char[] chars) {
        int offset = 'a' - 'A';
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c >= 'A' && c <= 'Z') {
                chars[i] += offset;
            }
        }
    }

    public static boolean isPalindromePermutation(String s) {
        s = s.toLowerCase();
        int[] chars = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(inValidRange(c)) {
                chars[(int)c]++;
            }
        }
        boolean foundOdd = false;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] % 2 != 0) {
                if(!foundOdd) {
                    foundOdd = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean inValidRange(char c) {
        if((c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}
