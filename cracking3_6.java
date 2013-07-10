/*
Write a program to sort a stack in ascending order (with biggest items on top). You may use at most one additional stack to hold
items, but you may not copy the elements into any other data structure (such as an array). The stack supports the following
operations: push, pop, peek and isEmpty.
*/

import java.lang.Integer;
import java.lang.System;
import java.util.Stack;

public class cracking3_6 {

    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> bufferStack = new Stack<Integer>();
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            while(!bufferStack.isEmpty() && tmp < bufferStack.peek())
                stack.push(bufferStack.pop());
            bufferStack.push(tmp);
        }
        return bufferStack;
    }

    public static void main(String[] args) {

        Stack<Integer> saveStack = new Stack<Integer>();

        saveStack.push(3);
        saveStack.push(9);
        saveStack.push(8);
        saveStack.push(2);
        saveStack.push(6);
        saveStack.push(10);
        saveStack.push(4);
        saveStack.push(7);
        saveStack.push(5);
        saveStack.push(1);

        saveStack = sort(saveStack);
        while(!saveStack.isEmpty()) {
            System.out.println(saveStack.pop());
        }
    }
}
