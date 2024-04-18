package part1.quicksort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(0, a.length - 1, a);
    }

    private static void sort(int l, int r, Comparable[] a) {
        if (l >= r) {
            return;
        }
        int p = partition(l, r, a);
        sort(l, p - 1, a);
        sort(p + 1, r, a);
    }

    private static int partition(int lo, int hi, Comparable[] a) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo])) ;
            while (j > lo && less(a[lo], a[--j])) ;
            if (i >= j) {
                break;
            }
            swap(i, j, a);
        }
        swap(lo, j, a);
        return j;
    }

    private static void swap(int i, int j, Comparable[] a) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void shuffle(Comparable[] a) {
        Random random = new Random();
        for (int i = 1; i < a.length; i++) {
            int j = random.nextInt(i + 1);
            swap(i, j, a);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {3, 2, 1, 1, 6, 0, 1, 7};
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
