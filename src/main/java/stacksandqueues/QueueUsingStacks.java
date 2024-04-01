package stacksandqueues;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> main;
    Stack<Integer> second;

    public QueueUsingStacks() {
        main = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        main.push(x);
    }

    public int pop() {
        if (second.isEmpty()) {
            while (!main.isEmpty()) {
                second.push(main.pop());
            }
        }
        return second.pop();
    }

    public int peek() {
        if (second.isEmpty()) {
            while (!main.isEmpty()) {
                second.push(main.pop());
            }
        }
        return second.peek();
    }

    public boolean empty() {
        return main.isEmpty() && second.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.push(1); // queue is: [1]
        queueUsingStacks.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(queueUsingStacks.peek()); // return 1
        System.out.println(queueUsingStacks.pop()); // return 1, queue is [2]
        System.out.println(queueUsingStacks.empty()); // return false
    }
}
