package test;

public class t1 {
    static int s(int a,int b,int c){
        int max,flag;
        return max=(flag=a>b?a:b)>c?flag:c;
    }
   static void move(int n,char A,char B,char C)
    {
        if(n==1){
            System.out.println(A+" =>"+C);

        }
        else {
            //// Nếu n > 1 thì thực hiện lần lượt các bước
            move(n - 1, A, C, B); // 1. Dịch chuyển n-1 đĩa từ A -> B
            System.out.println(A+" =>"+C); //2. Dịch chuyển đĩa thứ n từ A -> C
            move(n - 1, B, A, C); // 3. Dịch chuyển n-1 đĩa từ B -> C
        }
    }
    public static void main(String[] args) {
//        System.out.println(16>>2&7);//8/2^2
//        System.out.println(3<<2&9);//3*2^2
//        int x=1-1%3;
//        System.out.println(x);
//        System.out.println("max is:"+s(1,2,3));
        char a='a';
        char b='b';
        char c='c';
        move(4,a,b,c);
    }
}
