package graph;

import java.util.Stack;

public class ccycle {
    private boolean[]marked;
    private int[]edg;
    private Stack<Integer>cycle;

    public ccycle(Graph g) {

    }
    private boolean hasselfloop(Graph g){
        for (int i = 0; i <g.v() ; i++) {
            for (int w:g.adj(i)
                 ) {
                if(i==w){
                    cycle=new Stack<Integer>();
                    cycle.push(i);
                    cycle.push(i);
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hasedges(Graph g){
        marked=new boolean[g.v()];
        for (int i = 0; i <g.v() ; i++) {
            for (int w:g.adj(i)
                 ) {
                if(marked[w]){
                    cycle=new Stack<Integer>();
                    cycle.push(i);
                    cycle.push(w);
                    cycle.push(i);
                }
                marked[w]=true;
            }
            for (int w:g.adj(i)
                 ) {marked[w]=false;

            }
        }
        return false;
    }
    public Iterable<Integer>cycle(){
        return cycle;
    }
    public void dfs(Graph g,int u,int v){
        marked[v]=true;
        for (int w:g.adj(v)
             ) {
            if(cycle!=null)return;
            if(!marked[w]){
                edg[w]=v;
                dfs(g,v,w);
            }
            else if(w!=u){
                cycle=new Stack<Integer>();
                for (int i = 0; i!=w ; i=edg[i]) {
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean hascycle(){
        return cycle!=null;
    }
}
