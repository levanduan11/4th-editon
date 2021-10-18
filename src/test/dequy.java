package test;

public class dequy {
  static   int xn(int n) {
        if (n == 0) return 1;
        return xn(n-1)+yn(n-1);
    }
  static   int yn(int n) {
        if (n == 0) return 0;
        return 3*xn(n-1)+2*yn(n-1);
    }
    static int d(int n){
        if(n==0)return 1;
        int s=0;
        for (int i = 0; i <n ; i++) {
            s+=d(n-i-1);
        }
        return s;
    }
    static int s(int n){
        int s=0;
        if(n==0)return 0;
        for (int i = 0; i <= n; i++) {
            s=n+s(n-1);
        }
       return s;
    }
static int k(int n){

   if(n==0)return 0;
   return n+k(n-1);
}
static int res(int n){
      int s=0;
    for (int i = 0; i <=n ; i++) {
        s+=k(i);
    }
    return s;
}
    public static void main(String[] args) {
        System.out.println(k(1));
        System.out.println(k(2));
        System.out.println(k(3));
        System.out.println(k(4));
        System.out.println(k(5));
        System.out.println(res(5));
        System.out.println(s(5));
    }
}
