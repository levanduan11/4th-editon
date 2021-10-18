package spanningtrees;

public class edge implements Comparable<edge>{
    private int v;
    private int w;
    private double weight;

    public edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return weight;
    }
    public int either(){
        return v;
    }
public int other(int vertex){
        if(vertex==v) return w;
        else if(vertex==w)return v;
        else throw new RuntimeException("iocnsistent edge");

}
    @Override
    public int compareTo(edge o) {
        return (int) (this.weight-o.weight);
    }

    @Override
    public String toString() {
        return "edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
