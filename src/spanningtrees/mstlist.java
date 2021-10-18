package spanningtrees;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class mstlist {
    class node1{
        int dest;
        int weight;

        public node1(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static  class graph{
        int v;
        LinkedList<node1>[]adj;
        graph(int e){
            v=e;
            adj=new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i]=new LinkedList<>();

        }
    }
    class node{
        int vertex;
        int key;

    }
    class comparator implements Comparator<node>{

        @Override
        public int compare(node o1, node o2) {
            return o1.key-o2.key;
        }
    }


    void add(graph graph,int src,int dest,int weight){
        node1 node0=new node1(dest,weight);
        node1 node=new node1(src,weight);
        graph.adj[src].addLast(node0);
        graph.adj[dest].addLast(node);

    }

    void prim(graph graph){
        boolean[]mark=new boolean[graph.v];
        node[]e=new node[graph.v];
        int parent[]=new int[graph.v];

        for (int i = 0; i < graph.v; i++) {
            e[i]=new node();
        }
        for (int i = 0; i <graph.v ; i++) {
          mark[i]=false;
          e[i].key=Integer.MAX_VALUE;
          e[i].vertex=i;
          parent[i]=-1;
        }
        mark[0]=true;

        e[0].key=0;


        TreeSet<node>q=new TreeSet<>(new comparator());

        for (int i = 0; i < graph.v; i++)
            q.add(e[i]);

        while (!q.isEmpty()){
            node node=q.pollFirst();

            mark[node.vertex]=true;
            for (node1 itr:graph.adj[node.vertex]
                 ) {
            if(mark[itr.dest]==false){
                if(e[itr.dest].key>itr.weight){
                    q.remove(e[itr.dest]);
                    e[itr.dest].key=itr.weight;
                    q.add(e[itr.dest]);
                    parent[itr.dest]=node.vertex;
                }
            }
            }
        }
    }
}
