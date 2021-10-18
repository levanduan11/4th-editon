package baseprograming;

public class UF {
    private int []parent;
    private int []rank;
    private int count;

    public UF(int n) {
        if(n<0) throw new IllegalArgumentException();
        count=n;
        parent=new int[n];
        rank=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            rank[i]=0;
        }

    }
    private void validate(int p){
        int n=parent.length;
        if(p<0||p>n)throw new IllegalArgumentException();
    }
    public int find(int p){
        validate(p);
        while (p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    public int count(){
        return count;
    }
    public  boolean connected(int p,int q){
        return find(q)==find(p);
    }

    public void union(int p,int q){
        int rootq=find(q);
        int rootp=find(p);
        if(rootq==rootp)return;
        if(rank[rootp]<rank[rootq])parent[rootp]=q;
        else  if(rank[rootp]>rank[rootq])parent[rootq]=p;
        else {
            parent[rootq]=rootp;
            rank[rootp]++;
        }
        count--;
    }
}
