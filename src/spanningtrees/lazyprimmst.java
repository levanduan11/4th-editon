package spanningtrees;

import java.util.*;

public class lazyprimmst {
    private boolean []marked;
   private Queue<edge>mst;
    private List<edge>pq;
    private double weight;

    public lazyprimmst(edgeweightedgraph  g) {
        pq=new ArrayList<edge>();
        marked=new boolean[g.v()];
        mst=new ArrayDeque<edge>();
visit(g,0);
while (!pq.isEmpty()){
    Collections.sort(pq);
    edge e= pq.get(0);
    int v=e.either(),w=e.other(v);
    if(marked[v]&&marked[w])continue;
    mst.add(e);
    if(!marked[v])visit(g,v);
    if(!marked[w])visit(g,w);
}
    }
    private void visit(edgeweightedgraph g,int v){
marked[v]=true;
        for (edge e:g.adj(v)
             ) {
            if(!marked[e.other(v)])pq.add(e);
        }
    }
    public Iterable<edge>edges(){
        return mst;
    }
    public double weight(){
        return weight;
    }


}
