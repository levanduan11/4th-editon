package test;


class trie {
    public static void main(String[] args) {
        String arr[] = new String[5];
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2*n+1; j++) {
                if(j>n-i-1&&j<n+i+1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }




    }





}