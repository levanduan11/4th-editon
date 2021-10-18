package spanningtrees;

import java.util.ArrayList;
import java.util.List;

public class edgeweightedgraph {
    private int v;
    private int E;
private List<edge>[]adj;

    public edgeweightedgraph(int v) {
        this.v = v;
        this.E=0;
        adj=(List<edge>[])new ArrayList[v];
        for (int i = 0; i <v ; i++) {
            adj[i]=new ArrayList<>();
        }
    }
    public int v(){
        return v;
    }
    public int e(){
        return E;
    }
    public void add(edge e){
        int v=e.either(),w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
       this.E++;
    }
    public Iterable<edge>adj(int v){
        return adj[v];
    }
    public Iterable<edge>edges(){
        List<edge>list=new ArrayList<edge>();
        for (int i = 0; i < v; i++) {
            for (edge e:adj[i]
                 ) {
                if(e.other(i)>i)list.add(e);
            }
        }
        return list;
    }
}

