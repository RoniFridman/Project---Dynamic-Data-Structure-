/**
 * we used linked list class to represent a queue or a stack 
 * @param <T> 
 */

public class LinkedList<T> {
    public Element<T> first;
    public Element<T> last;

    /**
     * innsert new object in element and adds it into a linked list.
     * if linked list is empty then creats new element and add it to be the first 
     * @param obj
     * @return : returns new created element 
     */
    public Element<T> add(T obj){
        if(this.first == null){
            this.first = new Element<>(obj, null);
            this.last = this.first;
            return this.first;
        }
        else {
            this.first.prev = new Element<>(obj, this.first);
            this.first = this.first.prev;
            return this.first;
        }
    }

    /**
     * removes first element from linked list and returns it, if linked list is empty returns null
     * @return returns first element in linked list  
     */
    public Element<T> pop(){
        Element<T> elem = this.first;
        if(elem == null || elem.next == null){
            this.first = null;
            this.last = null;
        }
        else {
            elem.next.prev = null;
            this.first = elem.next;
        }
        return elem;
    }

    /**
     * removes last element from linked list and returns it, if linked list is empty returns null
     * @return returns last element in linked list
     */
    public Element<T> remove(){
        Element<T> elem = this.last;
        if(elem == null || elem.prev == null){
            this.first = null;
            this.last = null;
        }
        else {
            elem.prev.next = null;
            this.last = elem.prev;
        }
        return elem;
    }

}
