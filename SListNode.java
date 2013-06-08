public class SListNode {
    public int item;
    public SListNode next;

    public SListNode() {
        this(0, null);
    }
    
    public SListNode(int i, SListNode n) {
        item = i;
        next = n;
    }

    public SListNode(int i) {
        this(i,null);
    }
}