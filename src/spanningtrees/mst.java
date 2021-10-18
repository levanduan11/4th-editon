    package spanningtrees;

    public class mst {
        private int v=5;
        int minkey(int key[],boolean mst[]){
            int min=Integer.MAX_VALUE,min_index=-1;
            for (int i = 0; i < v; i++) {
                if(mst[i]==false&&key[i]<min){
                    min=key[i];
                    min_index=i;
                }
            }
            return min_index;
        }
        void printmst(int parent[],int graph[][]){
            System.out.println("---");
            for (int i = 1; i < v; i++) {
                System.out.println(parent[i]+"-"+i+"\t"+graph[i][parent[i]]);
            }
        }
        void primmst(int graph[][]){
            int parent[]=new int[v];
            int key[]=new int [v];
            boolean mstset[]=new boolean[v];
            for (int i = 0; i < v; i++) {
                key[i]=Integer.MAX_VALUE;
                mstset[i]=false;
            }
            key[0]=0;
            parent[0]=-1;
            for (int i = 0; i < v-1; i++) {
                int u=minkey(key,mstset);
                mstset[u]=true;
                for (int j = 0; j < v; j++)
                    if(graph[u][j]!=0&&mstset[j]==false&&graph[u][j]<key[j]){
                        parent[j]=u;
                        key[j]=graph[u][j];
                    }

            }
            printmst(parent,graph);
        }

        public static void main(String[] args) {
            mst t = new mst();

            int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                    {2, 0, 3, 8, 5},
                    {0, 3, 0, 0, 7},
                    {6, 8, 0, 0, 9},
                    {0, 5, 7, 9, 0}};
            t.primmst(graph);
        }
    }
