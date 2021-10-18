package baseprograming;

import java.util.Iterator;

public class xed {
    private int[] a; // stack entries
    private int N; // size
    public xed
            (int cap)
    { a = new int[cap]; }
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void push(int item)
    { a[N++] = item; }
    public int pop()
    {
--N;
a[N]=0;
        return a[N];
    }

    public static void main(String[] args) {
        xed xed=new xed(10);
        xed.push(1);
        xed.push(2);
        xed.push(3);
        xed.push(4);
        xed.push(5);


      Iterator<Integer>iterator=xed.t();
      while (iterator.hasNext()){
int i=iterator.next();
          System.out.println(i);
      }

    }
    public Iterator<Integer>t(){
        return new iter();
    }


    private class iter implements Iterator<Integer>{
private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Integer next() {
            return a[--i];
        }
    }

}
