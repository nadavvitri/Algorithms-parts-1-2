package analysisofalgorithms;

public class BitonicArray {
    public int search(int[] nums, int target) {
        int peek = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                peek = i;
                break;
            }
        }
        if (peek == -1) {
            return binarySearch(0, nums.length - 1, nums, target);
        }
        return Math.max(binarySearch(0, peek, nums, target),
                binarySearch(peek + 1, nums.length - 1, nums, target));
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int searchOptimised(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[l] <= target && target < nums[m]) {
                r = m - 1;
            } else if (nums[m] < target && target <= nums[r]) {
                l = m + 1;
            } else if (nums[m] <= nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BitonicArray bitonicArray = new BitonicArray();
        System.out.println(bitonicArray.searchOptimised(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(bitonicArray.searchOptimised(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(bitonicArray.searchOptimised(new int[]{1, 3}, 2));
        System.out.println(bitonicArray.searchOptimised(new int[]{1, 3}, 3));
    }
}
