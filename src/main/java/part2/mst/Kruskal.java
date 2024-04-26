package part2.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import part1.unionfind.WeightedQuickUnionUF;

public class Kruskal {

    private final PriorityQueue<Edge> pq;
    private final WeightedQuickUnionUF uf;

    private final List<Edge> mst;
    private double total = 0;
    private final int n;

    public Kruskal(int n, List<Edge> edges) {
        pq = new PriorityQueue<>(Comparator.comparing(e -> e.w));
        pq.addAll(edges);
        uf = new WeightedQuickUnionUF(n);
        mst = new ArrayList<>();
        this.n = n;
    }

    private void mst() {
        while (!pq.isEmpty() && mst.size() < n - 1) {
            Edge cur = pq.poll();
            if (uf.find(cur.u) == uf.find(cur.v)) {
                continue;
            }
            uf.union(cur.u, cur.v);
            mst.add(cur);
            total += cur.w;
        }
    }

    public List<Edge> getMst() {
        return mst;
    }

    public double getTotal() {
        return total;
    }

    public static void main(String[] args) {
        int n = 8;
        List<Edge> edges = Arrays.asList(
                new Edge(4, 5, 0.35),
                new Edge(4, 7, 0.37),
                new Edge(5, 7, 0.28),
                new Edge(0, 7, 0.16),
                new Edge(1, 5, 0.32),
                new Edge(0, 4, 0.38),
                new Edge(2, 3, 0.17),
                new Edge(1, 7, 0.19),
                new Edge(0, 2, 0.26),
                new Edge(1, 2, 0.36),
                new Edge(1, 3, 0.29),
                new Edge(2, 7, 0.34),
                new Edge(6, 2, 0.40),
                new Edge(3, 6, 0.52),
                new Edge(6, 0, 0.58),
                new Edge(6, 4, 0.93));
        Kruskal kruskal = new Kruskal(n, edges);
        kruskal.mst();
        System.out.println(kruskal.getMst());
        System.out.println(kruskal.getTotal());
    }

}
