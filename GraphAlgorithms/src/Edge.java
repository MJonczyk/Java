public class Edge{
    Vertex v;
    Vertex u;
    int weight;
    boolean marked;
    Edge(Vertex v, Vertex u, int weight){
        this.v = v;
        this.u = u;
        this.weight = weight;
    }

    int compareWeight(Edge e){
        if(this.weight > e.weight) return 1;
        else if(this.weight < e.weight) return -1;
        return 0;
    }
}
