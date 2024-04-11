package priorityqueues;

import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {

    Node root;

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node root, K key, V value) {
        if (root == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K other) {
        if (root == null) {
            return null;
        }
        int cmp = other.compareTo(root.key);
        if (cmp < 0) {
            return get(root.left, other);
        } else if (cmp > 0) {
            return get(root.right, other);
        } else {
            return root.value;
        }
    }

    public V max() {
        return max(root).value;
    }

    private Node max(Node root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }

    public void deleteMax() {
        if (size() == 0) {
            return;
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        root.size = 1 + size(root.right) + size(root.left);
        return root;
    }

    public V min() {
        return min(root).value;
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public void deleteMin() {
        if (size() == 0) {
            return;
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        root.size = size(root.right) + size(root.left) + 1;
        return root;
    }

    public void delete(K key) {
        if (size() == 0) {
            return;
        }
        root = delete(root, key);
    }

    private Node delete(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node min = min(root.right);
            min.right = deleteMin(root.right);
            min.left = root.left;
            root = min;
        }
        root.size = size(root.right) + size(root.left) + 1;
        return root;
    }

    public List<V> inOrder() {
        List<V> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(Node root, List<V> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.value);
        inOrder(root.right, arr);

    }

    private class Node {
        K key;
        V value;
        int size;
        Node left, right;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {5, 3, 6, 2, 4, 7};
        BST<Integer, Integer> bst = new BST<>();
        for (Integer i : ints) {
            bst.put(i, i);
        }
        System.out.println(bst.inOrder());
        System.out.println(bst.max());
        System.out.println(bst.min());
        bst.deleteMax();
        System.out.println(bst.max());
        System.out.println(bst.get(1));
        System.out.println(bst.get(3));
        bst.delete(3);
        System.out.println(bst.get(3));
        System.out.println(bst.size());
        System.out.println(bst.inOrder());
    }
}
