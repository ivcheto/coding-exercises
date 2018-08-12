package exercises;

import java.util.*;

public class AnagramCount {

    public List<List<String>> solve(List<String> input) {
        List<List<String>> solution = new ArrayList<>();
        Map<String, Set<String>> wordAnagrams = new HashMap<>();
        for(String word: input) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            Set<String> anagrams = wordAnagrams.getOrDefault(sorted, new HashSet<>());
            anagrams.add(word);
            wordAnagrams.put(sorted, anagrams);
        }
        for(Set<String> anagrams: wordAnagrams.values()) {
            solution.add(new ArrayList<>(anagrams));
        }
        return solution;
    }
}
