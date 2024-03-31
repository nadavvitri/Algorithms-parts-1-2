package analysis.of.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int comp = -nums[i] - nums[j];
                if (binarySearch(nums, j + 1, comp)) {
                    output.add(Arrays.asList(nums[i], nums[j], comp));
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
            }
        }
        return output;
    }

    private boolean binarySearch(int[] nums, int l, int target) {
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
