package test;

    public class union {
    int v,e;
    edge edge[];
    class edge{
        int src,dest;
    };

    union(int v,int e){
        this.v=v;
        this.e=e;
        edge =new edge[e];
        for (int i = 0; i < e; i++) {
            edge[i]=new edge();
        }
    }
        int find(int parent[],int i){
        if(parent[i]==-1)
            return i;
        return find(parent,parent[i]);
        }

        void uni(int parent[],int x,int y){
            int xset=find(parent,x);
            int yset=find(parent,y);
            parent[xset]=yset;
        }
        boolean icycle(union union){
        int parent[]=new int[union.v];
            for (int i = 0; i < union.v; i++) {
                parent[i]=-1;
            }
            for (int i = 0; i < union.e; i++) {
                int x=find(parent,union.edge[i].src);
                int y=find(parent,union.edge[i].dest);
                if(x==y)
                    return true;

                union.uni(parent,x,y);
            }
      return false;
        }

        public static void main(String[] args) {
            int v=3,e=3;
            union u=new union(v,e);
            u.edge[0].src=0;
            u.edge[0].dest=1;
            u.edge[1].src=1;
            u.edge[1].dest=2;
            u.edge[2].src=0;
            u.edge[2].dest=2;

            if(u.icycle(u)){
                System.out.println(1);
            }
            else
                System.out.println(0);

        }
    }
