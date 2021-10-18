package baseprograming;

public class WeightedQuickUnionUF {
    private int []parent;
    private int[]s;
    private int coutn;

    public WeightedQuickUnionUF(int n) {
        this.coutn = n;
        parent=new int[n];
        s=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            s[i]=1;
        }
    }
    public  boolean connected(int p,int q){
        return find(q)==find(p);
    }

    public int getCoutn() {
        return coutn;
    }
    public int find(int p){
        validate(p);
        int root=p;
        while (root!=parent[root]){
         root=parent[root];
        }
        while (p!=root){
            int newp=parent[p];
            parent[p]=root;
            p=newp;
        }
        return root;
    }
    public void union(int p,int q){
        int rootp=find(p);
        int rootq=find(q);
        if(rootq==rootp)return;
        //make smaller root point to large one
        if(s[rootp]<s[rootq]){
            parent[p]=rootq;
            s[rootq]+=s[rootp];
        }
        else {
            parent[q]=rootp;
            s[rootp]+=s[rootq];
        }
        coutn--;
    }
    private void validate(int p){
      int  n=parent.length;
        if(p<0||p>=n)throw new IllegalArgumentException();
    }
}
