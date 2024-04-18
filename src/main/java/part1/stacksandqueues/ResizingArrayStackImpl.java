package part1.stacksandqueues;

public class ResizingArrayStackImpl implements StackImpl<String> {
    private String[] s;
    private int size = 0;

    public ResizingArrayStackImpl() {
        this.s = new String[1];
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            return "Empty!";
        }
        return s[--size];
    }

    @Override
    public void push(String value) {
        if (size == s.length) {
            resize(size * 2);
        }
        s[size] = value;
        size++;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ResizingArrayStackImpl resizingArrayStack = new ResizingArrayStackImpl();
        String tobe = "to be or not to - be - - that - - - is";
        for (String word : tobe.split(" ")) {
            if (word.equals("-")) {
                System.out.println(resizingArrayStack.pop());
            } else {
                resizingArrayStack.push(word);
            }
        }
    }
}
