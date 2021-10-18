package p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class minpq<Key extends Comparable<Key>>implements Iterable<Integer> {
    private int maxn;
    private int n;
    private int[]qp;
    private int[]pq;
    private Key[]key;

    public minpq(int maxn) {
        if(maxn<0)throw new IllegalArgumentException();
        this.maxn = maxn;
        n=0;
        key=(Key[])new Comparable[maxn+1];
        qp=new int[maxn+1];
        pq=new int[maxn+1];
        for (int i = 0; i < maxn; i++) {
            qp[i]=-1;
        }

    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    private void validate(int i){
        if(i<0)throw new IllegalArgumentException();
        if(i>=maxn)throw new IllegalArgumentException();
    }
    public boolean contains(int i){
        validate(i);
        return qp[i]!=-1;
    }
    private boolean greater(int i,int j){
        return key[pq[i]].compareTo(key[pq[j]])>0;
    }
    private void exch(int i,int j){
        int swap=pq[i];
        pq[i]=pq[j];
        pq[j]=swap;
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
    public void insert(int i, Key keyy) {
        //validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        key[i] = keyy;
        swim(n);
    }
    private void swim(int k){
        while (k>1&&greater(k/2,k)){
            exch(k,k/2);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=n){
            int j=2*k;
            if(j<n&&greater(j,j+1))j++;
            if(!greater(k,j))break;
            exch(k,j);
            k=j;
        }
    }
    public int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;        // delete
        key[min] = null;    // to help with garbage collection
        pq[n+1] = -1;        // not needed
        return min;
    }
    public void delete(int i){
        validate(i);
        if(!contains(i))throw new NoSuchElementException();
        int idex=qp[i];
        exch(idex,n--);
        swim(idex);
        sink(idex);
        qp[i]=-1;
    }
    public void changekey(int i,Key keyy){
        validate(i);
        if(!contains(i))throw new NoSuchElementException();
        key[i]=keyy;
        swim(qp[i]);
        sink(qp[i]);
    }
    public Iterator<Integer> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private minpq<Key> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new minpq<>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], key[pq[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

}
