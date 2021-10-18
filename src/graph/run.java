package graph;

public class run {

  static   long TinhXn (int n)
    {
        if(n==0)
            return 1;
        long s = 0;
        for (int i=1; i<=n; i++)
            s = s + i * i * TinhXn(n-i);
        return s;
    }
    public static void main(String[] args) {
//        Graph g=new Graph(4);
// g.add(0, 1);
//     g.add(0, 2);
//        g.add(1, 2);
//     g.add(2, 0);
//  g.add(2, 3);
//    g.add(3, 3);
//        twocolor t=new twocolor(g);
//        System.out.println(t.isbipartite());
        int a,b = 0;
        a=b;
        b=5;
        System.out.println(a);
    }
}
