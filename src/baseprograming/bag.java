package baseprograming;

import java.util.Iterator;

public class bag implements Iterable<Integer> {
    node head;

    @Override
    public Iterator<Integer> iterator() {
        return new list();
    }

   private class node{
        node next;
        int data;

    }
    public void add(int data){
        node node=head;
        head=new node();
        head.data=data;
        head.next=node;

    }
    private class  list implements Iterator<Integer>{
private node curent=head;
        @Override
        public boolean hasNext() {
            return curent!=null;
        }

        @Override
        public Integer next() {
            int datta=curent.data;
            curent=curent.next;
            return datta;
        }
    }

}
