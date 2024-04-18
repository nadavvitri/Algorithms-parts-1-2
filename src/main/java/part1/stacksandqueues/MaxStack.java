package part1.stacksandqueues;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> main;
    Stack<Integer> max;

    public MaxStack() {
        main = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        main.push(x);
        if (max.isEmpty()) {
            max.push(x);
            return;
        }
        int currentMax = max.peek();
        max.push(Math.max(currentMax, x));
    }

    public int pop() {
        max.pop();
        return main.pop();
    }

    public int top() {
        return main.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int value = max.pop();
        Stack<Integer> aux = new Stack<>();
        while (main.peek() != value) {
            aux.push(main.pop());
            max.pop();
        }
        pop();
        while (!aux.isEmpty()) {
            push(aux.pop());
        }
        return value;
    }

    public static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        System.out.println(stk.top());     // return 5, [5, 1, 5] the stack did not change.
        System.out.println(stk.popMax());  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        System.out.println(stk.top());     // return 1, [5, 1] the stack did not change.
        System.out.println(stk.peekMax()); // return 5, [5, 1] the stack did not change.
        System.out.println(stk.pop());     // return 1, [5] the top of the stack and the max element is now 5.
        System.out.println(stk.top());     // return 5, [5] the stack did not change.
    }
}
