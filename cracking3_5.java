/*
Implement a MyQueue class which implements a queue using two stacks.
*/

import java.lang.System;
import java.util.Stack;

public class cracking3_5 {
    
    public static Stack<Integer> forDequeue = new Stack<Integer>();
    public static Stack<Integer> forEnqueue = new Stack<Integer>();

    public static void enqueue(int d) {
        forEnqueue.push(d);
    }

    public static int dequeue() {
        if(forDequeue.size() == 0) {
            if(forEnqueue.size() == 0) {
                System.out.println("Empty queue!");
                return -1;
            } else {
                while(!forEnqueue.isEmpty()) {
                    forDequeue.push(forEnqueue.pop());
                }
            }
        }
        return forDequeue.pop();
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        enqueue(6);
        enqueue(7);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());

    }
}
