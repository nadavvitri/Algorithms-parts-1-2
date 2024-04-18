package part1.unionfind;

public class SuccessorWithDelete {
    private final UnionFindMax unionFindMax;

    public SuccessorWithDelete(int n) {
        unionFindMax = new UnionFindMax(n);
    }

    public void remove(int p) {
        unionFindMax.union(p, p + 1);
    }

    public int successor(int p) {
        return unionFindMax.getMax(p);
    }

    public static void main(String[] args) {
        SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(5);
        successorWithDelete.remove(2);
        System.out.println(successorWithDelete.successor(2));
        successorWithDelete.remove(3);
        System.out.println(successorWithDelete.successor(2));
        System.out.println(successorWithDelete.successor(4));
        successorWithDelete.remove(1);
        System.out.println(successorWithDelete.successor(1));
    }
}
