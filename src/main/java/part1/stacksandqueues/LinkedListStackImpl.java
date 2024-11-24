package part1.stacksandqueues;

public class LinkedListStackImpl implements StackImpl<String> {
    private Node<String> first;
    private int size = 0;

    @Override
    public String pop() {
        if (isEmpty()) {
            return "Empty!";
        }
        String value = first.value;
        first = first.next;
        return value;
    }

    @Override
    public void push(String value) {
        Node<String> oldFirst = first;
        first = new Node<>(value);
        first.next = oldFirst;
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
        Node<K> next;
        K value;

        public Node(K value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedListStackImpl linkedListStack = new LinkedListStackImpl();
        String tobe = "to be or not to - be - - that - - - is";
        for (String word : tobe.split(" ")) {
            if (word.equals("-")) {
                System.out.println(linkedListStack.pop());
            } else {
                linkedListStack.push(word);
            }
        }
    }
}
