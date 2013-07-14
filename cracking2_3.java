/*
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
*/

import java.lang.System;

public class cracking2_3 {
    
    public static SList compose(String[] com) {
        SList myList = new SList();
        for(int i = 0;i<com.length;i++) {
            myList.insertEnd(Integer.parseInt(com[i]));
        }
        return myList;
    }

    public static void showList(SList myList) {
        SListNode n = myList.head();
        while(n != null) {
            System.out.print(n.item + "->");
            n = n.next;
        }
        System.out.println();
    }

    public static void deleteMiddleNode(SListNode n) {
        if(n.next == null) n = null;      //stupid doing: cannot delete if it's the last node in the linked list
        else{
            n.item = n.next.item;
            n.next = n.next.next;
        }
    }

    public static void main(String[] args) {
        SList myList = compose(args);
        System.out.println("The original Linked List: ");
        showList(myList);
        int random = (int) (Math.random() * args.length) + 1;
        System.out.println("No." + random + " node to be deleted!");
        SListNode n = myList.head();
        for(int i = 1;i<random;i++) {
            n = n.next;
        }
        deleteMiddleNode(n);
        System.out.println("The Linked List after delete:");
        showList(myList);
    }
}
