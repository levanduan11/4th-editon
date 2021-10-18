package directed;

import java.util.Stack;

public class cycle2 {
    private boolean[]mark;
    private int []edgeto;
    private Stack<Integer>cycle;
    private boolean[]onstack;

    public cycle2(digraph g) {
        onstack=new boolean[g.v()];
        mark=new boolean[g.v()];
        edgeto=new int[g.v()];
        for (int i = 0; i <g.v() ; i++) {
            if(!mark[i]) dfs(g,i);
        }

    }
    public void dfs(digraph g,int v){
        onstack[v]=true;
        mark[v]=true;
        for (int w:g.adj(v)
             ) {
            if(this.hascycle())return;
           else if(!mark[w]){
               edgeto[w]=v;
                dfs(g,w);

            }
           else if(onstack[w]){
               cycle=new Stack<Integer>();
                for (int i = 0; i !=w ; i=edgeto[i]) {
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(v);
            }

        }
        onstack[v]=false;
    }
    public boolean hascycle(){
        return cycle!=null;
    }
    public Iterable<Integer>cycle(){
        return cycle;
    }
}
