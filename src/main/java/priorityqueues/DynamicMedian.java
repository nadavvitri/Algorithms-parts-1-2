package priorityqueues;

import java.util.PriorityQueue;

public class DynamicMedian {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public DynamicMedian() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        small.add(num);
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }
        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        if (large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() + small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        DynamicMedian dynamicMedian = new DynamicMedian();
        dynamicMedian.addNum(1);    // arr = [1]
        dynamicMedian.addNum(2);    // arr = [1, 2]
        System.out.println(dynamicMedian.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        dynamicMedian.addNum(3);    // arr[1, 2, 3]
        System.out.println(dynamicMedian.findMedian()); // return 2.0
    }
}
