package part2.shortestpaths;

public class DirectedEdge {
    public int from;
    public int to;
    public double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " , " + weight;
    }
}
