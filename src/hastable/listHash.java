package hastable;

public class listHash <k,v>{
  int m=8191;
  node[] st=new node[m];

   private int hash(k k){
       return (k.hashCode() & 0x7fffffff)%m;


   }
   public void put(k k,v v){
       int i=hash(k);
       for (node j = st[i]; j!=null ; j=j.next) {
           if(k.equals(j.key)){
               j.val=v;return;//chen trung khoa
           }
       }
       st[i]=new node(k,v,null);
   }
   public v get(k k){
       int i=hash(k);
       for (node j = st[i]; j!=null ; j=j.next) {
           if(k.equals(j.key)){
               return (v)j.val;
           }
       }
       return null;
   }

}
