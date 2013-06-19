/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
*/

import java.lang.Math;
import java.lang.System;

public class cracking2_5 {

    public static SList randomLinkedList(int min, int max, int length) {
        SList myList = new SList();
        for(int i = 0;i<length;i++) {
            myList.insertEnd((int)(Math.random() * (max+1-min)+min));
        }
        return myList;
    }

    public static void showList(SListNode n) {
        while(n != null) {
            System.out.print(n.item + "->");
            n = n.next;
        }
        System.out.println();
    }

    //stupid iteration
//    public static SList addition(SList list1, SList list2) {
//        if(list1.size() == 0)
//            return list2;
//        else if(list2.size() == 0)
//            return list1;
//        SList result = new SList();
//        SListNode n1 = list1.head();
//        SListNode n2 = list2.head();
//        int carry = 0;
//        int add = 0;
//        while(n1 != null && n2 != null) {
//            add = n1.item + n2.item + carry;
//            carry = add/10;
//            result.insertEnd(add%10);
//            n1 = n1.next;
//            n2 = n2.next;
//        }
//        if(n1 == null && n2 == null){  //stupid doing
//            if(carry > 0)
//                result.insertEnd(carry);
//            return result;
//        }
//        else if(n1 == null) {
//            result.insertEnd(n2.item + carry);   //stupid doing ignore carry
//            n2 = n2.next;
//            while(n2 != null) {
//                result.insertEnd(n2.item);
//                n2 = n2.next;
//            }
//        }
//        else if(n2 == null) {
//            result.insertEnd(n1.item + carry);
//            n1 = n1.next;
//            while(n1 != null) {
//                result.insertEnd(n1.item);
//                n1 = n1.next;
//            }
//        }
//        return result;
//    }

    public static SListNode addition(SListNode n1, SListNode n2, int carry) {
        /*
        if both node is null, return null
        else:
            sum = n1.item + n2.item (if not null) + carry
            carry = sum/10

            result.item = sum%10
            result.setNext(addition(n1.next, n2.next, carry))

            return result
        */
        if(n1 == null && n2 == null && carry ==0)
            return null;
        SListNode result = new SListNode(carry);
        int sum = carry;
        if(n1 != null)
            sum += n1.item;
        if(n2 != null)
            sum+= n2.item;
        result.item = sum%10;
        if(n1 != null || n2 != null)
            result.setNext(addition(n1 == null? null: n1.next, n2 == null? null: n2.next, sum >= 10 ? 1:0));
        return result;
    }

    public static int length(SListNode n) {
        int length = 0;
        while(n != null) {
            length ++;
            n = n.next;
        }
        return length;
    }

    public static SListNode padding(SListNode n, int num) {
        while(num > 0) {
            SListNode tmp = new SListNode(0);
            tmp.setNext(n);
            n = tmp;
            num--;
        }
        return n;
    }

    public static SListNode insertBefore(SListNode n, int i) {
        SListNode newNode = new SListNode(i);
        newNode.next = n;
        return newNode;
    }

    /*
        if both node is null, return null
        else:
            return listnode + carry as an object sumCarry
            sumCarry addition2helper(n1.next,n2.next);

            sum = n1.item + n2.item (if not null) + sumCarry.carry
            newnode = insertBefore(sumCarry.listnode, sum%10)

            sumCarry.listnode = newnode
            sumCarry.carry = sum/10

            return result
            <the return listnode provides a base to insertBefore>
    */

    public static SumCarry addition2helper(SListNode n1, SListNode n2) {
        if(n1 == null && n2 == null){
            SumCarry sc = new SumCarry();
            return sc;
        }
        SumCarry sc = addition2helper(n1.next,n2.next);
        int addSum = n1.item+n2.item+sc.carry;
        SListNode result = insertBefore(sc.sum,addSum%10);

        sc.sum = result;
        sc.carry = addSum/10;

        return sc;

    }

    public static SListNode addition2(SListNode n1, SListNode n2) {
        n1 = length(n1)>length(n2)?n1:padding(n1,length(n2)-length(n1));
        n2 = length(n1)>length(n2)?padding(n2,length(n1)-length(n2)):n2;
        showList(n1);
        showList(n2);
        SumCarry result = addition2helper(n1,n2);

        if(result.carry == 0)        //stupidly forgetting the leftover carry
            return result.sum;
        else{
            SListNode resultNode = insertBefore(result.sum,result.carry);
            return resultNode;
        }
    }

    public static void main(String[] args) {
        int min = 0;
        int max = 9;
        int length1 = 2;
        int length2 = 3;
        SList list1 = randomLinkedList(min, max, length1);
        SList list2 = randomLinkedList(min, max, length2);

        System.out.println("Reverse Order Addition: ");
        showList(list1.head());
        showList(list2.head());
        SListNode tmp = addition(list1.head(), list2.head(), 0);
        showList(tmp);

        System.out.println("Decimal Order Addition: ");
        SListNode tmp2 = addition2(list1.head(), list2.head());
        showList(tmp2);
    }
}
