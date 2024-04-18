package part1.stacksandqueues;

public interface StackImpl<K> {

    K pop();

    void push(K value);

    int size();

    boolean isEmpty();
}
