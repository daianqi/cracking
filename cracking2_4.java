/*
Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than
or equal to x.
*/

import java.lang.Math;
import java.lang.System;

public class cracking2_4 {
    public static SList randomLinkedList(int min, int max, int length) {
        SList myList = new SList();
        for(int i = 0;i<length;i++) {
            myList.insertEnd((int)(Math.random() * (max+1-min)+min));
        }
        return myList;
    }

    public static void showList(SList list) {
        SListNode n = list.head();
        while(n != null) {
            System.out.print(n.item + "->");
            n = n.next;
        }
        System.out.println();
    }

    public static SList partition(SList myList, int div) {
        SList before = new SList();
        SList after = new SList();
        SListNode n = myList.head();
        while(n!=null) {
            if(n.item < div){
//                System.out.println("smaller: "+ n.item);
                before.insertFront(n.item);
            }
            else{
//                System.out.println("larger: "+ n.item);
                after.insertFront(n.item);
            }
            n = n.next;
        }
        if(before.size() == 0) {
            return after;
        }
        else if(after.size() != 0) {
            before.addToTail(after.head());
            before.setTail(after.tail());
            before.setSize(before.size()+after.size());
        }
        return before;
    }

    public static void main(String[] args) {
        int min = 1;
        int max = 10;
        int length = 10;
        SList myList = randomLinkedList(min, max, length);
        showList(myList);
        int div = (int)(Math.random() * (max+1-min)+min);
        System.out.println("Partition by "+ div);
        SList tmp = partition(myList, div);
        showList(tmp);
//        System.out.println("SIZE " + tmp.size() + "tail value "+ tmp.tail().item);
    }
}
