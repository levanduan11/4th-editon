package test;

import java.util.Scanner;

public class test {
    static boolean de(String s,String k){
        if(s.length()==0)return k.length()==0;
       return de(s.substring(1),k)||de(s,k.substring(1));
    }
    static void show(int n,int i) {

        int arr[]= {500,100,50,10,5,1};
if(n==0)return;
        System.out.println("gia tien la arr[i]: "+n/arr[i]);
        show(n%arr[i],i=i+1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        //show(1236, 0);
        System.out.println(de("odjfdjfldjfdlkjfdljfdfjfdf","djflkdjfkdjfkdjflkdjfdkjfldkjf"));

    }
}
