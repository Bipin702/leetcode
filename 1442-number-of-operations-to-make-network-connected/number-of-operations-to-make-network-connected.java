class DisjointSet{
    ArrayList<Integer> parent;
    ArrayList<Integer> size;

    DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int u){
        if(u == parent.get(u)) return u;

        int ulp = findParent(parent.get(u));

        parent.set(u,ulp);
        return ulp;
    }

    public void UnionBySize(int u, int v){
        int ulpU = findParent(u);
        int ulpV = findParent(v);

        if(ulpU == ulpV) return;

        if(size.get(ulpU) < size.get(ulpV)){
            parent.set(ulpU,ulpV);
            size.set(ulpU,size.get(ulpU) + size.get(ulpV));
        }else{
            parent.set(ulpV , ulpU);
            size.set(ulpV, size.get(ulpV) + size.get(ulpU));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet dsu = new DisjointSet(n);

        int countExtra = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(dsu.findParent(u) == dsu.findParent(v)){
                countExtra++;
            }else{
                dsu.UnionBySize(u,v);
            }
        }

        int countC = 0;

        for(int i = 0; i < n; i++){
            if(dsu.findParent(i) == i) countC++;
        }

        int ans = countC-1;

        if(countExtra >= ans) return ans;

        return -1;
    }
}