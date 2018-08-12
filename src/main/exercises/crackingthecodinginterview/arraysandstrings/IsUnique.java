package exercises.crackingthecodinginterview.arraysandstrings;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static boolean isUniqueBasic(String word) {
        int[] chars = new int[256];
        for(int i = 0; i < word.length(); i ++) {
            int charIndex = (int)word.charAt(i);
            chars[charIndex]++;
            if(chars[charIndex] > 1){
                return false;
            }
        }
        return true;
    }

    /*
     *  Mistakes made:
     *
     *  Java assumes that 1 << x is an integer (and therefore will have negative vals).
     *  create a long variable first, then shift: long num; num << x;
     *
     *  remember that if you create "pointers" (i.e. if value > 196, use last bitmap, else if...)
     *  you NEED TO BE DEALING WITH OBJECTS! doing this for primitive types DOES NOT update the original value
     *
     *  Double check logic (and conclusions) in if statements
     *
     */
    public static boolean isUniqueBitmap(String word) {
        long lte64 = 0;
        long lte128 = 0;
        long lte192 = 0;
        long lte256 = 0;
        for(int i = 0; i < word.length(); i++) {
            int chIndex = (int) word.charAt(i);
            long num = 1;
            boolean isUnique;
            // TODO apparently num << 63 is negative even when num is a long (and thus unsigned?)
            if(chIndex > 192) {
                chIndex -= 192;
                num = num << chIndex - 1;
                isUnique = (num & lte256) == 0;
                lte256 = lte256 | num;
            } else if(chIndex > 128) {
                chIndex -= 128;
                num = num << chIndex - 1;
                isUnique = (num & lte192) == 0;
                lte192 = lte192 | num;
            } else if(chIndex > 64) {
                chIndex -= 64;
                num = num << chIndex - 1;
                isUnique = (num & lte128) == 0;
                lte128 = lte256 | num;
            } else {
                num = num << chIndex - 1;
                isUnique = (num & lte64) == 0;
                lte64 = lte64 | num;
            }
            if(!isUnique) {
                return false;
            }
        }
        return true;
    }
}
