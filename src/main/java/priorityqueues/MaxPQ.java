package priorityqueues;

public class MaxPQ<K> {

    private K[] pq;
    private int n = 0;
    private int capacity;

    public MaxPQ(int n) {
        this.pq = (K[]) new Object[n + 1];
        this.capacity = n;
    }

    public MaxPQ(K[] keys) {
        this(keys.length);
        for (K k : keys) {
            insert(k);
        }
    }

    public K delMax() {
        if (isEmpty()) {
            return null;
        }
        K max = pq[1];
        swap(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    public K max() {
        if (isEmpty()) {
            return null;
        }
        return pq[1];
    }

    public void insert(K key) {
        if (getSize() >= capacity) {
            return;
        }
        pq[++n] = key;
        swim(n);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    private void swim(int k) {
        while (k > 1 && !less(pq[k], pq[k / 2])) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = 2 * k;
            if (j < n && less(pq[j], pq[j + 1])) {
                j++;
            }
            if (less(pq[j], pq[k])) {
                break;
            }
            swap(k, j);
            k = k * 2;
        }
    }

    private boolean less(K a, K b) {
        return ((Comparable<K>) a).compareTo(b) < 0;
    }

    private void swap(int i, int j) {
        K tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(new Integer[]{1, 9, 7, 10, 4});
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
        }
    }
}
