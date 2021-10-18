package graph;

public class cycle {
    public boolean[]marked;
    public boolean hascycle;

    public cycle(Graph g) {
        marked=new boolean[g.v()];
        for (int i = 0; i <g.v() ; i++) {
            if(!marked[i]){
                dfs(g,i,i);
            }
        }
    }
    public void dfs(Graph g,int v,int u){
        marked[v]=true;
        for (int w:g.adj(v)) {

            if (!marked[w]) {
                dfs(g, w, v);

            }
            else if (w != u)
                hascycle = true;
        }

    }
    public boolean hascycle(){
        return hascycle;
    }
}
