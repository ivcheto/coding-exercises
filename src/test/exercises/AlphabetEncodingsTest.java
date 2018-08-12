package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlphabetEncodingsTest {

    AlphabetEncodings encodings;

    @BeforeEach
    public void setup() {
        encodings = new AlphabetEncodings();
    }

    @Test
    public void encodings_for_simple_case() {
        List<String> res = encodings.getEncodings(123);
        assertEquals(3, res.size());
        assertTrue(res.contains("bx"));
        assertTrue(res.contains("md"));
        assertTrue(res.contains("bcd"));
    }

    @Test
    public void encodings_for_single_digit() {
        List<String> res = encodings.getEncodings(3);
        assertEquals(1, res.size());
        assertEquals("d", res.get(0));
    }

    @Test
    public void longer_example() {
        List<String> res = encodings.getEncodings(31251);
        assertEquals(3, res.size());
        assertTrue(res.contains("dbcfb"));
        assertTrue(res.contains("dbzb"));
        assertTrue(res.contains("dmfb"));
    }

    @Test
    public void number_containing_zero() {
        List<String> res = encodings.getEncodings(20145);
        assertEquals(4, res.size());
        assertTrue(res.contains("cabef"));
        assertTrue(res.contains("ubef"));
        assertTrue(res.contains("uof"));
        assertTrue(res.contains("caof"));
    }
}
