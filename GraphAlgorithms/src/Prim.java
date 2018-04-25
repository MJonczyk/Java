import java.util.LinkedList;

public class Prim {
    Graph G;
    LinkedList<Edge> tree;
    int treeWeight;
    EdgeComparator  ec;

    Prim(Graph G) {
        this.G = G;
        this.tree = new LinkedList<Edge>();
        this.treeWeight = 0;
        this.ec = new EdgeComparator();
        for(int i = 0;i < G.V;i++) G.makeSet(G.vList.get(i));
        G.eList.sort(ec);
    }
    void mst(){
        Vertex v = G.vList.get(0);
        LinkedList<Edge> queue = new LinkedList<>();
        while(tree.size() < G.V - 1){
            for(Edge e : G.eList){
                if((e.v == v || e.u == v) && !e.marked){
                    e.marked = true;
                    queue.add(e);
                }
            }
            queue.sort(ec);
            printQueue(queue);
            Edge temp = queue.remove();
            if(G.find(temp.v) != G.find(v)){
                G.union(v,temp.v);
                v = temp.v;
                tree.add(temp);
                treeWeight+=temp.weight;
            }
            else{
                if(G.find(temp.u) != G.find(v)) {
                    G.union(v, temp.u);
                    v = temp.u;
                    tree.add(temp);
                    treeWeight+=temp.weight;
                }
            }
        }
    }
    void printMST(){
        System.out.println("MST");
        for(Edge e : tree){
            System.out.println(e.weight+" ("+e.v.value+","+e.u.value+")");
        }
        System.out.println("Weight MST: "+treeWeight);
    }
    void printQueue(LinkedList<Edge> queue){
        System.out.println("Queue");
        for(Edge e : queue){
            System.out.println(e.weight+" ("+e.v.value+","+e.u.value+")");
        }
        System.out.println();
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
        m.printEdgeList();
        Prim p = new Prim(m);
        m.printEdgeList();
        p.mst();
        p.printMST();
    }
}