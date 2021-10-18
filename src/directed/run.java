package directed;

public class run {
    static int tinh(int n){
        if(n==10)return 10;
        return tinh(n+1)+n;
    }
    public static void main(String[] args) {
//        digraph g=new digraph(4);
//        g.add(0,1);
//        g.add(0,2);
//        g.add(1,2);
//        g.add(2,0);
//        g.add(2,3);
//        g.add(3,3);
//       dfsorder d=new dfsorder(g);
//        System.out.println(d.post());
        System.out.println(tinh(0));
    }
}
