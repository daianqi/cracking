/*
Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
*/

import java.lang.Integer;
import java.lang.System;

public class cracking17_4 {
    public static int flip (int bit) {
        return 1^bit;
    }

    public static int posNeg (int num) {
        return flip((num>>31) & 0x1);//the highest digit==1 -> negative
    }

    //doesn't protect against overflow
    public static int maximumNum1 (int a, int b) {
        int sign = posNeg(a-b);
        int negSign = flip(sign);
        return a*sign + b*negSign;
    }
    //protect against overflow
    public static int maximumNum2 (int a, int b) {
        int signa = posNeg(a);
        int signb = posNeg(b);
        int signc = posNeg(a-b);

        //a and b pos and negative (^) -> use signa
        //otherwise use signc
        int use_signa = signa ^ signb; //diff = 1
        int use_signc = flip(use_signa);

        int finalChoice = use_signa*signa + use_signc*signc;
        int negFinalChoice = flip(finalChoice);

        return finalChoice*a + negFinalChoice*b;

    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE - 2;
        int b = -15;
        System.out.println("The larger one is: " + maximumNum1(a, b));
        System.out.println("The larger one is: " + maximumNum2(a, b));
    }
}