package part1.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(0, a.length - 1, a, aux);
    }

    private static void sort(int l, int r, Comparable[] a, Comparable[] aux) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(l, mid, a, aux);
        sort(mid + 1, r, a, aux);
        merge(l, mid, r, a, aux);
    }

    private static void merge(int l, int mid, int r, Comparable[] a, Comparable[] aux) {
        for (int k = l; k <= r; k++) {
            aux[k] = a[k];
        }
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (l > mid) {
                a[k] = aux[j++];
            } else if (j > r) {
                a[k] = aux[l++];
            } else if (aux[j].compareTo(aux[l]) < 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[l++];
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(strings);
        System.out.println(Arrays.toString(strings));

        Integer[] ints = {1, -1, 1, 9, 8, -4, 7};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
