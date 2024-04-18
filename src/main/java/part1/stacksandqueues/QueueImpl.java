package part1.stacksandqueues;

public interface QueueImpl<K> {

    K dequeue();

    void enqueue(K value);

    int size();

    boolean isEmpty();
}
