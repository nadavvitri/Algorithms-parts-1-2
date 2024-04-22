package part2.undirectedgraphs;

import java.util.LinkedList;
import java.util.List;

public class Euler {

    public int isEulerCircuit(int V, List<Integer>[] adj) {
        if (!isConnected(V, adj)) {
            return 0;
        }

        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                odd++;
            }
        }
        if (odd > 2) {
            return 0;
        }
        return odd == 2 ? 1 : 2;
    }

    private boolean isConnected(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        int i = 0;
        for (i = 0; i < V; i++) {
            if (!adj[i].isEmpty()) {
                break;
            }
        }
        if (i == V) {
            return true;
        }
        dfs(i, adj, visited);
        for (i = 0; i < V; i++) {
            if (!visited[i] && !adj[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i, List<Integer>[] adj, boolean[] visited) {
        visited[i] = true;

        for (int j : adj[i]) {
            if (!visited[j]) {
                dfs(j, adj, visited);
            }
        }
    }

    private boolean isConnected(Graph g) {
        LinkedList<Integer>[] adj = g.getAdj();
        int i;
        for (i = 0; i < g.getV(); i++) {
            if (!adj[i].isEmpty()) {
                break;
            }
        }
        if (i == g.getV()) {
            return true;
        }
        boolean[] visited = new boolean[g.getV()];
        g.dfs(i, g, visited);
        for (i = 0; i < g.getV(); i++) {
            if (!visited[i] && !adj[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);

        Euler eulerCycle = new Euler();
        System.out.println(eulerCycle.isEulerCircuit(graph.getV(), graph.getAdj()));
    }
}
