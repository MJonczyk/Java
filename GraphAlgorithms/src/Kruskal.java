import java.util.LinkedList;
public class Kruskal {
    Graph G;
    LinkedList<Edge> tree;
    int treeWeight;
    Kruskal(Graph G){
        this.G = G;
        this.tree = new LinkedList<Edge>();
        this.treeWeight = 0;
        for(int i = 0;i < G.V;i++) G.makeSet(G.vList.get(i));
        G.eList.sort(new EdgeComparator());
    }
    void mst(){
        int i = 0;
        while(tree.size() < G.V - 1){
            Edge e = G.eList.get(i);
            if(G.find(e.v) != G.find(e.u)){
                G.union(e.v,e.u);
                tree.add(e);
                treeWeight+=e.weight;
            }
                i++;
        }
    }
    void printMST(){
        System.out.println("MST");
        for(Edge e : tree){
            System.out.println(e.weight+" ("+e.v.value+","+e.u.value+")");
        }
        System.out.println("MST weight: "+treeWeight);
    }
    public static void main(String[] args){
        Graph m = new Graph(6);
        m.addVertex(5);
        m.addVertex(3);
        m.addEdge(5,3,3);
        m.addVertex(7);
        m.addVertex(15);
        m.addEdge(5,7,19);
        m.addEdge(15,3,8);
        m.addVertex(12);
        m.addVertex(2);
        m.addEdge(2,5,2);
        m.addEdge(2,3,1);
        m.addEdge(2,12,38);
        m.addEdge(12,7,13);
        //m.printVertices();
        //m.printEdges();
        m.printEdgeList();
        Kruskal k = new Kruskal(m);
        m.printEdgeList();
        k.mst();
        k.printMST();
    }
}