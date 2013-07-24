/*
Write an algorithm which computes the number of trailing zeros in n factorial.
*/

import java.lang.System;

public class cracking17_3 {
    public static int factorOf5 (int value) {
        //I only count number%5 == 0 (5,10,15,20...)
        int res = 0;
        while(value%5 == 0) {
            res++;
            value /= 5;
        }
        return res;
    }

    public static int trailingZero2(int value) {
        int sum = 0;
        for(int i = 1;i <= value;i ++) {   //bug: 1 not 0
            sum += factorOf5(i);
        }
        return sum;
    }

    public static int trailingZero(int value) {
        int sum = 0;
        for(int factor = 5;value/factor > 0;factor *= 5) {
            sum += value/factor;
        }
        return sum;
    }
    public static void main(String[] args) {
        int value = 25;
        System.out.println("Number of Trailing Zero: "+trailingZero(value));
        System.out.println("Number of Trailing Zero2: "+trailingZero2(value));
    }
}
