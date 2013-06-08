public class DListNode {
    public int item;
    public DListNode next;
    public DListNode prev;

    public DListNode(int i, DListNode next, DListNode prev) {
        item = i;
        this.next = next;
        this.prev = prev;
    }

    public DListNode(int i) {
        this(i,null,null);
    }
    
    public DListNode setNext(int item) {
        DListNode newNode = new DListNode(item);
        this.next = newNode;
        newNode.prev = this;
        return newNode;
    }
    
    public DListNode setPrev(int item) {
        DListNode newNode = new DListNode(item);
        this.prev = newNode;
        newNode.next = this;
        return newNode;
    }
}