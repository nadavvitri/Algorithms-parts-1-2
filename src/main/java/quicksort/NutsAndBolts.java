package quicksort;

public class NutsAndBolts {
    void matchPairs(char nuts[], char bolts[], int n) {
        matchPairs(nuts, bolts, 0, n - 1);
    }

    private void matchPairs(char[] nuts, char[] bolts, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nuts, lo, hi, bolts[hi]);
        partition(bolts, lo, hi, nuts[p]);
        matchPairs(nuts, bolts, lo, p - 1);
        matchPairs(nuts, bolts, p + 1, hi);
    }

    private int partition(char[] a, int lo, int hi, char pValue) {
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] < pValue) {
                swap(a, j, i);
                i++;
            } else if (a[j] == pValue) {
                swap(a, j, hi);
                j--;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 5;
        char[] nuts = new char[]{'@', '%', '$', '#', '^'};
        char[] bolts = new char[]{'%', '@', '#', '$', '^'};
        NutsAndBolts nutsAndBolts = new NutsAndBolts();
        nutsAndBolts.matchPairs(nuts, bolts, n);

        System.out.println(nuts);
        System.out.println(bolts);
    }
}
