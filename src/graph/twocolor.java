package graph;

public class twocolor {
    private boolean[]marked;
    private boolean[]color;
    private boolean istwocolorable=true;

    public twocolor(Graph g) {
        marked=new boolean[g.v()];
        color=new boolean[g.v()];
        for (int i = 0; i <g.v() ; i++) {
            if(!marked[i])
                dfs(g,i);
        }
    }
    private void dfs(Graph g,int v){
        marked[v]=true;
        for (int w:g.adj(v))
        {
            if(!marked[w])
            {
                 color[w]=!color[v];
                 dfs(g,w);
            }
        else if(color[w]==color[v])istwocolorable=false;

        }
    }
    public  boolean isbipartite(){
        return istwocolorable;
    }
}
