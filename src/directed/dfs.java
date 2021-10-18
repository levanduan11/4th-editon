package directed;

public class dfs {
    private  boolean []marked;
    public dfs(digraph g,int s){
        marked=new boolean[g.v()];
        dfs(g,s);
    }
    public dfs(digraph g,Iterable<Integer>sources){
        marked=new boolean[g.v()];
        for (int s:sources
             ) {if(!marked[s]) dfs(g,s);

        }
    }
    public boolean marked(int v){
        return marked[v];
    }
    public void dfs(digraph g,int v){
        marked[v]=true;
        for (int w:g.adj(v)
             ) {
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }
}
