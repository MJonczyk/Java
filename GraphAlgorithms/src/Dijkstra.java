import java.util.LinkedList;
public class Dijkstra {
    Graph G;
    int[] distances;

    Dijkstra(Graph G) {
        this.G = G;
        this.distances = new int[G.V];
    }
    public void dijkstra(int value){
        SSSP(value);
        readResult(value);
    }
    void readResult(int value){
        System.out.println("Result for vertex "+value);
        System.out.println("v "+"pre"+"  length");
        for(int i = 0;i < G.vList.size();i++){
            System.out.println(G.vList.get(i)+"   "+distances[i]);
        }
    }
    protected Vertex SSSP(int value){
        Vertex v = G.getVertex(value);
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        queue.add(v);
        v.parent = new Vertex(-1);

        for(int i = 0;i < G.vList.size();i++)
        {
            if(i == G.vList.indexOf(v)) {
                distances[i] = 0;
            }
            else {
                distances[i] = Integer.MAX_VALUE;
                queue.add(G.vList.get(i));
            }
        }
        Vertex current = queue.remove();
        while(!queue.isEmpty()) {
            for (Edge e : G.NList[G.vList.indexOf(current)]) {
                if (e.weight + distances[G.vList.indexOf(current)] < distances[G.vList.indexOf(e.u)]){
                    distances[G.vList.indexOf(e.u)] = e.weight + distances[G.vList.indexOf(current)];
                    e.u.parent = current;
                }
            }
            sortQueue(queue,distances);
            current = queue.remove();
        }
        return current;
    }
    void sortQueue(LinkedList<Vertex> queue, int[] distances){
        for(int i = 0;i < queue.size();i++){
            for(int j = 0;j < queue.size();j++){
                if(distances[G.vList.indexOf(queue.get(i))] < distances[G.vList.indexOf(queue.get(j))]){
                    Vertex temp = queue.get(i);
                    queue.set(i,queue.get(j));
                    queue.set(j,temp);
                }
            }
        }
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
        //m.printEdgeList();
        Dijkstra d = new Dijkstra(m);
        d.dijkstra(2);
    }
}
