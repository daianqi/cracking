public class SList {
    private SListNode head;
    private SListNode tail;
    private int size;

    public SList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    
    public SListNode head() {
        return head;
    }
    
    public SListNode tail() {
        return tail;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public void addToTail(SListNode n) {
        tail.next = n;
    }
    
    public void setTail(SListNode n) {
        tail = n;
    }
    
    public void setTailNext(SListNode n) {
        this.tail.next = n;
    }
    
    public void insertFront(int item) {
        if(head == null){
            head = new SListNode(item);
            tail = head;
        }else{
            head = new SListNode(item, head);
        }
        size++;
    }
    
    public void insertEnd(int item) {
        if(tail == null){
            tail = new SListNode(item);
            head = tail;
        }else{
            tail.next = new SListNode(item);
            tail = tail.next;
        }
        size++;
    }
    
}