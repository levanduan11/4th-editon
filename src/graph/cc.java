package graph;

public class cc {
    private boolean marked[];
    private int id[];
    private int count;

    public cc(Graph g) {
        id=new int[g.v()];
        count=0;
        id=new int[g.v()];
        marked=new boolean[g.v()];
        for (int i = 0; i <g.v() ; i++) {
      if(!marked[i]){
          dfs(g,i);
          count++;
      }
        }
    }
 public void dfs(Graph g,int v){
        marked[v]=true;
        id[v]=count;
        for (int w:g.adj(v)
             ) {
            if(!marked[w]){
                dfs(g,w);
            }

        }
    }
    public boolean connecyted(int v,int w){
        return id[v]==id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int count(){
        return count;
    }
}
