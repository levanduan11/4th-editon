package hastable;

public class node {
    Object key;
    Object val;
    node next;

    public node(Object key, Object val, node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
