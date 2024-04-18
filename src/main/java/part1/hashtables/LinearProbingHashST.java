package part1.hashtables;

public class LinearProbingHashST<K, V> {

    private final int m;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public LinearProbingHashST(int m) {
        this.m = m;
        keys = (K[]) new Object[m];
        values = (V[]) new Object[m];
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        if (value == null) {
            delete(key);
            return;
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    private void delete(K key) {
        if (key == null) {
            return;
        }
        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            K k = keys[i];
            V v = values[i];
            keys[i] = null;
            values[i] = null;
            size--;
            put(k, v);
            i = (i + 1) % m;
        }
        size--;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
}
