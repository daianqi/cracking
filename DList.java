public class DList {
    private DListNode head;
    private DListNode tail;
    private int size;

    public DList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DList(int item) {
        head = new DListNode(item);
        tail = head;
        size = 1;
    }
    
    public int size() {
        return size;
    }
    
    public DListNode head() {
        return head;
    }
    
    public DListNode tail() {
        return tail;
    }
    
    public void insertFront(int item) {
        if(head == null) {
            head = new DListNode(item);
            tail = head;
        }
        head = head.setPrev(item);
        size++;
    }
    
    public void insertEnd(int item) {
        if(tail == null) {
            tail = new DListNode(item);
            head = tail;
        }
        else {
            tail = tail.setNext(item);
        }
        size++;
    }
    
}