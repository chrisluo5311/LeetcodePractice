package unionfind;

public class UnionFind {
    private int[] root;
    private int count;

    public UnionFind(int size) {
        root = new int[size];
        this.count = size;
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        root[rootY] = rootX;
        count--;
    }

    public boolean connected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public int count() {
        return count;
    }

}
