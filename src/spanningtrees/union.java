package spanningtrees;

public class union {
    private int []parent;
    private byte[]rank;
    private int cout;

    public union(int n){
        if(n<0)throw new IllegalArgumentException();
        cout=n;
        parent=new int[n];
        rank=new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int find(int p){
        while (p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    public int getCout(){
        return cout;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public void union(int p,int q){
        int rootp=find(p);
        int rootq=find(q);
        if(rootq==rootq)return;
        if(rank[rootp]<rank[q])parent[rootp]=rootq;
        else if(rank[rootp]>rank[q])parent[rootq]=rootp;
        else {
            parent[q]=rootp;
            rank[rootp]++;
        }
        cout--;
    }
    private void validate(int p){
        int n=parent.length;
        if(p<0||p>n)
            throw new IllegalArgumentException("index"+p+"is not between 0 and"+(n+1));
    }
}
