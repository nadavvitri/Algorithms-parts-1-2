package part1.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            int occ = numToCount.getOrDefault(num, 0);
            numToCount.put(num, occ + 1);
        }
        List<List<Integer>> occ = new ArrayList<>();
        init(occ, nums.length);
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            occ.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int w = 0;
        for (int i = occ.size() - 1; i >= 0; i--) {
            if (occ.get(i).isEmpty()) {
                continue;
            }
            if (w >= res.length) {
                break;
            }
            for (Integer value : occ.get(i)) {
                if (w >= res.length) {
                    break;
                }
                res[w] = value;
                w++;
            }
        }
        return res;
    }

    private void init(List<List<Integer>> occ, int n) {
        for (int i = 0; i <= n; i++) {
            occ.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
