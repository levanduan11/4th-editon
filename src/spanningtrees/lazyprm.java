package spanningtrees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lazyprm {
    static class edge implements Comparable<edge>{
int from ,to,cost;

        public edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(edge o) {
            return cost-o.cost;
        }
    }


    //input

    private   int n;
    private  List<List<edge>>graph;

    //internal

    private boolean solved;
    private boolean mstexists;
    private boolean []visired;
    private PriorityQueue<edge>q;

    //ouput

    private long mincostsum;
    private edge[]mstedges;

    public  lazyprm(List<List<edge>>graph){
        if(graph==null||graph.isEmpty())throw new IllegalArgumentException();

        this.n=graph.size();
        this.graph=graph;

    }
public edge[]getMstedges(){
        solve();
        return mstexists?mstedges:null;
}
public Long getmscost()
{
    solve();
    return mstexists?mincostsum:null;
}
    private void addedges(int nodeindex){
        visired[nodeindex]=true;
        //egdeges will never be null if the createempty method was used to buil the graph

        List<edge>edges=graph.get(nodeindex);

        for (edge e:edges
             ) {
            if(!visired[e.to]){
                q.offer(e);
            }
        }

    }


//

    private void solve(){
        if(solved)return;
        solved=true;


        int m=n-1,edcount=0;
        q=new PriorityQueue<>();
        visired=new boolean[n];
        mstedges=new edge[m];


        //add initial set of edges to the priority pueue starting at node 0.

        addedges(0);

        //loop while the mst is not complete.

        while (!q.isEmpty()&&edcount!=m){
            edge edge=q.poll();
            int idex=edge.to;

            //skip any edge pointing to an already visited node.

            if(visired[idex])continue;


            mstedges[edcount++]=edge;
            mincostsum+= edge.cost;


            addedges(idex);
        }

        mstexists=(edcount==m);
    }
    static List<List<edge>>create(int n){
        List<List<edge>>g=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }
    static void addd(List<List<edge>>g,int from,int to,int cost){
        g.get(from).add(new edge(from,to,cost));
    }

    static void adundd(List<List<edge>>g,int from,int to,int cost){
        addd(g,from,to,cost);
        addd(g,to,from,cost);
    }

}
