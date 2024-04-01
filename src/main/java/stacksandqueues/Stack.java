package stacksandqueues;

public interface Stack<K> {

    K pop();

    void push(K value);

    int size();

    boolean isEmpty();
}
