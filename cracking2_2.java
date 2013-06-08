/*
Implement an algorithm to find the kth to last element of a singly linked list
*/

import java.lang.Integer;

public class cracking2_2 {

    public static DList compose(String[] com) {
        DList myList = new DList();
        for(int i = 1;i<com.length;i++) {
            myList.insertEnd(Integer.parseInt(com[i]));
        }
        return myList;
    }

    public static void showList(DList myList) {
        DListNode n = myList.head();
        while(n != null) {
            System.out.print(n.item + "->");
            n = n.next;
        }
        System.out.println();
    }

    public static int findKth(DList myList, int kth) {
//        if(kth < 0)  return -1;
        DListNode n1 = myList.head();
        DListNode n2 = myList.head();
        for(int i =0;i<kth;i++) {
//            if(n1 == null) return -1;
            n1 = n1.next;
        }
//        if(n1 == null) return -1;

        while(n1.next != null) { //stupid null pointer
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2.item;
    }

    public static void main(String[] args) {
        if(args.length == 0 || Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[0]) >= args.length - 1)
            return;
        int kth = Integer.parseInt(args[0]);
        DList myList = compose(args);
        showList(myList);
        System.out.println(findKth(myList, kth));
    }
}