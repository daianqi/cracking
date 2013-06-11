public class MyStack {

    private int capacity;
    public StackNode top, bottom;
    public int size = 0;

    public MyStack(int capacity) {
        this.capacity = capacity;
    }
    public boolean isFull() {
        return this.size == capacity;
    }
    public void join(StackNode above, StackNode below) {
        if(above!=null) above.below = below;
        if(below!=null) below.above = above;
    }
    public boolean push(int v) {
        if (size>=capacity) return false;
        size++;
        StackNode n = new StackNode(v);
        if(size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }
    public int pop() {
        StackNode n = top;
        top = top.below;
        size--;
        return n.item;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int removeBottom() {
        StackNode n = bottom;
        bottom = bottom.above;
        if(bottom!=null) bottom.below = null; //whenever you are referencing any attribute, make sure they are not null
        size--;
        return n.item;
    }


//    private SListNode top;
//
//    public int pop() {
//        if(top == null)
//            return -1;
//        SListNode tmp = top;
//        top = top.next;
//        return tmp.item;
//    }
//
//    public void push(int i) {
//        SListNode tmp = new SListNode(i);
//        tmp.next = top;
//        top = tmp;
//    }
//
//    public int peek() {
//        if(top == null)
//            return -1;
//        return top.item;
//    }
}