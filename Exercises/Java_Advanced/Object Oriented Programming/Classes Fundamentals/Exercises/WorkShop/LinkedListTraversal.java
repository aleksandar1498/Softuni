import java.util.Iterator;
import java.util.function.Consumer;
import java.lang.Integer;
public class LinkedListTraversal<Integer> implements Iterable<Integer>  {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    private int size=0;
    public LinkedListTraversal() {
        this.head=null;

        this.tail=null;
    }
    public void add(Integer val){
        Node current=new Node(val);
        if(head == null){
            head= tail = current;
        }else{
            current.prev = this.head ;
            this.head.next=current;
            this.head=current;
        }
        size++;
    }
    public boolean remove(Integer val){
        int index=0;
        Node currentNode=this.tail;
        while (currentNode != null){
            if(currentNode.val == val){
                if(index == 0){
                    // remove the first node
                    this.tail = this.tail.next;
                    if(this.tail == null){
                        this.head=null;
                    }else{
                        this.tail.prev=null;
                    }
                }else if(index == size-1){
                    this.head=this.head.prev;
                    if(this.head == null){
                        this.tail=null;
                    }else{
                        this.head.next=null;
                    }

                }else{
                    currentNode.prev.next=currentNode.next;
                    currentNode.next.prev=currentNode.prev;
                    currentNode.prev=null;
                    currentNode.next=null;
                }
                this.size--;
                return true;
            }

            currentNode=currentNode.next;
            index++;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Node currentNode=this.tail;
        while (currentNode != null){
            action.accept(currentNode.val);
            currentNode=currentNode.next;
        }

    }

     class Node{
        Node prev;
        Node next;
        Integer val;

         Node( Integer val) {
            this.prev = null;
            this.next = null;
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }
}
