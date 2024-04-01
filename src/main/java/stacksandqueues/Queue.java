package stacksandqueues;

public interface Queue<K> {

    K dequeue();

    void enqueue(K value);

    int size();

    boolean isEmpty();
}
