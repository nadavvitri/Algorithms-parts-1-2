package part1.mergesort;

public class CountInversions {

    public static int countInversion(int[] arr) {
        return sortAndCount(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private static int sortAndCount(int[] arr, int l, int r, int[] aux) {
        if (l >= r) {
            return 0;
        }
        int count = 0;
        int m = (l + r) / 2;
        count += sortAndCount(arr, l, m, aux);
        count += sortAndCount(arr, m + 1, r, aux);
        count += mergeAndCount(arr, l, m, r, aux);
        return count;
    }

    private static int mergeAndCount(int[] arr, int l, int m, int r, int[] aux) {
        for (int k = l; k <= r; k++) {
            aux[k] = arr[k];
        }
        int count = 0;

        int j = m + 1, i = l;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                arr[k] = aux[j++];
            } else if (j > r) {
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                count += (m - i + 1);
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countInversion(new int[]{2, 4, 1, 3, 5}));
        System.out.println(countInversion(new int[]{8, 4, 2, 1}));
        System.out.println(countInversion(new int[]{1, 20, 6, 4, 5}));
    }

}
