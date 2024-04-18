package part1.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                int comp = target - (nums[i] + nums[j]);
                List<Pair> res = twoSum(nums, j + 1, comp);
                addAll(res, nums[i], nums[j]);
            }

        }
        return output;
    }

    private void addAll(List<Pair> pairs, int x, int y) {
        for (Pair p : pairs) {
            output.add(Arrays.asList(p.getX(), p.getY(), x, y));
        }
    }

    private List<Pair> twoSum(int[] nums, int l, int target) {
        List<Pair> res = new ArrayList<>();
        int r = nums.length - 1;
        while (l < r) {
            int curSum = nums[l] + nums[r];
            if (curSum > target) {
                r--;
            } else if (curSum < target) {
                l++;
            } else {
                res.add(new Pair(nums[l], nums[r]));
                l++;
                r--;
            }
        }
        return res;
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(new FourSum().fourSum(nums, 0));

    }
}
