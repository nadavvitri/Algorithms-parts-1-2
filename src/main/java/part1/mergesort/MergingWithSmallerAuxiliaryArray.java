package part1.mergesort;

import java.util.Arrays;

public class MergingWithSmallerAuxiliaryArray {

    public static void sort(Comparable[] ar, int m) {
        Comparable[] aux = new Comparable[m + 1];
        for (int k = 0; k <= m; k++) {
            aux[k] = ar[k];
        }

        int i = 0;
        int j = m + 1;
        for (int k = 0; k < ar.length; k++) {
            if (i > m) {
                ar[k] = ar[j++];
            } else if (j >= ar.length) {
                ar[k] = aux[i++];
            } else if (ar[j].compareTo(aux[i]) < 0) {
                ar[k] = ar[j++];
            } else {
                ar[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ar = new Integer[]{1, 5, 9, 2, 3, 8};
        sort(ar, 2);
        System.out.println(Arrays.toString(ar));
    }
}
