class Solution {
    public int makeConnected(int n, int[][] connections) {
        dis d = new dis(n);
        int cntextra=0;
        for(int[] e: connections){
            int u = e[0];
            int v= e[1];
            if(d.find(u) == d.find(v)){
                cntextra++;
            }else{
                d.union(u,v);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(d.parent.get(i) == i) cnt++;
        }
        if(cntextra>=cnt-1) return cnt-1;
        else return -1;
        
    }
}
class dis{
    int n;
    List<Integer> parent;
    List<Integer> size;
    public dis(int n){
        this.n=n;
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int find(int node){
        if(node == parent.get(node)) return node;
        int p = find(parent.get(node));
        parent.set(node,p);
        return parent.get(node);
    }
    public void union(int u,int v){
        int up = find(u);
        int vp = find(v);
        if(up == vp) return;
        if(size.get(up)>size.get(vp)){
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }else{
            parent.set(up,vp);
            size.set(vp,size.get(vp)+size.get(up));
        }
    }
}