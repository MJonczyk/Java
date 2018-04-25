public class Vertex{
    int value;
    Vertex parent;
    Vertex(int value){
        this.value = value;
        this.parent = null;
    }
    public String toString(){
        String s;
        if(this.parent != null) {
            s =  value + "  " + parent.value;
        }
        else{
            s =  value + " -1";
        }
        return s;
    }
}
