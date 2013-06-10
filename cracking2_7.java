import java.lang.Integer;
import java.lang.Math;
import java.lang.System;

/*
Implement a function to check if a linked list is a palinfrome. (0->1->2->1->0, 0->1->2->2->1->0)
*/

public class cracking2_7 {

    public static void showList(SListNode n) {
        while(n != null) {
            System.out.print(n.item + "->");
            n = n.next;
        }
        System.out.println();
    }

    public static int length(SListNode n) {
        int length = 0;
        while(n != null) {
            length ++;
            n = n.next;
        }
        return length;
    }

    public static boolean checkPalinfrome(SListNode head) {
        result res = checkPalinfrome2(head, length(head));
        return res.result;
    }

    public static result checkPalinfrome2(SListNode head, int length) {
        //basic case, although only one will be handled
        if(head == null || length == 0)
            return new result(null, true);
        else if(length == 1)
            return new result(head.next, true);
        else if(length == 2) //genius!
            return new result(head.next.next, head.item == head.next.item);

        result res = checkPalinfrome2(head.next, length - 2); //head go one step further, length-2
        // cases except basics will be generated below, do things on them!
        if(!res.result || res.node == null)
            return res;
        else {  //stupid mind can't do this
            res.result = (res.node.item == head.item); //head is in front order, default by recursion
            res.node = res.node.next; //let res.node be in back order, one depth one level return
            return res;
        }
    }

    public static void main(String[] args) {
        SList myList = new SList();
        for(int i = 0;i<args.length;i++)
            myList.insertEnd(Integer.parseInt(args[i]));

        showList(myList.head());
        System.out.println(checkPalinfrome(myList.head())? "Yes" : "No");

    }
}
