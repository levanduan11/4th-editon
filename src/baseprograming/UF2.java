package baseprograming;

public class UF2 {
    private int[]id;
    private int[]size;
    private int count;
    public UF2(int n){
        count=n;
        id=new int[n];
        for (int i = 0; i < n; i++) {
            id[i]=i;
        }
        size=new int[n];
        for (int i = 0; i < n; i++) {
            size[i]=1;
        }
    }
    private void validate(int p){
        int n=id.length;
        if(p<0||p>=n){
            throw new IllegalArgumentException("index"+p+"is not between 0 and"+(n-1));
        }
    }
    public int coutn(){
        return count;
    }
    public int find(int p){
        validate(p);
        while (p!=id[p])
            p=id[p];
        return p;
    }
    public void union(int p,int q){
        int a=find(p);
        int b=find(q);
        if(a==b)return;
        id[a]=b;
        count--;
    }
}
