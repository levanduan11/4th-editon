package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int v;
    public int e;
    public List<Integer>adj[];

    public Graph(int v) {
        this.v = v;
        this.e=0;
        adj=(List<Integer>[])new ArrayList[v];
        for (int i = 0; i <v ; i++) {
            adj[i]=new ArrayList<>();
        }
    }
    public void add(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public int v(){return v;}
    public int e(){return e;}
    public Iterable<Integer>adj(int v){return adj[v];}
}
