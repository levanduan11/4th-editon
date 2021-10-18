package baseprograming;

public class daomang {

    static void dao(int arr[]){
        for (int i = 0; i < arr.length/2; i++) {
            int tmp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=tmp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
       // dao(arr);
        int a=5;
        int b=4;
        int c=3;
        int t ;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        System.out.println(a);
        int aa=9;
        System.out.println(aa);


    }
}
