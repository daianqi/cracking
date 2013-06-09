import java.lang.Math;
import java.lang.System;

/*
Given a circular list, implement an algorithm which returns the node at the beginning of the loop
*/

public class cracking2_6 {

    public static SList randomLinkedList(int min, int max, int length, int loopPoint) {
        SList myList = new SList();
        SListNode loop = null;
        for(int i = 0;i<length;i++) {
            myList.insertEnd((int)(Math.random() * (max+1-min)+min));

            if(loopPoint == i)
                loop = myList.tail();
        }
        myList.setTailNext(loop);
        return myList;
    }

    public static void showList(SListNode n, int length) {
        int i = 0;
        while(n != null && i<length+1) {
            System.out.print(n.item + "->");
            n = n.next;
            i++;
        }
        System.out.println();
    }

    public static int detectLoopPosition(SList myList) {
        SListNode slow = myList.head();
        SListNode fast = myList.head();
        while(fast!=null && fast.next!=null){ //check for sure no null pointer for .next
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }

        if(fast == null || fast.next ==null)
            return -1; //stupidly not judging loop

        fast = myList.head();
        int pos = 1;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
            pos++;
        }
        return pos;
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 20;
        int length = 7;
        int loopPoint = (int)(Math.random()*length);
        SList list = randomLinkedList(min, max, length, loopPoint);

        showList(list.head(), length);
        System.out.println("The loop starts at the " + detectLoopPosition(list)+"th node");
    }
}
