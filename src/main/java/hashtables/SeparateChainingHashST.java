package hashtables;

public class SeparateChainingHashST<K, V> {
    private final int m;
    private int size;
    SequentialSearchST<K, V>[] sq;

    public SeparateChainingHashST(int m) {
        this.m = m;
        sq = new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            sq[i] = new SequentialSearchST<K, V>();
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int i = hash(key);
        if (value == null) {
            delete(key);
            return;
        }
        if (!sq[i].contains(key)) {
            size++;
        }
        sq[i].put(key, value);
    }

    public void delete(K key) {
        if (key == null) {
            return;
        }
        int i = hash(key);
        if (sq[i].contains(key)) {
            size--;
        }
        sq[i].delete(key);
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int i = hash(key);
        return sq[i].get(key);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
