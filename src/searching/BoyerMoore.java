package searching;

public class BoyerMoore {
    private int[]right;
    private String pat;

    public BoyerMoore(String pat) {
        this.pat = pat;
        int m=pat.length();
        int r=256;
        right=new int[r];
        for (int i = 0; i < r; i++) {
            right[i]=-1;
        }
        for (int i = 0; i < m; i++) {
            right[pat.charAt(i)]=i;
        }
    }
    public int search(String txt){
        int n=txt.length();
        int m=pat.length();
        int skip;
        for (int i = 0; i <=n-m; i+=skip) {
            skip=0;
            for (int j = m-1; j >=0 ; j--) {
                if(pat.charAt(j)!=txt.charAt(i+j)){
                    skip=j-right[txt.charAt(i+j)];
                    if (skip<1)skip=1;
                    break;
                }
            }
            if (skip==0)return i;//found
        }
        return n;//not found
    }

    public static void main(String[] args) {
        String s="FINDINAHAYSTACKNEEDLEINA";
        String pat="NEEDLE";
    }
}
