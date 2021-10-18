package hastable;

public class arraylist<k,v> {
    private int m=300001;
    private v[]va=(v[]) new Object[1000];
    private k[]ke=(k[]) new Object[1000];
    private int hash(k k){
        return (k.hashCode()&0x7fffffff)%m;
    }

public void  put(k k ,v v){
        int i;
    for ( i = hash(k);ke[i]!=null ; i=(i+1)%m) {
        if (k.equals(ke[i]))break;
    }
    va[i]=v;
    ke[i]=k;
}
    public void  put1(k k ,v v){
        int i;
        int j;
        for ( j=1,i = hash(k);ke[i]!=null ; i=(hash(k)+j)%m,j++) {
            if (k.equals(ke[i]))break;
        }
        va[i]=v;
        ke[i]=k;
    }
    public void  put2(k k ,v v){
        int i;
        int j;
        for ( j=1,i = hash(k);ke[i]!=null ; i=(hash(k)+j*j)%m,j++) {
            if (k.equals(ke[i]))break;
        }
        va[i]=v;
        ke[i]=k;
    }
public v get(k k){
    for (int i = hash(k); ke[i]!=null; i=(i+1)%m) {
        if(k.equals(ke[i]))return va[i];
    }
    return null;
}

    public static void main(String[] args) {

    }
}
