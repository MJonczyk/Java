import java.util.LinkedList;
public class Graph {
    LinkedList<Edge>[] NList;
    LinkedList<Vertex> vList;
    LinkedList<Edge> eList;
    boolean[] marked;
    int V;
    Graph(int v){
        NList = new LinkedList[v];
        eList = new LinkedList<Edge>();
        vList = new LinkedList<Vertex>();
        marked = new boolean[v];
        V = 0;
        for(int i = 0;i < NList.length;i++){
            NList[i] = null;
            marked[i] = false;
        }
    }
    void addEdge(int v, int u, int weight){
        Vertex vver = getVertex(v);
        Vertex uver = getVertex(u);
        if(NList[vList.indexOf(vver)] == null) NList[vList.indexOf(vver)] = new LinkedList();
        if(NList[vList.indexOf(uver)] == null) NList[vList.indexOf(uver)] = new LinkedList();
        if(belongs(v) && belongs(u)) {
            NList[vList.indexOf(vver)].add(new Edge(vver,uver,weight));
            NList[vList.indexOf(uver)].add(new Edge(uver,vver,weight));
            eList.add(new Edge(vver,uver,weight));
        }
    }
    void addVertex(int v){
        vList.add(new Vertex(v));
        V++;
    }
    boolean belongs(int v){
        for(int i = 0;i < vList.size(); i++){
            if(vList.get(i).value == v) return true;
        }
        return false;
    }
    Vertex getVertex(int v){
        if(belongs(v)){
            for(int i = 0;i < vList.size();i++){
                if(vList.get(i).value == v) return vList.get(i);
            }
        }
        return null;
    }
    void makeSet(Vertex x) {x.parent = x; }
    void union (Vertex x , Vertex y) {link(find(x),find(y)); }
    void link (Vertex x, Vertex y) {y.parent = x; }
    Vertex find( Vertex x ) {return x == x.parent ? x : find(x.parent) ;}
    void printVertices(){
        System.out.println("List of vertices");
        for(int i = 0; i < V;i++){
            System.out.print(vList.get(i).value+", ");
        }
        System.out.println();
        System.out.println();
    }
    void printEdges(){
        System.out.println("List of edges");
        for(int i = 0; i < NList.length;i++){
            if(NList[i] != null){
                System.out.print(vList.get(i).value+": ");
                for(Edge e : NList[i]){
                    System.out.print(e.u.value+", ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    void printEdgeList(){
        System.out.println("Second list of edges");
        for(Edge e : eList){
            System.out.println(e.weight+" ("+e.v.value+","+e.u.value+")");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Graph m = new Graph(6);
        m.addVertex(5);
        m.addVertex(3);
        m.addEdge(5,3,3);
        m.printVertices();
        m.printEdges();
        m.printEdgeList();
        m.addVertex(7);
        m.addVertex(15);
        m.printVertices();
        m.printEdges();
        m.printEdgeList();
        m.addEdge(5,7,19);
        m.addEdge(15,3,8);
        m.printVertices();
        m.printEdges();
        m.printEdgeList();
        m.addVertex(12);
        m.addVertex(2);
        m.addEdge(2,5,2);
        m.addEdge(2,3,1);
        m.addEdge(2,12,38);
        m.addEdge(12,7,13);
        m.printVertices();
        m.printEdges();
        m.printEdgeList();
    }
}

