package directed;

import java.util.ArrayList;
import java.util.List;

public class digraph {
    private int v;
    private int e;
    List<Integer>adj[];

    public digraph(int v) {
        this.v=v;
        this.e=0;
        adj=(List<Integer>[]) new ArrayList[v];
        for (int i = 0; i <v ; i++) {
            adj[i]=new ArrayList<>();
        }
    }
    public int v(){
        return v;
    }
    public int e(){
        return e;
    }
    public Iterable<Integer>adj(int v){
        return adj[v];
    }
    public void add(int v,int w){
        adj[v].add(w);
        e++;
    }
    public digraph reverse(){
        digraph d=new digraph(v);
        for (int i = 0; i <v ; i++) {
            for (int w:adj(v)
                 ) {
                d.add(w,v);
            }
        }
        return d;
    }
}
