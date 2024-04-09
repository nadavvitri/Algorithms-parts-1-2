package priorityqueues;

import java.util.Arrays;

public class HeapSort {

    public void sort(Comparable[] a) {
        int n = a.length;

        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        while (n > 1) {
            swap(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private void sink(Comparable[] a, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (less(a, j, k)) {
                break;
            }
            swap(a, k, j);
            k = k * 2;
        }
    }

    private boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Character[] chars = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        heapSort.sort(chars);
        System.out.println(Arrays.toString(chars));
    }
}
