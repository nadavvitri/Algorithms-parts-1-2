package part2.undirectedgraphs;

import java.util.LinkedList;

public class Graph {

    private int V;

    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public int getV() {
        return V;
    }

    public void dfs(int i, Graph g, boolean[] visited) {
        visited[i] = true;
        LinkedList<Integer>[] adj = g.getAdj();
        for (int j = 0; j < adj[j].size(); j++) {
            if (!visited[j]) {
                dfs(j, g, visited);
            }
        }
    }
}
