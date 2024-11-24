package part1.stacksandqueues;

public class LinkedListQueueImpl implements QueueImpl<String> {

    Node<String> first, last;
    int size = 0;

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return "Empty!";
        }
        String value = first.value;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = first;
        }
        return value;
    }

    @Override
    public void enqueue(String value) {
        Node<String> oldLast = last;
        last = new Node<>(value);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<K> {
        K value;
        Node<K> next;

        public Node(K value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedListQueueImpl linkedListQueue = new LinkedListQueueImpl();
        String tobe = "to be or not to - be - - that - - - is";
        for (String word : tobe.split(" ")) {
            if (word.equals("-")) {
                System.out.println(linkedListQueue.dequeue());
            } else {
                linkedListQueue.enqueue(word);
            }
        }
    }
}
