/*
How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
Push, pop and min should all operate in O(1) time.
*/

import java.lang.System;

public class cracking3_2 {
    public static SListNode top = null;
    public static SListNode minTop = null;

    public static void myPush(int i) {
        if(top == null) {
            top = new SListNode(i);
            minTop = new SListNode(i);
        }else {
            SListNode tmp = new SListNode(i);
            tmp.next = top;
            top = tmp;
            if(i<= minTop.item) {
                SListNode minTmp = new SListNode(i);
                minTmp.next = minTop;
                minTop = minTmp;
            }
        }
    }

    public static int myPop() {
        if(top == null)
            return -1;
        else {
            int tmp = top.item;
            if(tmp == minTop.item) {
                minTop = minTop.next;
            }
            top = top.next;
            return tmp;
        }
    }

    public static int myMin() {
        if(minTop == null)
            return -1;
        else return minTop.item;
    }

    public static void main(String[] args) {
        myPush(7);
        myPush(4);
        myPush(5);
        myPush(2);
        myPush(2);
        System.out.println("The minimum number is: "+ myMin());
        myPop();
        System.out.println("The minimum number is: "+ myMin());
        myPop();
        System.out.println("The minimum number is: "+ myMin());
        myPop();
        System.out.println("The minimum number is: "+ myMin());
        myPop();
        System.out.println("The minimum number is: "+ myMin());
        myPop();
        System.out.println("The minimum number is: "+ myMin());
    }
}
