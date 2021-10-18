package p2;

public class mpq<Key extends Comparable<Key>> {

    private Key[] pq; // heap-ordered complete binary tree
    private int N = 0; // in pq[1..N] with pq[0] unused
    public mpq(int maxN)
    { pq = (Key[]) new Comparable[maxN+1]; }
    public boolean isEmpty()
    { return N == 0; }
    public int size()
    { return N; }
    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }
    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private void swim(int k)
    {
        while (k > 1 && less(k/2, k))
        {
            exch(k/2, k);
            k = k/2;
        }
    }
    private boolean less(int i, int j)
    { return pq[i].compareTo(pq[j]) < 0; }
    private void exch(int i, int j)
    { Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; }
    public Key delMax()
    {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange with last item.
        pq[N+1] = null; // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }


    public static void main(String[] args) {
        mpq mpq =new mpq(15);
        mpq.insert(9);
        mpq.insert(8);
        mpq.insert(7);
        mpq.insert(6);
        mpq.insert(5);
        mpq.insert(4);
        mpq.insert(3);
        mpq.sink(1);
    }
}
