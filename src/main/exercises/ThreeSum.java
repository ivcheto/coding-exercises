package exercises;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> solve(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++){
                    int first = nums[i];
                    int second = nums[j];
                    int third = nums[k];
                    if(first + second + third == 0) {
                        res.add(Arrays.asList(first, second, third));
                    }
                }
            }
        }
        return new ArrayList(res);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int[][] twoSums = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                twoSums[i][j] = nums[i] + nums[j];
            }
        }
        Set<List<Integer>> res = new HashSet<>();
        int i = 0;
        int j = 1;
        int numIndex = nums.length -  1;
        while(numIndex > i) {
            if(numIndex <= j) {
                i++;
                j = i + 1;
                numIndex = nums.length - 1;
            } else if (nums[numIndex] + twoSums[i][j] < 0) {
                j++;
            } else if (nums[numIndex] + twoSums[i][j] > 0) {
                numIndex--;
            } else {
                res.add(Arrays.asList(nums[i], nums[j], nums[numIndex]));
                j++;
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}
