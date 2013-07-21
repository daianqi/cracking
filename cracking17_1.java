/*
Write a function to swap a number in place (that is, without temporary variables).
*/

import java.lang.System;

public class cracking17_1 {
    public static void swap1(int a, int b) {
        a = a - b; //diff
        b = b + a; //orig b + diff = new b
        a = b - a; //new b - diff = orig b
        System.out.println("After swap: a = "+ a + "; b = " + b);
    }

    public static void swap2(int a, int b) {
        a = a^b;   //just amazing!
        b = a^b;
        a = a^b;
        System.out.println("After swap: a = "+ a + "; b = " + b);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 50;
        System.out.println("Before swap: a = "+ a + "; b = " + b);
        swap1(a, b);
        swap2(a, b);
    }
}