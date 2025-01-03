public class DisjointSet {
    int[] parent;//Array to store the parent of each node
    int[] rank;//Array to store the rank of each node

    public DisjointSet(int n) {
        //Initialize the parent and rank arrays
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int x) {
        if(parent[x] == x) {
            return x;
        }
        //Path compression
        return parent[x] = findParent(parent[x]);
    }

    public void unionByRank(int x, int y) {
        //Union by rank
        int xParent = findParent(x);
        int yParent = findParent(y);

        if(rank[xParent] < rank[yParent]){
            parent[xParent] = yParent;
        }
        else if (rank[yParent] < rank[xParent]){
            parent[yParent] = xParent;
        }
        else{
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.unionByRank(0, 1);
        ds.unionByRank(1, 2);
        ds.unionByRank(3, 4);
        System.out.println(ds.findParent(2)); // Output: 0 or 1
        System.out.println(ds.findParent(4)); // Output: 3

    }
}
