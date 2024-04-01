package stacksandqueues;

public class FixedCapacityStackOfStrings implements Stack<String> {
    private String[] s;
    private int size = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        this.s = new String[capacity];
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
            return;
        }
        s[size] = value;
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

    public static void main(String[] args) {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(10);
        String tobe = "to be or not to - be - - that - - - is";
        for (String word : tobe.split(" ")) {
            if (word.equals("-")) {
                System.out.println(fixedCapacityStackOfStrings.pop());
            } else {
                fixedCapacityStackOfStrings.push(word);
            }
        }
    }
}
