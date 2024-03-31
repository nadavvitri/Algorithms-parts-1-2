package unionfind;

public class UnionFindMax {
    private int[] parent;
    private int[] rank;
    private int[] max;

    public UnionFindMax(int n) {
        parent = new int[n];
        rank = new int[n];
        max = new int[n];
        initArrays();
    }

    private void initArrays() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            max[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);

        if (parentP == parentQ) {
            return;
        }
        int maxParent = Math.max(max[parentP], max[parentQ]);
        if (rank[parentP] > rank[parentQ]) {
            max[parentP] = maxParent;
            parent[parentQ] = parentP;
            rank[parentP] += rank[parentQ];
        } else {
            max[parentQ] = maxParent;
            parent[parentP] = parentQ;
            rank[parentQ] += rank[parentP];
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int getMax(int p) {
        return max[find(p)];
    }

    public static void main(String[] args) {
        UnionFindMax unionFindMax = new UnionFindMax(5);
        unionFindMax.union(0, 1);
        unionFindMax.union(0, 2);
        System.out.println(unionFindMax.getMax(1));
        unionFindMax.union(3, 4);
        System.out.println(unionFindMax.getMax(4));
        unionFindMax.union(3, 2);
        System.out.println(unionFindMax.getMax(1));
    }
}
