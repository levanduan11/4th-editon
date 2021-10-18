package searching;

public class Bruteforce {
    public static void main(String[] args) {
        String s="abbabccababc";
        String pat="ba";

            System.out.println(searching(s,pat));


    }
    public static int  searching(String s,String pat){
        int n=s.length();
        int m=pat.length();
        for (int i = 0; i <=n-m ; i++) {
            int j;
            for ( j = 0; j < m; j++) {
                if(s.charAt(i+j)!=pat.charAt(j))break;
            }
            if(j==m) return i;

        }
        return n;
    }
}
