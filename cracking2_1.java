/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

import java.lang.System;
import java.util.Hashtable;
import java.lang.Integer;

public class cracking2_1 {
    public static void removeDuplicate(DListNode n) {
        Hashtable<Integer, Boolean> myTable = new Hashtable<Integer, Boolean>();
        DListNode tmp = null;
        while(n!=null) {
            if(!myTable.containsKey(n.item)) {
                myTable.put(n.item, true);
                tmp = n;
            }
            else{
                tmp.next = n.next;
                if(n.next != null)
                    n.next.prev = tmp;
            }
            n = n.next;
        }
    }

    public static void removeDuplicate2(DListNode n) {
        DListNode n1 = n;
        DListNode n2;
        while(n1 != null) {
            n2 = n1.next;
            while(n2 != null) {
                if(n2.item == n1.item) {
                    n1.next = n2.next;
                    if(n2.next != null)
                        n2.next.prev = n1; //stupid null pointer
                }
                n2 = n2.next;
            }
            n1 = n1.next;
        }

    }

    public static void showList(DListNode n) {
        while(n != null) {
            System.out.print(n.item + "->");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        if(args.length == 0)
            return;
        DList myList = new DList(Integer.parseInt(args[0]));

        for(int i = 1;i<args.length;i++) {
            myList.insertEnd(Integer.parseInt(args[i]));
        }

//        System.out.println("Size of the input list is " + myList.size());
        removeDuplicate2(myList.head());
        showList(myList.head());
    }
}

//important things to remember: 1) to check for the null pointer 2) to update the head or tail pointer as necessary