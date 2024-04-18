package part1.quicksort;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = nums1.length + nums2.length;
        int half = total / 2;
        int l = 0, r = nums1.length - 1;
        while (true) {
            int mid1 = (l + r) >> 1;
            int mid2 = half - mid1 - 2;

            int aLeft = mid1 >= 0 ? nums1[mid1] : Integer.MIN_VALUE;
            int aRight = mid1 + 1 < nums1.length ? nums1[mid1 + 1] : Integer.MAX_VALUE;
            int bLeft = mid2 >= 0 ? nums2[mid2] : Integer.MIN_VALUE;
            int bRight = mid2 + 1 < nums2.length ? nums2[mid2 + 1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                int minRight = Math.min(aRight, bRight);
                if (total % 2 != 0) {
                    return minRight;
                }
                return (Math.max(aLeft, bLeft) + minRight) / 2.0;
            }
            if (aLeft > bRight) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
