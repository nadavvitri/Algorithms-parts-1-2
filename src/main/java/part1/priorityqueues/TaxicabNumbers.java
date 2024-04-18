package part1.priorityqueues;

import java.util.HashSet;
import java.util.Set;

public class TaxicabNumbers {

    public void taxicab3(int n) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int sum = i * i * i + j * j * j;
                if (set.contains(sum)) {
                    System.out.println(sum);
                    count++;
                } else {
                    set.add(sum);
                }
                if (count == n) {
                    return;
                }
            }
        }
    }


    public static void main(String[] args) {
        TaxicabNumbers taxicabNumbers = new TaxicabNumbers();
        taxicabNumbers.taxicab3(2);
    }
}
