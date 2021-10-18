package p2;

public class Selection {

    public static void sort(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of a minimal entry.
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void sort2(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++)
        { // Insert a[i] among a[i-1], a[i-2], a[i-3]....
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }
    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
    private static void exch(int[] a, int i, int j)
    { int t = a[i]; a[i] = a[j]; a[j] = t; }
    private static void show(Comparable[] a)
    { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a)
    { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    public static void sort5(Comparable[] a)
    { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        { // h-sort the array.
            for (int i = h; i < N; i++)
            { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
        }
    }
    static void qucksort2(int []a,int l,int r){
        int x=a[l];
        int i=l+1;
        int j=r;int t;
        do {
            while ((i<=j)&&(a[i])<=x) i++;
            while ((i<=j)&&(a[j]>x)) j--;
            if(i<j){
                t=a[i];
                a[i]=a[j];
                a[j]=t;

            }
        }while (i<j);
        t=a[l];
        a[l]=a[j];
        a[j]=t;
       if(l<j-1)
            qucksort2(a,l,j-1);
        if (j+1<r)
            qucksort2(a,j+1,r);
    }
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }
    private static int partition(Comparable[] a, int lo, int hi)
    { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true)
        { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }
    public static int com(int a,int b){
        return a-b;
    }
    public static boolean check(int a,int b){
        return com(a,b)<0;
    }
    public static int pa(int a[],int lo,int hi,int c){

        int i = lo, j = hi+1; // left and right scan indices
       int v = a[lo]; // partitioning item
        while (true)
        { // Scan right, scan left, check for scan complete, and exchange.

            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j;
    }
    private static void sort7(Comparable[] a, int lo, int hi)
    { // See page 289 for public sort() that calls this method.
        if (hi <= lo) return;
        int lt = lo, i = lo+1, j = hi;
        Comparable v = a[lo];
        while (i <= j)
        {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, j--);
            else i++;
        } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort7(a, lo, lt - 1);
        sort7(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Comparable a[] = {7,19,3,2,1,0,70,67,65,64,50,53,52};
        sort(a,0,a.length-1);
       // sort7(a,0,a.length-1);
        show(a);

    }

}
