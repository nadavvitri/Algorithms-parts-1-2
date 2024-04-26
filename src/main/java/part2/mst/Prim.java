package part2.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prim {
    private final int n;
    boolean[] visited;
    private final PriorityQueue<Edge> pq;
    private final List<Edge> mst;
    private double total = 0;
    Map<Integer, List<Edge>> nodeToNodes = new HashMap<>();

    public Prim(int n, List<Edge> edges) {
        visited = new boolean[n];
        pq = new PriorityQueue<>(Comparator.comparing(e -> e.w));
        mst = new ArrayList<>();
        this.n = n;
        initMap(edges);
    }

    private void initMap(List<Edge> edges) {
        for (int i = 0; i < n; i++) {
            nodeToNodes.put(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            nodeToNodes.get(e.u).add(e);
            nodeToNodes.get(e.v).add(e);
        }
    }


    private void mst() {
        visit(0);
        while (mst.size() < n - 1) {
            Edge cur = pq.poll();
            if (visited[cur.v] && visited[cur.u]) {
                continue;
            }
            mst.add(cur);
            total += cur.w;
            if (!visited[cur.u]) {
                visit(cur.u);
            }
            if (!visited[cur.v]) {
                visit(cur.v);
            }
        }
    }

    private void visit(int i) {
        visited[i] = true;
        pq.addAll(nodeToNodes.get(i));
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
        Prim prim = new Prim(n, edges);
        prim.mst();
        System.out.println(prim.getMst());
        System.out.println(prim.getTotal());
    }
}
