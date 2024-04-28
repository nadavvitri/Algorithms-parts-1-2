package part2.shortestpaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    double[] distTo;
    DirectedEdge[] edgeTo;
    PriorityQueue<Node> pq;

    public Dijkstra(List<DirectedEdge> directedEdges, int n, int source) {
        pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.w));
        distTo = new double[n];
        edgeTo = new DirectedEdge[n];
        for (int i = 0; i < n; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        Map<Integer, List<DirectedEdge>> nodeToNodes = getAsMap(directedEdges, n);
        distTo[source] = 0;
        pq.add(new Node(0, 0.0));
        while (!pq.isEmpty()) {
            int v = pq.poll().v;
            for (DirectedEdge edge : nodeToNodes.get(v)) {
                relax(edge);
            }
        }
    }

    private void relax(DirectedEdge edge) {
        int v = edge.from, w = edge.to;
        Node key = new Node(w, distTo[w]);
        if (distTo[w] > distTo[v] + edge.weight) {
            distTo[w] = distTo[v] + edge.weight;
            edgeTo[w] = edge;
            pq.remove(key);
            key.w = distTo[w];
            pq.add(key);
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public List<DirectedEdge> pathTo(int v) {
        ArrayList<DirectedEdge> path = new ArrayList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from]) {
            path.add(e);
        }
        Collections.reverse(path);
        return path;
    }

    private Map<Integer, List<DirectedEdge>> getAsMap(List<DirectedEdge> edges, int n) {
        Map<Integer, List<DirectedEdge>> nodeToNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeToNodes.put(i, new ArrayList<>());
        }

        for (DirectedEdge e : edges) {
            nodeToNodes.get(e.from).add(e);
        }
        return nodeToNodes;
    }

    public static class Node {
        public int v;
        public double w;

        public Node(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        List<DirectedEdge> directedEdges = Arrays.asList(new DirectedEdge(4, 5, 0.35),
                new DirectedEdge(5, 4, 0.35),
                new DirectedEdge(4, 7, 0.37),
                new DirectedEdge(5, 7, 0.28),
                new DirectedEdge(7, 5, 0.28),
                new DirectedEdge(5, 1, 0.32),
                new DirectedEdge(0, 4, 0.38),
                new DirectedEdge(0, 2, 0.26),
                new DirectedEdge(7, 3, 0.39),
                new DirectedEdge(1, 3, 0.29),
                new DirectedEdge(2, 7, 0.34),
                new DirectedEdge(6, 2, 0.40),
                new DirectedEdge(3, 6, 0.52),
                new DirectedEdge(6, 0, 0.58),
                new DirectedEdge(6, 4, 0.93));
        Dijkstra dijkstra = new Dijkstra(directedEdges, n, 0);
        System.out.println(dijkstra.pathTo(6));
    }
}
