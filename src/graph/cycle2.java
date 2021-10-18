package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class cycle2 {
    private int v;
    private LinkedList<Integer>adj[];

    public cycle2(int v) {
        this.v=v;
        adj=new LinkedList[v];
        for (int i = 0; i <v ; i++) {
            adj[i]=new LinkedList<>();
        }
    }
    void add(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public boolean iscycle(int v,boolean[]visited,int parent){
        visited[v]=true;
        Integer i;
        Iterator<Integer>it=adj[v].listIterator();
        while (it.hasNext()){
            i=it.next();
            if(!visited[i]){
              if(  iscycle(i,visited,v));
              return true;
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean is(){
     boolean visited[]=new boolean[v];
        for (int i = 0; i <v ; i++) {
            visited[i]=false;
        }
        for (int i = 0; i <v ; i++) {
            if(!visited[i]){
                if(iscycle(i,visited,-1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        cycle2 c=new cycle2(5);
        c.add(1,0);
        c.add(0,2);
        c.add(2,1);
        c.add(0,3);
        c.add(3,4);
        if (c.is())
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
