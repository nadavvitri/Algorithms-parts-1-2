package hashtables;

public class SequentialSearchST<K, V> {
    Node first;
    int size;

    public SequentialSearchST() {

    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }
        Node cur = first;
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        first = new Node(key, value, first);
        size++;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        Node cur = first;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public void delete(K key) {
        if (key == null) {
            return;
        }
        first = delete(key, first);
    }

    private Node delete(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            size--;
            return node.next;
        }
        node.next = delete(key, node.next);
        return node;
    }

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
