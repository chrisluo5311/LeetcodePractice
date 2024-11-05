package unionfind;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0,1},{1,2},{3,4}};

        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            unionFind.union(edge[0], edge[1]);
        }
        System.out.println(unionFind.count());
    }
}
