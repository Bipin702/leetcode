class Disjoint{
    List<Integer> parent;
    List<Integer> size;

    Disjoint(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)) return node;

        int ulp = findParent(parent.get(node));

        parent.set(node,ulp);
        return ulp;
    }

    public void UnionBySize(int u, int v){
        int ulpU = findParent(u);
        int ulpV = findParent(v);

        if(ulpU == ulpV) return;

        if(size.get(ulpU) < size.get(ulpV)){
            parent.set(ulpU,ulpV);
            size.set(ulpV,size.get(ulpU) + size.get(ulpV));
        }else{
            parent.set(ulpV,ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);

        int countExtra = 0;

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                countExtra++;
            }else{
                ds.UnionBySize(u,v);
            }
        }

        int countC = 0;

        for(int i = 0; i < n; i++){
            if(ds.findParent(i) == i) countC++;
        }

        int ans = countC-1;

        if(countExtra >= ans) return ans;
        return -1;
    }
}