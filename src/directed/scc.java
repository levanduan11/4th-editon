package directed;

public class scc {
    private boolean []marked;
    private  int id[];
    private int  count;

    public scc(digraph g) {
        count=0;
        marked=new boolean[g.v()];
        id=new int[g.v()];
        for (int i = 0; i < g.v(); i++) {
if(!marked[i]){
    dfs(g,i);
    count++;
}
        }
    }
    public void dfs(digraph g,int v){
        marked[v]=true;
        id[v]=count;
        for (int w:g.adj(v)
             ) {
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }
    public boolean stronglyconnected(int v,int w){
        return id[v]==id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int count(){
        return count;
    }
}
