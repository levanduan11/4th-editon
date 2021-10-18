package p2;

import java.security.Key;

public class MaxPQ <Key extends Comparable<Key>>{
    private Key []pq;
    private int n=0;

    public MaxPQ(int maxn) {
       pq=(Key[]) new Comparable[maxn+1];
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public void insert(Key v){}
    //public Key delMax(){}
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i,int j){
        Key tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
    }
    private void swim(int k){
        while (k>=1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=n){
            int j=2*k;
            if(less(j,j+1))j++;
            if(!(less(k,j)))break;
            exch(k,j);
            k=j;
        }
    }
}
