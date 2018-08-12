package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
// TODO put this in some package
public class ThreeSumTest {

    ThreeSum threeSum;

    @BeforeEach
    public void setup() {
        threeSum = new ThreeSum();
    }

    @Test
    public void hello_world_test() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> solution = threeSum.solve(nums);
        assertEquals(2, solution.size());
    }
}
