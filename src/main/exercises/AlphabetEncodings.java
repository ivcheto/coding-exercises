package exercises;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a number, return a list of all english strings for which
 * the number could be an encoding, assuming 'a' = 0, 'b' = 1, ..., 'z' = 25.
 * The List should not contain duplicates
 *
 * i.e. getEncodings(123) would return ["bx", "md", "bcd"]
 */
public class AlphabetEncodings {

    public List<String> getEncodings(int num) {
        char[] chars = initializeAlphabetArray();
        Map<Integer, Set<String>> solutions = new HashMap<>();
        helper(chars, solutions, num);
        return new ArrayList<>(solutions.get(num));
    }

    private char[] initializeAlphabetArray() {
        char[] res = new char[26];
        for(int i = 0; i < 26; i++) {
            res[i] = (char)('a' + i);
        }
        return res;
    }

    private Set<String> helper(char[] chars, Map<Integer, Set<String>> solutions, int num) {
        if(solutions.containsKey(num)) {
            return solutions.get(num);
        } else {
            Set<String> solution = new HashSet<>();
            if(num < 10) {
                solution.add("" + chars[num]);
            } else {
                int last = num % 10;
                Set<String> s1 = helper(chars, solutions, num/10);
                s1 = appendToEnd(s1, chars[last]);
                solution.addAll(s1);
                int lastTwo = num % 100;
                if(lastTwo < 26 && lastTwo > 9) {
                    if(num > 100) {
                        s1 = helper(chars, solutions, num/100);
                        s1 = appendToEnd(s1, chars[lastTwo]);
                        solution.addAll(s1);
                    } else {
                        solution.add("" + chars[lastTwo]);
                    }
                }
            }
            solutions.put(num, solution);
            return solution;
        }
    }

    private Set<String> appendToEnd(Set<String> list, char c) {
        // TODO how the hell to do this using streams???
//        return list.stream().map(s -> s + c).collect(Collectors.toSet());
        Set<String> res = new HashSet<>();
        for(String s: list) {
            res.add(s + c);
        }
        return res;
    }
}
