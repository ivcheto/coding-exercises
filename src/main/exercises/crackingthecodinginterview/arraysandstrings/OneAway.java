package exercises.crackingthecodinginterview.arraysandstrings;

public class OneAway {

    public static boolean solve(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        boolean foundDiff = false;
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        while (i1 >= 0 && i2 >= 0) {
            if(s1.charAt(i1) != s2.charAt(i2)) {
                if(foundDiff) {
                    return false;
                } else {
                    foundDiff = true;
                    if(i1 > i2) {
                        i1--;
                    } else if (i2 > i1) {
                        i2--;
                    } else {
                        i1--;
                        i2--;
                    }
                }
            } else {
                i1--;
                i2--;
            }
        }
        if(i1 != i2 && foundDiff) {
            return false;
        }
        return true;
    }

}
