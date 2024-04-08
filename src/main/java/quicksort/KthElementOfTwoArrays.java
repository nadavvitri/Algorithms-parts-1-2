package quicksort;

public class KthElementOfTwoArrays {

    public long kthElement(int arr1[], int arr2[], int k) {
        int n = arr1.length;
        int m = arr2.length;
        if (arr1.length > arr2.length) {
            return kthElement(arr2, arr1, k);
        }
        int l = Math.max(0, k - m), r = Math.min(k, n - 1);
        while (true) {
            int mid1 = (l + r) >> 1;
            int mid2 = k - mid1 - 2;

            int aLeft = mid1 >= 0 ? arr1[mid1] : Integer.MIN_VALUE;
            int aRight = mid1 + 1 < n ? arr1[mid1 + 1] : Integer.MAX_VALUE;
            int bLeft = mid2 >= 0 ? arr2[mid2] : Integer.MIN_VALUE;
            int bRight = mid2 + 1 < m ? arr2[mid2 + 1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                return Math.max(aLeft, bLeft);
            }
            if (aLeft > bRight) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        KthElementOfTwoArrays kthElementOfTwoArrays = new KthElementOfTwoArrays();
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        System.out.println(kthElementOfTwoArrays.kthElement(arr1, arr2, 5));
    }
}
