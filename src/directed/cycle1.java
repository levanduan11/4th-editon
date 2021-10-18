package directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class cycle1 {
    private int v;
    private List<List<Integer>>adj;

    public cycle1(int v) {
        this.v = v;
        this.v=v;
        adj=new ArrayList<>(v);
        for (int i = 0; i <v ; i++) {
            adj.add(new LinkedList<>());
        }
    }
    public boolean iscycle(int i,boolean[]visited,boolean[]recstack){
        //mark the current node as visited and
        //part of recursion stack
        if(recstack[i])
            return true;
        if(visited[i])
            return false;
        visited[i]=true;
        recstack[i]=true;
        List<Integer>l=adj.get(i);
        for (Integer c:l
             ) {
            if(iscycle(c,visited,recstack))
                return true;
        }

        recstack[i]=false;
        return false;
    }
    public void add(int source,int dest){
        adj.get(source).add(dest);
    }
    public boolean iscyclic(){
        boolean[]visited=new boolean[v];
        boolean[]recstack=new boolean[v];
        for (int i = 0; i <v ; i++) {
            if(iscycle(i,visited,recstack))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        cycle1 c=new cycle1(4);
        c.add(0,1);
       c.add(0,2);
        c.add(1,2);
  // c.add(2,0);
        c.add(2,3);
      //c.add(3,3);
        System.out.println(c.iscyclic());
    }
}
