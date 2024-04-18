package part1.mergesort;

import java.util.Random;

public class ShuffleLinkedList {

    private static Node shuffle(Node head, int n) {
        if (n == 1) {
            return head;
        }
        int m = n / 2;
        Node mid = getNth(head, m - 1);
        Node secondHead = mid.next;
        mid.next = null;
        head = shuffle(head, m);
        secondHead = shuffle(secondHead, n - m);
        return merge(head, secondHead);
    }

    private static Node getNth(Node head, int m) {
        Node cur = head;
        for (int i = 0; i < m; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private static Node merge(Node first, Node second) {
        Node dummyHead = new Node(-1, null);
        Node cur = dummyHead;
        Node cur1 = first, cur2 = second;
        Random random = new Random();
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else if (cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                int rand = random.nextInt(2);
                if (rand == 0) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    private static class Node {
        Object item;
        Node next;

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node shuffle = shuffle(head, 5);
        while (shuffle != null) {
            System.out.println(shuffle.item);
            shuffle = shuffle.next;
        }
    }
}
