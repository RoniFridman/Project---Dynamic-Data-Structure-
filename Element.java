
public class Element<T> {
    public T obj;
    public Element<T> next;
    public Element<T> prev;

    /**
     * element constructor 
     * @param obj : Can be either a graph node or graph edge.
     * @param next : next element in linked list.
     */
    public Element(T obj,Element<T> next){
        this.obj = obj;
        this.next = next;
        this.prev = null;
        }
}