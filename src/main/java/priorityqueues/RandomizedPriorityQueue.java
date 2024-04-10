package priorityqueues;

import java.util.Random;

public class RandomizedPriorityQueue<K> {

    private final int capacity;
    private int n = 0;
    private final K[] pq;
    private final Random random = new Random();

    public RandomizedPriorityQueue(int capacity) {
        this.capacity = capacity;
        pq = (K[]) new Object[capacity + 1];
    }

    public RandomizedPriorityQueue(K[] keys) {
        this(keys.length);
        for (K key : keys) {
            add(key);
        }
    }

    public void add(K key) {
        if (n > capacity) {
            return;
        }
        pq[++n] = key;
        swim(n);
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

    public K sample() {
        if (isEmpty()) {
            return null;
        }
        return pq[getRandom(n, 1)];
    }

    public void delRandom() {
        if (isEmpty()) {
            return;
        }
        int i = getRandom(n, 1);
        System.out.println("removing " + pq[i]);
        swap(i, n--);
        pq[n + 1] = null;
        sink(i);
    }

    private int getRandom(int max, int min) {
        return random.nextInt((max - min + 1)) + min;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq[j + 1], pq[j])) {
                j++;
            }
            if (less(pq[j], pq[k])) {
                swap(j, k);
            }
            k = k * 2;
        }
    }

    private void swim(int k) {
        while (k > 1 && !less(pq[k / 2], pq[k])) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void swap(int i, int j) {
        K tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private boolean less(K a, K b) {
        return ((Comparable<K>) a).compareTo(b) < 0;
    }

    public static void main(String[] args) {
        RandomizedPriorityQueue<Integer> randomizedPriorityQueue = new RandomizedPriorityQueue<>(new Integer[]{1, 9, 7, 10, 4});
        while (!randomizedPriorityQueue.isEmpty()) {
            System.out.println("min " + randomizedPriorityQueue.min());
            System.out.println("random " + randomizedPriorityQueue.sample());
            randomizedPriorityQueue.delRandom();
        }
    }

}
