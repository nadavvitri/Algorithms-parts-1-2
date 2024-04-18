package part1.unionfind;

import java.util.Arrays;

public class WeightedQuickUnionUF {
    private int components;
    private int[] parent;
    private int[] rank;

    public WeightedQuickUnionUF(int n) {
        this.components = n;
        this.parent = new int[n];
        this.rank = new int[n];
        initArrays();
    }

    private void initArrays() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int p, int q) {
        if (p >= parent.length || q >= parent.length) {
            return;
        }
        int parentP = find(p);
        int parentQ = find(q);

        if (parentP == parentQ) {
            return;
        }
        if (rank[parentP] > rank[parentQ]) {
            parent[parentQ] = parentP;
            rank[parentP] += rank[parentQ];
        } else {
            parent[parentP] = parentQ;
            rank[parentQ] += rank[parentP];
        }
        components--;
    }

    public int find(int p) {
        if (p >= parent.length) {
            return -1;
        }
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int getComponents() {
        return components;
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(5);
        weightedQuickUnionUF.union(1, 2);
        weightedQuickUnionUF.union(3, 4);
        System.out.println(weightedQuickUnionUF.components);
        System.out.println(Arrays.toString(weightedQuickUnionUF.parent));
        System.out.println(Arrays.toString(weightedQuickUnionUF.rank));
        weightedQuickUnionUF.union(0, 1);
        System.out.println(weightedQuickUnionUF.components);
        System.out.println(Arrays.toString(weightedQuickUnionUF.parent));
        System.out.println(Arrays.toString(weightedQuickUnionUF.rank));
    }
}
