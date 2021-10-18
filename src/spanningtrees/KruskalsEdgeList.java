package spanningtrees;

public class KruskalsEdgeList {

    static class unionfind{
        private int [] id,sz;
        public unionfind(int n){
            id=new int[n];
            sz=new int[n];
            for (int i = 0; i < n; i++) {
                id[i]=i;
                sz[i]=1;
            }
        }

        public int find(int p){
            int root=p;
            while (root!=id[root])root=id[root];
            while (p!=root){
                int next=id[p];
                id[p]=root;
                p=next;
            }
            return root;
        }

        public  boolean connected(int p,int q){
            return find(p)==find(q);
        }
        public int size(int p){
            return sz[find(p)];
        }

        public void union(int p,int q){
            int roo1=find(p);
            int roo2=find(q);
            if(roo1==roo2)return;

            if(sz[roo1]<sz[roo2]){
                sz[roo2]+=sz[roo1];
                id[roo1]=roo2;
            }else {
                sz[roo1]+=sz[roo2];
                id[roo2]=roo1;
            }
        }
    }
static class edge implements Comparable<edge>{
        int from,to,cost;

    public edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(edge o) {
        return this.cost-o.cost;
    }

}
static Long kruskals(edge[]edges,int n){
        if(edges==null) return null;

        long sum=0L;
        java.util.Arrays.sort(edges);
        unionfind uf=new unionfind(n);

    for (edge e:edges
         ) {
        if(uf.connected(e.from,e.to))continue;

        //include this edge;
        uf.union(e.from,e.to);
        sum+=e.cost;

        if(uf.size(0)==n)break;

    }
    if(uf.size(0)!=n)return null;
    return sum;
}


}
