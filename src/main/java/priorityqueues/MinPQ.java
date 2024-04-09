package priorityqueues;

public class MinPQ<K> {
    private int n = 0;
    private K[] pq;
    private int capacity;

    public MinPQ(int capacity) {
        this.pq = (K[]) new Object[capacity + 1];
        this.capacity = capacity;
    }

    public MinPQ(K[] keys) {
        this(keys.length);
        for (K k : keys) {
            insert(k);
        }
    }

    public K delMin() {
        if (isEmpty()) {
            return null;
        }
        K min = pq[1];
        swap(1, n--);
        sink(1);
        pq[n + 1] = null;
        return min;
    }

    public K min() {
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

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(pq[j + 1], pq[j])) {
                j++;
            }
            if (less(pq[k], pq[j])) {
                break;
            }
            swap(k, j);
            k = k * 2;
        }
    }

    private void swim(int k) {
        while (k > 1 && !less(pq[k / 2], pq[k])) {
            swap(k, k / 2);
            k = k / 2;
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

    public boolean isEmpty() {
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    public static void main(String[] args) {
        MinPQ<Integer> minPQ = new MinPQ<>(new Integer[]{1, 9, 7, 10, 4});
        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.delMin());
        }
    }
}
