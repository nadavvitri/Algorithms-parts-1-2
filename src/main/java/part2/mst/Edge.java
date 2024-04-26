package part2.mst;

public class Edge {
    public int u;
    public int v;
    public double w;

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}
