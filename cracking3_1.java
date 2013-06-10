/*
Describe how you could use a single array to implement three stacks.
*/

import java.lang.Exception;
import java.lang.System;

public class cracking3_1 {
    static int number_of_stack = 3;
    static int default_size = 4;
    static int total_size = default_size*number_of_stack;
    static StackData[] stacks = {new StackData(0,default_size), new StackData(0,default_size), new StackData(0,default_size)};
    static int[] buffer = new int[total_size];

    public static int numberOfElements() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }

    public static int nextElement(int index) {
        if(index+1==total_size) return 0;
        else return index+1;
    }

    public static int previousElement(int index) {
        if(index == 0) return total_size-1;
        else return index-1;
    }

    public static void shift(int stackNum) {
        StackData stack = stacks[stackNum];
        if(stack.size >= stack.capacity) {
            int nextStack = (stackNum+1)%number_of_stack;
            shift(nextStack);
            stack.capacity++;
        }
        for(int i = (stack.start+stack.capacity-1)%total_size;stack.isWithinStack(i,total_size);i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)]; //stupid shift
        }
        buffer[stack.start] = 0;
        stack.start = nextElement(stack.start);
        stack.pointer = nextElement(stack.pointer);
        stack.capacity--;
    }

    public static void expand(int stackNum) {
        shift((stackNum+1)%number_of_stack);
        stacks[stackNum].capacity ++;
    }

    public static void push(int stackNum, int value) {
        StackData stack = stacks[stackNum];
        if(stack.size>=stack.capacity) {
            if(numberOfElements()>=total_size)
                System.out.println("Out of space");
            else
                expand(stackNum);
        }
        stack.size++;
        stack.pointer = nextElement(stack.pointer);
        buffer[stack.pointer] = value;
    }

    public static int pop(int stackNum) {
        StackData stack = stacks[stackNum];
        if(stack.size == 0)
            System.out.println("empty stack");
        int value = buffer[stack.pointer];
        buffer[stack.pointer] = 0;
        stack.pointer = previousElement(stack.pointer);
        stack.size--;
        return value;
    }

    public static int peek(int stackNum) {
        StackData stack = stacks[stackNum];
        return buffer[stack.pointer];
    }

    public static boolean isEmpty(int stackNum) {
        StackData stack = stacks[stackNum];
        return stack.size == 0;
    }

    public static void main(String[] args) {
        push(2, 4);
        System.out.println(peek(2));
        push(0, 3);
        push(0, 7);
        push(0, 5);
        push(0, 1);

        push(0, 2);
        push(0, 3);
        push(0, 4);
        push(0, 5);

        push(0, 6);

        System.out.println(peek(0));
        pop(0);
        System.out.println(peek(0));
        pop(0);
        System.out.println(peek(0));
    }
}