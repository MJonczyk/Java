import java.util.Comparator;
public class EdgeComparator implements Comparator{
    public static final EdgeComparator INSTANCE = new EdgeComparator();
    public int compare(Object e, Object f) throws ClassCastException
    {
        return ((Edge)e).compareWeight((Edge)f);
    }
}
