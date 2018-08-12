package exercises;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramCountTest {

    AnagramCount anagramCount;

    @BeforeEach
    public void setup(){
        anagramCount = new AnagramCount();
    }

    @Test
    public void correctly_gropus_anagrams() {
        List<String> input = List.of("cab", "cab", "xxy", "bca", "bac", "dash", "shad");

        List<List<String>> solution = anagramCount.solve(input);

        //[
        //    ['cab', ‘bca', 'bac’],
        //    ['xxy'],
        //    ['dash', 'shad']
        //]
        assertEquals(3, solution.size());
        assertEquals(List.of("cab", "bca", "bak"), solution.get(0));
        assertEquals(List.of("xxy"), solution.get(1));
        assertEquals(List.of("dash", "shad"), solution.get(2));

    }

}
