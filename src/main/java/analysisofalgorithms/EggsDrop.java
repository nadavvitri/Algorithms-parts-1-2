package analysisofalgorithms;

public class EggsDrop {

    public int twoEggDrop(int n) {
        if (n <= 2) {
            return n;
        }
        int eggs = 2;
        return helper(n, eggs, new int[n + 1][eggs + 1]);
    }

    private int helper(int floors, int eggs, int[][] memo) {
        if (eggs == 1 || floors <= 1) {
            return floors;
        }
        if (memo[floors][eggs] > 0) {
            return memo[floors][eggs];
        }
        int min = Integer.MAX_VALUE;
        for (int f = 1; f <= floors; f++) {
            min = Math.min(min,
                    1 + Math.max(helper(floors - f, eggs, memo), helper(f - 1, eggs - 1, memo)));
        }
        memo[floors][eggs] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new EggsDrop().twoEggDrop(100));
    }
}
